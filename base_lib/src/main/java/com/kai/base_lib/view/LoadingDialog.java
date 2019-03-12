package com.kai.base_lib.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.kai.base_lib.R;

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context, int themeResId) {
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
        private ImageView imageView;
        private Animation rotateAnimation;

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
            imageView = loadingDialog.findViewById(R.id.iv_loading_dialog);
            titleTv.setText(text);
            titleTv.setTextSize(textSize);
            titleTv.setTextColor(mContext.getResources().getColor(textColor));
            titleTv.setVisibility(visible);
            rotateAnimation = AnimationUtils.loadAnimation(mContext,R.anim.dialog_anim);
            loadingDialog.setCancelable(false);
            imageView.setAnimation(rotateAnimation);
            return loadingDialog;
        }
    }
}
