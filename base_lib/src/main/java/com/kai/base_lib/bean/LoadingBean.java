package com.kai.base_lib.bean;

import com.kai.base_lib.view.CircleLoadView;

public class LoadingBean {
    private int outColor;
    private int arcColor;
    private float interval;
    private CircleLoadView.Type type;

    public int getOutColor() {
        return outColor;
    }

    public void setOutColor(int outColor) {
        this.outColor = outColor;
    }

    public int getArcColor() {
        return arcColor;
    }

    public void setArcColor(int arcColor) {
        this.arcColor = arcColor;
    }


    public float getInterval() {
        return interval;
    }

    public void setInterval(float interval) {
        this.interval = interval;
    }

    public CircleLoadView.Type getType() {
        return type;
    }

    public void setType(CircleLoadView.Type type) {
        this.type = type;
    }
}
