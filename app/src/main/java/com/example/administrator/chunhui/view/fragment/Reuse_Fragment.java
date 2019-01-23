package com.example.administrator.chunhui.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.adapter.Reusexrv_adapter;
import com.example.administrator.chunhui.entity.Reuse_entity;
import com.example.administrator.chunhui.module.Ns;
import com.example.frame.base.BaseNetFragment;
import com.example.frame.configs.ApiConfig;
import com.example.frame.presenter.CommonPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Reuse_Fragment extends BaseNetFragment<CommonPresenter, Ns> {


    @BindView(R.id.reuse_xrv)
    XRecyclerView reuseXrv;
    Unbinder unbinder;
    private List<Reuse_entity.DataBean.DatasBean> mDatasBeanList=new ArrayList<>();
    private Reusexrv_adapter mReusexrv_adapter;
    private int mInt=0;

    public static Fragment fuyong(int userid) {
        Reuse_Fragment reuse_fragment = new Reuse_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("int", userid);
        reuse_fragment.setArguments(bundle);
        return reuse_fragment;
    }

    @Override
    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        reuseXrv.setLayoutManager(linearLayoutManager);

        mReusexrv_adapter = new Reusexrv_adapter(mDatasBeanList,getActivity());
        reuseXrv.setAdapter(mReusexrv_adapter);
        mReusexrv_adapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.GET_ERYE_DATA, getArguments().getInt("int"));
    }

    @Override
    public CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public Ns getModule() {
        return new Ns();
    }

    @Override
    public void showResponse(int apiconfig, Object o, Object[] t) {
        if (apiconfig==ApiConfig.GET_ERYE_DATA) {
            Reuse_entity reuse_entity= (Reuse_entity) o;
            List<Reuse_entity.DataBean.DatasBean> datas = reuse_entity.getData().getDatas();
            mDatasBeanList.addAll(datas);
            mReusexrv_adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showError(int apiconfig, Throwable throwable) {
        if(apiconfig==ApiConfig.GET_ERYE_DATA){
            Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reuse_;
    }
}
