package com.douliu.myplayer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.douliu.myplayer.R;

/**
 * Created by douliu on 2016/11/9.
 */
public class CircleView extends View {

    //背景色
    private int mBackColor = R.color.colorHint;
    //前景色
    private int mForeColor = R.color.subject_color;

    private Paint mPaint;

    private int mSize;
    //圆半径
    private int mRadius;

    private float mCenterX;

    private float mCenterY;

    public CircleView(Context context) {
        super(context,null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(mBackColor));
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w/2;
        mCenterY = h/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mCenterX,mCenterY);

    }
}
