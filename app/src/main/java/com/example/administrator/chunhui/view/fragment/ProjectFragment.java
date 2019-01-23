package com.example.administrator.chunhui.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.adapter.VpAdapter;
import com.example.administrator.chunhui.bean.ProjectTab;
import com.example.administrator.chunhui.module.ProjectModule;
import com.example.frame.base.BaseNetFragment;
import com.example.frame.configs.ApiConfig;
import com.example.frame.interfaces.ICommonView;
import com.example.frame.presenter.CommonPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends BaseNetFragment<CommonPresenter, ProjectModule> implements ICommonView {


    private VpAdapter vpAdapter;

    @BindView(R.id.project_vp)
    ViewPager projectVp;
    @BindView(R.id.project_tab)
    TabLayout projectTab;
    Unbinder unbinder;
    private List<Fragment> fragments;
    private List<String> tab;

    public ProjectFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.GET_PROJECT_TAB);
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
    public void showResponse(int apiconfig, Object o, Object... t) {
        switch (apiconfig) {
            case ApiConfig.GET_PROJECT_TAB:
                ProjectTab projectTab2 = (ProjectTab) o;
                List<ProjectTab.DataBean> data = projectTab2.getData();
                fragments = new ArrayList<>();
                tab = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    Project2Fragment project2Fragment = new Project2Fragment(data.get(i).getId());
                    fragments.add(project2Fragment);
                    tab.add(data.get(i).getName());
                }
                vpAdapter = new VpAdapter(getChildFragmentManager(), fragments, tab);
                projectVp.setAdapter(vpAdapter);
                projectTab.setupWithViewPager(projectVp);
                /*dataList.addAll(data);
                vpAdapter.notifyDataSetChanged();*/
                break;
        }
    }

    @Override
    public void showError(int apiconfig, Throwable throwable) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
