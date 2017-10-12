package com.customview.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.customview.bean.PieData;

import java.util.ArrayList;
import java.util.List;

public class PieView extends View {

    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private List<PieData> mData = new ArrayList();
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);//抗锯齿
        Log.e(TAG,"PieView");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG,"onMeasure");

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.e(TAG,"onSizeChanged");
    }

    private String TAG = "=======";

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        Log.e(TAG,"onLayout");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float currentStartAngle = mStartAngle;                      // 当前起始角度
        //移动坐标系
        canvas.translate(mWidth / 2, mHeight / 2);           // 将画布坐标原点移动到中心位置,
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);    // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);


        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();

            // canvas.save();//保存当前状态
            // canvas.translate(-mWidth / 2, -mHeight / 2);
            //canvas.restore();//回滚到上一次保存的状态
        }
        Log.e(TAG,"onDraw");

    }

    public void setData(List<PieData> list) {
        initData(list);
        invalidate();
        Log.e(TAG,"setData");
    }

    private void initData(List<PieData> list) {
        //计算数值总和
        float valueAll = 0;
        for (int i = 0; i < list.size(); i++) {
            valueAll += list.get(i).getValue();
        }

        for (int i = 0; i < list.size(); i++) {
            float percent = list.get(i).getValue() / valueAll;
            float angle = percent * 360;

            PieData pieData = new PieData();
            pieData.setPercentage(percent);
            pieData.setAngle(angle);
            pieData.setColor(mColors[i]);
            pieData.setName(i + "");
            mData.add(pieData);
        }


    }


}