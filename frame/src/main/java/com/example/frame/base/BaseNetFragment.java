package com.example.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.frame.interfaces.ICommonModule;
import com.example.frame.interfaces.ICommonView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseNetFragment<P extends BasePresenter,M> extends BaseFrament implements ICommonView {

    public P mPresenter;
    public M mModule;
    public View view;
    private Unbinder mBind;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        mBind = ButterKnife.bind(this,view);
        initView();
        mPresenter = getPresenter();
        mModule = getModule();
        if (mPresenter != null ){
            mPresenter.attach(this, (ICommonModule) mModule);
        }
        initData();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }

    public abstract int getLayoutId();
    public abstract void initView();
    public abstract void initData();
    public abstract P getPresenter();
    public abstract M getModule();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null && mModule != null){
            mPresenter.deattch();
        }
    }
}
