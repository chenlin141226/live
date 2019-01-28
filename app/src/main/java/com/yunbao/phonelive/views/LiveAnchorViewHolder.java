package com.yunbao.phonelive.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yunbao.phonelive.R;
import com.yunbao.phonelive.activity.LiveAnchorActivity;

/**
 * Created by cxf on 2018/10/9.
 * 主播直播间逻辑
 */

public class LiveAnchorViewHolder extends AbsLiveViewHolder {

    private ImageView mBtnFunction;
    private View mBtnGameClose;//关闭游戏的按钮
    private View mBtnPk;//主播连麦pk按钮
    private Drawable mDrawable0;
    private Drawable mDrawable1;

    public LiveAnchorViewHolder(Context context, ViewGroup parentView) {
        super(context, parentView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_live_anchor;
    }

    @Override
    public void init() {
        super.init();
        mDrawable0 = ContextCompat.getDrawable(mContext, R.mipmap.icon_live_func_0);
        mDrawable1 = ContextCompat.getDrawable(mContext, R.mipmap.icon_live_func_1);
        mBtnFunction = (ImageView) findViewById(R.id.btn_function);
        mBtnFunction.setImageDrawable(mDrawable0);
        mBtnFunction.setOnClickListener(this);
        mBtnGameClose = findViewById(R.id.btn_close_game);
        mBtnGameClose.setOnClickListener(this);
        findViewById(R.id.btn_close).setOnClickListener(this);
        mBtnPk = findViewById(R.id.btn_pk);
        mBtnPk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!canClick()) {
            return;
        }
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_close:
                close();
                break;
            case R.id.btn_function:
                showFunctionDialog();
                break;
            case R.id.btn_close_game:
                closeGame();
                break;
            case R.id.btn_pk:
                applyLinkMicPk();
                break;
        }
    }

    /**
     * 设置游戏按钮是否可见
     */
    public void setGameBtnVisible(boolean show) {
        if (mBtnGameClose != null) {
            if (show) {
                if (mBtnGameClose.getVisibility() != View.VISIBLE) {
                    mBtnGameClose.setVisibility(View.VISIBLE);
                }
            } else {
                if (mBtnGameClose.getVisibility() == View.VISIBLE) {
                    mBtnGameClose.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    /**
     * 关闭游戏
     */
    private void closeGame() {
        ((LiveAnchorActivity) mContext).closeGame();
    }

    /**
     * 关闭直播
     */
    private void close() {
        ((LiveAnchorActivity) mContext).closeLive();
    }

    /**
     * 显示功能弹窗
     */
    private void showFunctionDialog() {
        if (mBtnFunction != null) {
            mBtnFunction.setImageDrawable(mDrawable1);
        }
        ((LiveAnchorActivity) mContext).showFunctionDialog();
    }

    /**
     * 设置功能按钮变暗
     */
    public void setBtnFunctionDark() {
        if (mBtnFunction != null) {
            mBtnFunction.setImageDrawable(mDrawable0);
        }
    }

    /**
     * 设置连麦pk按钮是否可见
     */
    public void setPkBtnVisible(boolean visible) {
        if (mBtnPk != null) {
            if (visible) {
                if (mBtnPk.getVisibility() != View.VISIBLE) {
                    mBtnPk.setVisibility(View.VISIBLE);
                }
            } else {
                if (mBtnPk.getVisibility() == View.VISIBLE) {
                    mBtnPk.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    /**
     * 发起主播连麦pk
     */
    private void applyLinkMicPk(){
        ((LiveAnchorActivity)mContext).applyLinkMicPk();
    }

}
