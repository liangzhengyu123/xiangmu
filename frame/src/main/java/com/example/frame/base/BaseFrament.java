package com.example.frame.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.example.frame.R;
import com.jcodecraeer.xrecyclerview.CustomDialog;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class BaseFrament extends Fragment {
    private Dialog mLoading;

    public void initRecycleView(XRecyclerView recyclerView) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
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
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoading = CustomDialog.LineDialog(getContext(), ProgressStyle.BallPulse, null);
    }
}
