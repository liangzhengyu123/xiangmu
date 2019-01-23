package com.example.administrator.chunhui.view.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.adapter.ProjectAdapter;
import com.example.administrator.chunhui.bean.ProjectContent;
import com.example.administrator.chunhui.module.ProjectModule;
import com.example.frame.base.BaseNetFragment;
import com.example.frame.configs.ApiConfig;
import com.example.frame.presenter.CommonPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Project2Fragment extends BaseNetFragment<CommonPresenter, ProjectModule> {

    @BindView(R.id.project_xrv)
    RecyclerView projectXrv;

    @BindView(R.id.project_srf)
    SmartRefreshLayout projectSrf;

    private int tab;
    private List<ProjectContent.DataBean.DatasBean> dataList = new ArrayList<>();
    private ProjectAdapter projectAdapter;
    private int page = 1;

    @SuppressLint("ValidFragment")
    public Project2Fragment(int tab) {
        this.tab = tab;
    }

    public Project2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser == true && dataList.size() == 0) {

        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project2;
    }

    @Override
    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        projectXrv.setLayoutManager(linearLayoutManager);
        projectAdapter = new ProjectAdapter(dataList, getActivity());
        projectXrv.setAdapter(projectAdapter);
        projectAdapter.setItemClickListener(new ProjectAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent(getActivity(), Project_DetailsActivity.class);
                intent.putExtra("link", dataList.get(position).getLink());
                intent.putExtra("title", dataList.get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onClickLongListener(int position) {

            }
        });

        projectSrf.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                Log.i("tag", "刷新拉" + page);
                mPresenter.getData(ApiConfig.GET_PROJECT_CONTENT, tab, page);
                projectSrf.finishRefresh();

            }
        });
        projectSrf.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                Log.i("tag", "加载啦" + page);
                mPresenter.getData(ApiConfig.GET_PROJECT_CONTENT, tab, page);
                projectSrf.finishLoadmore();
            }
        });
    }

    @Override
    public void initData() {

        mPresenter.getData(ApiConfig.GET_PROJECT_CONTENT, tab, page);
    }

    @Override
    public CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public ProjectModule getModule() {
        return new ProjectModule();
    }

    @Override
    public void showResponse(int apiconfig, Object o, Object[] t) {
        switch (apiconfig) {
            case ApiConfig.GET_PROJECT_CONTENT:
                ProjectContent projectContent = (ProjectContent) o;
                List<ProjectContent.DataBean.DatasBean> datas = projectContent.getData().getDatas();
                dataList.addAll(datas);
                projectAdapter.notifyDataSetChanged();
                break;

        }
    }

    @Override
    public void showError(int apiconfig, Throwable throwable) {

    }

}
