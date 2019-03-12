package com.kai.sprite;

import com.kai.base_lib.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void initRoot() {

    }

    @Override
    public int bindLayoutId() {
        useToolbar(false);
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        startLoading();
    }
}