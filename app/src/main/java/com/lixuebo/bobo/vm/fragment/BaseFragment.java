package com.lixuebo.bobo.vm.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.lixuebo.bobo.R;
import com.lixuebo.bobo.utils.UIUtils;

/**
 * Created by lixuebo on 17/3/5.
 */

public abstract class BaseFragment extends Fragment {

    protected boolean isReadData = true;
    protected boolean isEmptyData = false;
    protected Activity mActivity;
    // 四类界面
    public View loading;
    public View error;
    public View empty;

    public FrameLayout commonContainer;

    protected Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (isReadData) {
                if (isEmptyData) {
                    showEmptyView();
                } else {

                    showSuccessView();

                }

            } else {
                showErrorView();
            }

        }


    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this.getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commonContainer = (FrameLayout) view.findViewById(R.id.fragment_container);
    }

    private void showEmptyView() {
        empty = View.inflate(UIUtils.getContext(), R.layout.pager_empty, null);
        changeViewTo(empty);
    }


    private void showErrorView() {
        error = View.inflate(UIUtils.getContext(), R.layout.pager_error, null);
        error.findViewById(R.id.error_btn_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dynamic();
            }
        });
        changeViewTo(error);
    }


    /**
     * 切换到目标界面，原有的会被删除
     *
     * @param view
     */
    public void changeViewTo(View view) {
        commonContainer.removeAllViews();
        commonContainer.addView(view);
    }

    protected abstract void showSuccessView();


    /**
     * 动态界面加载流程的起点
     */
    public void dynamic() {

        showProgress();
        loadData();
    }

    private void showProgress() {
        loading = View.inflate(UIUtils.getContext(), R.layout.pager_loading, null);
        changeViewTo(loading);
    }

    protected abstract void loadData();
}
