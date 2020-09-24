package com.android.mvp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private final String TAG = CustomSurfaceView.class.getSimpleName();
    private SurfaceHolder holder;
    /**
     * 用于绘图的Canvas
     */
    private Canvas mCanvas;
    /**
     * 线程标志位
     */
    private boolean mIsDrawing;

    public CustomSurfaceView(Context context) {
        super(context);
        init();
    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(() -> {
            while (mIsDrawing) {
                try {
                    mCanvas = holder.lockCanvas();
                    // draw sth绘制过程
                    Paint paint = new Paint();
                    paint.setColor(Color.RED);
                    mCanvas.drawText("Hello", 30, 30, paint);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //保证每次都将绘图的内容提交
                    if (mCanvas != null) {
                        holder.unlockCanvasAndPost(mCanvas);
                    }
                }
            }
        }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }
}
