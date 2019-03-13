package com.kai.base_lib.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.kai.base_lib.R;
import com.kai.base_lib.bean.LoadingBean;

public class LoadingDialog extends Dialog {

    private LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context mContext;
        private View view;
        private TextView titleTv;
        private String text = "加载中...";
        private float textSize = 14;
        private @ColorRes
        int textColor = R.color.black_3;
        private int visible = View.VISIBLE;
        private CircleLoadView circleLoadView;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(String title) {
            this.text = title;
            return this;
        }

        public Builder setTitle(String title, float textSize) {
            this.text = title;
            this.textSize = textSize;
            return this;
        }

        public Builder setTitle(String title, float textSize, @ColorRes int textColor) {
            this.text = title;
            this.textSize = textSize;
            this.textColor = textColor;
            return this;
        }

        public Builder setTitleVisibility(int visible) {
            this.visible = visible;
            return this;
        }

        public LoadingDialog create() {
            LoadingDialog loadingDialog = new LoadingDialog(mContext, R.style.dialog);
            loadingDialog.setContentView(R.layout.loading_dialog_view);
            titleTv = loadingDialog.findViewById(R.id.tv_title_loading_dialog);
            circleLoadView = loadingDialog.findViewById(R.id.clv_loading_dialog);
            titleTv.setText(text);
            titleTv.setTextSize(textSize);
            titleTv.setTextColor(mContext.getResources().getColor(textColor));
            titleTv.setVisibility(visible);
            loadingDialog.setCancelable(false);
            LoadingBean loadingBean = new LoadingBean();
            loadingBean.setType(CircleLoadView.Type.round);
            loadingBean.setInterval(6);
            loadingBean.setOutColor(mContext.getResources().getColor(R.color.color_b0b0b0));
            loadingBean.setArcColor(mContext.getResources().getColor(R.color.color_71E0C0));
            circleLoadView.setData(loadingBean);
            return loadingDialog;
        }
    }
}