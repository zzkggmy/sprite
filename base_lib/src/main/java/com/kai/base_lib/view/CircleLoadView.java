package com.kai.base_lib.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kai.base_lib.bean.LoadingBean;

import java.lang.ref.WeakReference;

public class CircleLoadView extends View {
    private float radius = 0;
    private float inRadius = 0;
    private float width = 0;
    private float height = 0;

    private float interval;

    private MyHandler myHandler = new MyHandler(this);

    private int startAngle = 90;
    private int sweepAngle = 30;

    private RectF rectF;

    private Paint outPaint = new Paint();
    private Paint inPaint = new Paint();
    private Paint arcPaint = new Paint();

    private Type type = Type.round;

    public CircleLoadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        outPaint.setAntiAlias(true);
        outPaint.setStyle(Paint.Style.FILL);
        outPaint.setColor(Color.BLACK);

        inPaint.setAntiAlias(true);
        inPaint.setStyle(Paint.Style.FILL);
        inPaint.setColor(Color.WHITE);

        arcPaint.setAntiAlias(true);
        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
        radius = Math.min(w, h) / 2;
        inRadius = radius - interval;
        rectF = new RectF(0, 0, w, h);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2, height / 2, radius, outPaint);
        if (type == Type.round) {
            sweepAngle += 30;
            if (sweepAngle >= 360)
                sweepAngle = 0;
            canvas.drawArc(rectF, 0, sweepAngle, true, arcPaint);
            canvas.drawCircle(width / 2, height / 2, inRadius, inPaint);
            myHandler.sendEmptyMessageDelayed(1024, 50);
        } else {
            sweepAngle = 120;
            if (startAngle >= 360)
                startAngle = 0;
            canvas.drawArc(rectF, startAngle, sweepAngle, true, arcPaint);
            canvas.drawCircle(width / 2, height / 2, inRadius, inPaint);
            startAngle += sweepAngle;
            myHandler.sendEmptyMessageDelayed(1024, 100);
        }
    }

    @SuppressLint("HandlerLeak")
    private class MyHandler extends Handler {
        WeakReference<CircleLoadView> root;

        private MyHandler(CircleLoadView circleLoadView) {
            root = new WeakReference<>(circleLoadView);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1024:
                    invalidate();
                    break;
            }
        }
    }

    public void setData(LoadingBean loadingBean) {
        outPaint.setColor(loadingBean.getOutColor());
        arcPaint.setColor(loadingBean.getArcColor());
        interval = loadingBean.getInterval();
        type = loadingBean.getType();
    }

    public void stopAnim() {
        myHandler.removeMessages(1024);
    }

    public enum Type {
        round,
        section;
    }
}