package com.kai.base_lib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kai.base_lib.utils.StatusBarUtil;
import com.kai.base_lib.view.LoadingDialog;
import com.kai.base_lib.view.ToolBar;

public abstract class BaseActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private ViewGroup.LayoutParams params;
    private ToolBar toolbar;
    private boolean useToolbar = true;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRoot();
        initToolBar();
        toolbar.setFitsSystemWindows(true);
        StatusBarUtil.setTranslucent(this);
        setContentView(bindLayoutId());
        loadingDialog = new LoadingDialog.Builder(this).create();
        initView();
    }

    protected abstract void initRoot();

    private void initToolBar() {
        linearLayout = new LinearLayout(this);
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        toolbar = new ToolBar(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams toolBarParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(toolbar, toolBarParams);
    }

    public abstract int bindLayoutId();

    public abstract void initView();

    public void useToolbar(boolean use) {
        this.useToolbar = use;
    }

    public void startLoading(){
        loadingDialog.show();
    }

    public void dismissLoading(){
        loadingDialog.dismiss();
    }

    @Override
    public void setContentView(View view) {
        if (useToolbar) {
            linearLayout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            super.setContentView(linearLayout);
        } else super.setContentView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (useToolbar) {
            linearLayout.addView(LayoutInflater.from(this).inflate(layoutResID, linearLayout, false));
            super.setContentView(linearLayout);
        } else super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (useToolbar) {
            linearLayout.addView(view, params);
            super.setContentView(linearLayout);
        } else super.setContentView(view, params);
    }
}
