package com.example.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class DrawableView extends View {

    Paint p;
    float[] data;

    public DrawableView(Context context) {
        this(context, null);
    }

    public DrawableView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public DrawableView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        p = new Paint();
        data = getRandomData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // can safely ignore the super call since its empty method in View
        // super.onDraw(canvas);
        // drawLine(canvas);
        drawLineChart(canvas, data);
    }

    private void drawLine(Canvas canvas) {
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStrokeWidth(4);
        p.setStyle(Style.STROKE);

        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getWidth() - getPaddingRight();
        int bottom = getHeight() - getPaddingBottom();

        canvas.drawLine(left, top, right, bottom, p);
    }

    private void drawLineChart(Canvas canvas, float[] yPoints) {
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStrokeWidth(4);
        p.setStyle(Style.STROKE);
        p.setShadowLayer(4, 5, 5, Color.parseColor("gray"));
        Path lineChart = new Path();
        float maxValue = getMaxValue(yPoints);
        lineChart.moveTo(getXPos(0, yPoints.length),
                getYPos(yPoints[0], maxValue));
        for (int i = 1; i < yPoints.length; i++) {
            lineChart.lineTo(getXPos(i, yPoints.length),
                    getYPos(yPoints[i], maxValue));
        }
        canvas.drawPath(lineChart, p);
    }

    private float getXPos(int i, float max) {
        float xPos = 0;
        float width = getWidth() - getPaddingRight() - getPaddingLeft();
        xPos = i / max * width;
        xPos += getPaddingLeft();
        return xPos;
    }

    private float getMaxValue(float[] yPoints) {
        float max = 0;
        for (int i = 0; i < yPoints.length; i++) {
            max = max < yPoints[i] ? yPoints[i] : max;
        }
        return max;
    }

    private float getYPos(float value, float maxValue) {

        float scaledValue = 0;
        float height = getHeight() - getPaddingTop() - getPaddingBottom();
        scaledValue = height * value / maxValue;
        scaledValue = height - scaledValue;
        scaledValue += getPaddingTop();
        return scaledValue;
    }

    private float[] getRandomData() {
        return new float[] { 10, 12, 7, 14, 15, 19, 13, 2, 10, 13, 13, 10, 15,
                14 };
    }

    public void showCyclingData() {
        float[] destData = new float[] { 7, 14, 15, 19, 10, 2, 3, 13, 0, 3, 6,
                14, 10, 12 };

        invalidate();
    }

    public void showRunningData() {
        data = new float[] { 0, 3, 6, 14, 19, 10, 2, 3, 13, 10, 12, 7, 14, 15 };
        invalidate();
    }

    public void showDancingData() {
        data = new float[] { 10, 12, 7, 14, 15, 19, 13, 2, 10, 13, 13, 10, 15,
                14 };
        invalidate();
    }

}
