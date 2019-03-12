package com.kai.base_lib.view;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kai.base_lib.R;

public class ToolBar extends Toolbar {
    private Context mContext;
    private View view;
    private ImageView startIv;

    private TextView leftTv;
    private ImageView leftIv;

    private TextView rightTv;
    private ImageView rightIv;

    private TextView endTv;
    private ImageView endIv;

    private TextView titleTv;

    public ToolBar(Context context) {
        super(context);
        this.mContext = context;
        view = LayoutInflater.from(context).inflate(R.layout.toolbar, null);
        addView(view,new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,Toolbar.LayoutParams.WRAP_CONTENT));
        this.setContentInsetsRelative(0,0);
        this.setContentInsetsAbsolute(0,0);
        this.setContentInsetStartWithNavigation(0);
        this.setContentInsetEndWithActions(0);
        initView();
    }

    private void initView() {
        startIv = view.findViewById(R.id.iv_start_toolbar);

        leftTv = view.findViewById(R.id.tv_left_toolbar);
        leftIv = view.findViewById(R.id.iv_left_toolbar);

        rightTv = view.findViewById(R.id.tv_right_toolbar);
        rightIv = view.findViewById(R.id.iv_right_toolbar);

        endTv = view.findViewById(R.id.tv_end_toolbar);
        endIv = view.findViewById(R.id.iv_end_toolbar);

        titleTv = view.findViewById(R.id.tv_title_toolbar);
    }

    public void setStartImage(@DrawableRes int drawable) {
        startIv.setImageResource(drawable);
    }

    public void setLeftImage(@DrawableRes int drawable) {
        leftTv.setVisibility(View.GONE);
        leftIv.setVisibility(View.VISIBLE);
        leftIv.setImageResource(drawable);
    }

    public void setLeftText(String text, int textSize, @ColorRes int textColor) {
        leftTv.setVisibility(View.VISIBLE);
        leftIv.setVisibility(View.GONE);
        leftTv.setText(text);
        leftTv.setTextColor(mContext.getResources().getColor(textColor));
        leftTv.setTextSize(textSize);
    }

    public void setTitleText(String text, int textSize, @ColorRes int textColor) {
        titleTv.setText(text);
        titleTv.setTextColor(mContext.getResources().getColor(textColor));
        titleTv.setTextSize(textSize);
    }

    public void setRightImage(@DrawableRes int drawable) {
        rightTv.setVisibility(View.GONE);
        rightIv.setVisibility(View.VISIBLE);
        rightIv.setImageResource(drawable);
    }

    public void setRightText(String text, int textSize, @ColorRes int textColor) {
        rightTv.setVisibility(View.VISIBLE);
        rightIv.setVisibility(View.GONE);
        rightTv.setText(text);
        rightTv.setTextColor(mContext.getResources().getColor(textColor));
        rightTv.setTextSize(textSize);
    }

    public void setEndImage(@DrawableRes int drawable) {
        endTv.setVisibility(View.GONE);
        endIv.setVisibility(View.VISIBLE);
        endIv.setImageResource(drawable);
    }

    public void setEndText(String text, int textSize, @ColorRes int textColor) {
        endTv.setVisibility(View.VISIBLE);
        endIv.setVisibility(View.GONE);
        endTv.setText(text);
        endTv.setTextColor(mContext.getResources().getColor(textColor));
        endTv.setTextSize(textSize);
    }


}
