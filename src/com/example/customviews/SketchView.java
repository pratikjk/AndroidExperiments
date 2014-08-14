package com.example.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SketchView extends View {

    private Paint mPaint;
    private Path mSignaturePath;
    private static final String TAG = SketchView.class.getSimpleName();

    public SketchView(Context context) {
        this(context, null);
    }

    public SketchView(Context context, AttributeSet as) {
        this(context, as, 0);
    }

    public SketchView(Context context, AttributeSet as, int defStyle) {
        super(context, as, 0);
        setBackgroundColor(Color.GRAY);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Style.STROKE);
        mSignaturePath = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int action = event.getActionMasked();
        float touchX = event.getX();
        float touchY = event.getY();
        switch (action) {
        case MotionEvent.ACTION_DOWN:
            mSignaturePath.moveTo(touchX, touchY);
            invalidate();
            break;
        case MotionEvent.ACTION_MOVE:
        case MotionEvent.ACTION_UP:
            mSignaturePath.lineTo(touchX, touchY);
            invalidate();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mSignaturePath, mPaint);
    }

    public void clear() {
        mSignaturePath.reset();
        invalidate();
    }

}
