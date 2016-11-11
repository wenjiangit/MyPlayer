package com.douliu.myplayer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.douliu.myplayer.R;
import com.douliu.myplayer.utils.SystemUtils;

/**
 * Created by douliu on 2016/11/9.
 */
public class Indicator extends View {

    //背景色
    private int mBackColor = R.color.colorHint;
    //前景色
    private int mForeColor = R.color.subject_color;

    private Paint mPaint;

    private int mSize;
    //圆半径
    private int mRadius;

    private float mCenterX;

    private float mStartX;

    private float mCenterY;

    private int mWidth;

    private int mHeight;

    public Indicator(Context context) {
        super(context,null);
    }

    public Indicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(mBackColor));
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);
        mRadius = SystemUtils.dp2px(getContext(),5);
        mStartX = mRadius;
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
        //绘制背景圆
        for (int i = 0;i < mSize;i++){
            canvas.drawCircle(mStartX + 3 * mRadius * i,mCenterY,mRadius,mPaint);
        }
        //绘制前景圆
        mPaint.setColor(getResources().getColor(mForeColor));
        canvas.drawCircle(mStartX,mCenterY,mRadius,mPaint);

    }

    public void setBackColor(int backColor) {
        mBackColor = backColor;
        invalidate();
    }

    public void setForeColor(int foreColor) {
        mForeColor = foreColor;
        invalidate();
    }

    public void setRadius(int radius) {
        mRadius = SystemUtils.dp2px(getContext(),radius);
        invalidate();
    }

    public void setSize(int size) {
        mSize = size;
        invalidate();
    }
}
