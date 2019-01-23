package com.example.administrator.chunhui.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.adapter.Reuse_adapter;
import com.example.administrator.chunhui.entity.System_entity;
import com.example.administrator.chunhui.module.Ns;
import com.example.administrator.chunhui.view.fragment.Reuse_Fragment;
import com.example.frame.base.BaseNetActivity;
import com.example.frame.presenter.CommonPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Multiplexing_Activity extends BaseNetActivity<CommonPresenter, Ns> {
    @BindView(R.id.mult_viewpager)
    ViewPager multViewpager;
    @BindView(R.id.mult_tab)
    TabLayout multTab;
    @BindView(R.id.mult_img)
    ImageView multImg;
    @BindView(R.id.mult_text)
    TextView multText;
    private List<System_entity.DataBean.ChildrenBean> shujulist = new ArrayList<>();
    private List<String> mStringList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_multiplexing;
    }

    @Override
    protected void initView() {
        List<System_entity.DataBean.ChildrenBean> list = (List<System_entity.DataBean.ChildrenBean>) getIntent().getSerializableExtra("list");
        shujulist.addAll(list);

        for (int i = 0; i < shujulist.size(); i++) {
            mStringList.add(shujulist.get(i).getName());
            mFragmentList.add(Reuse_Fragment.fuyong(shujulist.get(i).getId()));
        }

        Reuse_adapter reuse_adapter = new Reuse_adapter(getSupportFragmentManager(), mStringList, mFragmentList);
        multViewpager.setAdapter(reuse_adapter);
        multTab.setupWithViewPager(multViewpager);

        multText.setText(getIntent().getStringExtra("string"));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected CommonPresenter getPresenter() {
        return null;
    }

    @Override
    protected Ns getModule() {
        return null;
    }

    @Override
    public void showResponse(int apiconfig, Object o, Object[] t) {

    }

    @Override
    public void showError(int apiconfig, Throwable throwable) {

    }

    @OnClick(R.id.mult_img)
    public void onViewClicked() {
        finish();
    }
}
