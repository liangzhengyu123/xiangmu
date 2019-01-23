package com.example.frame.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.widget.Toast;
import com.example.frame.R;
import com.example.frame.tools.StatusBarManager;
import com.jcodecraeer.xrecyclerview.CustomDialog;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Song Shuyu
 * Created by Administrator on 2018/12/27 0027 23:14
 * Created DemoMVP
 * package is com.example.administrator.demomvp.base
 * TODO
 */
public class BaseActivity extends AppCompatActivity {
    private Dialog mLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoading = CustomDialog.LineDialog(this, ProgressStyle.BallPulse, null);
        Log.e("我是华丽丽的类名---：",this.getClass().getSimpleName());
    }

    public void showLoading(){
        if (mLoading != null && !mLoading.isShowing())mLoading.show();
    }

    public void dismissLoading(){
        if (mLoading != null && mLoading.isShowing())mLoading.dismiss();
    }

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

    // 设置状态栏的背景色。对于Android4.4和Android5.0以上版本要区分处理
    public void setStatusBarColor(int color) {
        StatusBarManager.setStatusBarColor(this,color);
    }

    public void initRecyclerGrid(RecyclerView mRecyclerView, int numConlums) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, numConlums);
        layoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
