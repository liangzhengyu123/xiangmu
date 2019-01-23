package com.example.administrator.chunhui.view.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.adapter.HomeAdapter;
import com.example.administrator.chunhui.bean.BannerData;
import com.example.administrator.chunhui.bean.HomeData;
import com.example.administrator.chunhui.module.Ns;
import com.example.administrator.chunhui.view.activity.HomeActivity;
import com.example.frame.base.BaseNetFragment;
import com.example.frame.configs.ApiConfig;
import com.example.frame.interfaces.ICommonView;
import com.example.frame.presenter.CommonPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseNetFragment<CommonPresenter,Ns> implements ICommonView, OnLoadmoreListener, OnRefreshListener {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.xrv)
    RecyclerView xrv;
    @BindView(R.id.project_srf)
    SmartRefreshLayout project_srf;
    private List<BannerData.DataBean> bannerDataList = new ArrayList<>();
    private List<HomeData.DataBean.DatasBean> HomeList = new ArrayList<>();
    private HomeAdapter adapter;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank_fragment1;
    }

    @Override
    public void initView() {
        adapter = new HomeAdapter(HomeList, getContext());
        xrv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        xrv.setLayoutManager(manager);
        //上拉刷新
        project_srf.setOnRefreshListener(this);
        //下拉加载
        project_srf.setOnLoadmoreListener(this);
        //接口回调
        adapter.setAaa((HomeActivity)getActivity());
    }

    @Override
    public void initData() {
        mPresenter.getData(6,ApiConfig.GET_HOME_DATA);
        mPresenter.getData(7,ApiConfig.GET_BANNER_LUN);
    }

    @Override
    public CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public Ns getModule() {
        return new Ns();
    }

    //轮播图
    private void banner(final List<BannerData.DataBean> bannerDataList) {
        //设置图片文字
        mBannerTitleList = new ArrayList<>();
        List<String> bannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for(BannerData.DataBean bannerData : bannerDataList){
            mBannerTitleList.add(bannerData.getTitle());
            bannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());
        }
        //设置图片集合
        banner.setImages(bannerImageList);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(mBannerTitleList);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //启动
        banner.start();
    }

    @Override
    public void showResponse(int apiconfig, Object o, Object[] t) {
        switch (apiconfig){
            case ApiConfig.GET_HOME_DATA:
                HomeData homeData= (HomeData) o;
                showHome(homeData);
                break;
            case ApiConfig.GET_BANNER_LUN:
                BannerData bannerData= (BannerData) o;
                showBanner(bannerData);
                banner(bannerDataList);
                break;
        }
    }

    private void showBanner(BannerData bannerData) {
        //对Banner进行判空
        if(bannerData!=null){
            bannerDataList.clear();
        }
        List<BannerData.DataBean>  data = bannerData.getData();
        bannerDataList.addAll(data);
    }

    private void showHome(HomeData homeData) {
        List<HomeData.DataBean.DatasBean> datas = homeData.getData().getDatas();
        HomeList.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(int apiconfig, Throwable throwable) {

    }

    //下拉加载(飞机动画)
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getData(6,ApiConfig.GET_HOME_DATA);
        adapter.notifyDataSetChanged();
        project_srf.finishLoadmore();
    }

    //上拉刷新(水珠动画)
    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        adapter.notifyDataSetChanged();
        project_srf.finishRefresh();
    }
}
