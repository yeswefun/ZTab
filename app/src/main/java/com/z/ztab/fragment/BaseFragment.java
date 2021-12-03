package com.z.ztab.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
    模板设计模式
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;
    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mRootView = View.inflate(mContext, getLayoutResId(), null);
        // 加入注解 - this -> childFragment: HomeFragment / FindFragment / NewsFragment / MsgsFragment
        //ViewUtils.inject(mRootView, this);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    // mRootView#findViewById

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutResId();

}
