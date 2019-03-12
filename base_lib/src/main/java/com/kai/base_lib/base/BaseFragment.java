package com.kai.base_lib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kai.base_lib.utils.StatusBarUtil;
import com.kai.base_lib.view.ToolBar;

public abstract class BaseFragment extends Fragment {

    private ToolBar toolBar;
    private LinearLayout linearLayout;
    private Activity activity;
    private ViewGroup.LayoutParams params;
    private boolean useToolbar = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRoot();
        initToolBar();
        StatusBarUtil.setTranslucent(activity);
        if (useToolbar) {
            return linearLayout;
        } else return inflater.inflate(bindLayout(), null);
    }

    protected abstract void initRoot();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initClickListener(view);
    }

    protected abstract void initClickListener(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    protected abstract void initData(Bundle savedInstanceState);

    public abstract void initView(View view);

    public abstract int bindLayout();

    private void initToolBar() {
        linearLayout = new LinearLayout(activity);
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        toolBar = new ToolBar(activity);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams toolBarParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(toolBar, toolBarParams);
    }

    public void useToolBar(boolean use) {
        this.useToolbar = use;
    }
}
