package com.android.mvp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class AudioWaveView extends SurfaceView implements SurfaceHolder.Callback {
    private final String TAG = AudioWaveView.class.getSimpleName();
    private SurfaceHolder surfaceHolder;
    /**
     * 用于绘图的Canvas
     */
    private int cornerRadius;
    private int rectfNumber;
    /**
     * 存放矩形
     */
    private List<RectF> rectFS = new ArrayList<RectF>();

    private Paint paint;

    private int viewWidth;
    private int viewHeight;
    /**
     * 每个条的宽度
     */
    private int rectWidth;
    /**
     * 条间距
     */
    private final int space = 6;
    /**
     * 条随机高度
     */
    private int randomHeight;
    private Random random;

    private Disposable subscribe;

    public AudioWaveView(Context context) {
        super(context);
        init();
    }

    public AudioWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AudioWaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        cornerRadius = 2;
        rectfNumber = 15;
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        random = new Random();
        initRect();
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }

    private void initRect() {
        for (int i = 0, size = rectfNumber; i < size; i++) {
            RectF rectF = new RectF();
            rectFS.add(rectF);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated>>>");
        viewWidth = getWidth();
        viewHeight = getHeight();
        rectWidth = (viewWidth - space * (rectfNumber - 1)) / rectfNumber;
        subscribe = Observable.interval(0, 300, TimeUnit.MILLISECONDS)
                .subscribe(v -> {
                    Canvas canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.MAGENTA);
                    Log.i(TAG, String.format("name:%s mcanvas:%b", Thread.currentThread().getName(), (canvas == null)));
                    int left = rectWidth + space;
                    //画每个条之前高度都重新随机生成
                    for (int i = 0, size = rectFS.size(); i < size; i++) {
                        randomHeight = random.nextInt(viewHeight);
                        rectFS.get(i).set(left * i, randomHeight, left * i + rectWidth, viewHeight);
                    }
                    for (int i = 0; i < rectFS.size(); i++) {
                        RectF rectF = rectFS.get(i);
                        if (canvas != null) {
                            canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
                        }
                    }
                    //保证每次都将绘图的内容提交
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                });

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged>>>");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed>>>");
        if (subscribe != null && !subscribe.isDisposed()) {
            subscribe.dispose();
        }
    }
}
