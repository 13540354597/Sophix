package com.customview.test;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by TR 105 on 2017/9/12.
 */

public class LoadingView extends View {

    private String TAG = "=======";
    // 用于控制绘制的进度条距离左／上／下的距离
    private static final int LEFT_MARGIN = 9;
    // 用于控制绘制的进度条距离右的距离
    private static final int RIGHT_MARGIN = 25;

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, "LoadingView");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure");
    }

    private int progressWidth = 0;
    private int progressHeight = 0;
    private int r = 0;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged");
        progressWidth = w;
        progressHeight = h;
        r = (h - LEFT_MARGIN * 2) / 2;


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw");
    }
}
