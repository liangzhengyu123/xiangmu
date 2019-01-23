package com.example.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.frame.R;
import com.example.frame.interfaces.ICommonModule;
import com.example.frame.interfaces.ICommonView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.ButterKnife;
import butterknife.Unbinder;



public abstract class BaseNetActivity<P extends BasePresenter,M> extends BaseActivity implements ICommonView {
    public P mPresenter;
    public M mModule;
    public Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        initView();
        mPresenter = getPresenter();
        mModule=getModule();
        if(mPresenter!=null && mModule!=null) mPresenter.attach(this,(ICommonModule)mModule);
        initData();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract P getPresenter();
    protected abstract M getModule();
    protected abstract void initData();


    //上拉刷新，下拉加载
    public void initRecycleView(XRecyclerView recyclerView) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setRefreshProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.getDefaultFootView().setLoadingHint(getString(R.string.loading));
        recyclerView.getDefaultFootView().setNoMoreHint(getString(R.string.no_more_data));
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refresh();
            }

            @Override
            public void onLoadMore() {
                loadMore();
            }
        });
    }

    public void refresh() {
    }

    public void loadMore() {
    }

    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        if(mPresenter!=null){
            mPresenter.deattch();
        }
    }
}
