package com.lyc.ui.uilibrary.circle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lyc.ui.uilibrary.R;

/**
 * Created by liangyc
 * Time :2018/4/12
 * Des:
 */

public class HollowCircleView extends View {

    //空心圆
    private Paint mCircleHollowPanit;
    private int mCircleHollowColor;
    private float mCircleHollowWidth;

    int mHeight;
    int mWight;

    //画板范围
    private RectF mRectF;
    private float mRadius;

    public HollowCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HollowCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Hollow_Circle);

        mCircleHollowColor=typedArray.getColor(R.styleable.Hollow_Circle_broder_color, Color.RED);
        mCircleHollowWidth=typedArray.getDimension(R.styleable.Hollow_Circle_broder_width,10);

        typedArray.recycle();

        mCircleHollowPanit = new Paint();
        mCircleHollowPanit.setStyle(Paint.Style.STROKE);
        mCircleHollowPanit.setStrokeWidth(mCircleHollowWidth);
        mCircleHollowPanit.setColor(mCircleHollowColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipRect(mRectF);
        canvas.drawCircle(mWight / 2, mHeight / 2, mRadius, mCircleHollowPanit);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight = getMeasuredHeight();
        mWight = getMeasuredWidth();

        mHeight = Math.min(mHeight, mWight);
        mWight = mHeight;

        float x = mWight / 2, y = mWight / 2;

        mRadius = x -  mCircleHollowWidth / 2;


        mRectF.top = 0;
        mRectF.left = 0;
        mRectF.bottom = mWight;
        mRectF.right = mWight;



        setMeasuredDimension(mWight, mHeight);
    }


}
