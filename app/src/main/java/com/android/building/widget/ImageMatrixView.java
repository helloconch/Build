package com.android.building.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class ImageMatrixView extends View {


    public ImageMatrixView(Context context) {
        super(context);
    }

    public ImageMatrixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔用于绘制圆和刻度
        Paint paintLine = new Paint();
        paintLine.setColor(Color.RED);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setTextSize(20);
        paintLine.setAntiAlias(true);
        //画笔用于绘制指针
        Paint paintPointer = new Paint();
        paintPointer.setStrokeWidth(10);
        //获取圆的半径
        float radius = Math.min(getWidth() / 2, getHeight() / 2);

        //画圆周
        canvas.drawCircle(radius, radius, radius, paintLine);
        //变化坐标系,改变后，坐标原点在(radius, radius),x轴正方形水平向右，y轴正方向水平向下
        canvas.translate(radius, radius);

        //保存坐标系信息
        canvas.save();

        //画圆上的点
        for (int i = 0; i < 12; i++) {
            if (i % 3 == 0) {
                canvas.drawLine(0, -radius, 0, -(radius - 20), paintLine);
            } else {
                canvas.drawLine(0, -radius, 0, -(radius - 10), paintLine);
            }
            canvas.drawText(String.valueOf(i), 0, -(radius - 24), paintLine);
            //将坐标系顺时针旋转30度，
            canvas.rotate(30, 0, 0);
        }

        //回到上次保存的状态：坐标原点在（radius, radius）,x轴正方向水平向右，y轴正方向水平向下
        canvas.restore();
        //在保存的状态上继续改变坐标轴
        canvas.rotate(30);
        //绘制指针
        canvas.drawLine(0, 0, 40, 0, paintPointer);
        canvas.rotate(30);
        canvas.drawLine(0, 0, 60, 0, paintLine);
    }


}
