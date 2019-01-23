package com.example.administrator.chunhui.view.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.adapter.System_adapter;
import com.example.administrator.chunhui.entity.System_entity;
import com.example.administrator.chunhui.module.Ns;
import com.example.administrator.chunhui.view.activity.Multiplexing_Activity;
import com.example.frame.base.BaseNetFragment;
import com.example.frame.configs.ApiConfig;
import com.example.frame.interfaces.ICommonView;
import com.example.frame.presenter.CommonPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Knowledge_systemFragment extends BaseNetFragment<CommonPresenter, Ns> implements ICommonView {


    public Knowledge_systemFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.fragment2_xrv)
    XRecyclerView fragment2Xrv;
    private List<System_entity.DataBean> mlist = new ArrayList<>();
    private System_adapter mSystem_adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank_fragment3;
    }

    @Override
    public void initView() {
        initRecycleView(fragment2Xrv);
        mSystem_adapter = new System_adapter(mlist, getActivity());
        fragment2Xrv.setAdapter(mSystem_adapter);
        mSystem_adapter.notifyDataSetChanged();

        mSystem_adapter.setOnCli(new System_adapter.onCli() {
            @Override
            public void show(List<System_entity.DataBean.ChildrenBean> list,int id) {
                Intent intent=new Intent(getActivity(),Multiplexing_Activity.class);
                intent.putExtra("list", (Serializable) list);
                intent.putExtra("string",mlist.get(id).getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.GET_SYSTEM_DATA);
    }

    @Override
    public CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    //刷新
    @Override
    public void refresh() {
        super.refresh();
        mlist.clear();
        mPresenter.getData(ApiConfig.GET_SYSTEM_DATA);
        mSystem_adapter.notifyDataSetChanged();
    }

    //加载
    @Override
    public void loadMore() {
        super.loadMore();
        mPresenter.getData(ApiConfig.GET_SYSTEM_DATA);
        mSystem_adapter.notifyDataSetChanged();
    }

    @Override
    public Ns getModule() {
        return new Ns();
    }

    @Override
    public void showResponse(int apiconfig, Object o, Object[] t) {
        if (ApiConfig.GET_SYSTEM_DATA == apiconfig) {
            System_entity system_entity = (System_entity) o;
            List<System_entity.DataBean> data = system_entity.getData();
            Log.i("tag", data + "");
            mlist.addAll(data);
            mSystem_adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showError(int apiconfig, Throwable throwable) {
        if (ApiConfig.GET_SYSTEM_DATA == apiconfig) {
            Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
            Log.i("tag", throwable.toString());
        }
    }
}
