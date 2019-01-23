package com.example.administrator.chunhui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.chunhui.entity.Reuse_entity;

import java.util.List;

public class Reusexrv_adapter extends RecyclerView.Adapter<Reusexrv_adapter.Holder> {

    private List<Reuse_entity.DataBean.DatasBean> list;
    private Context context;

    public Reusexrv_adapter(List<Reuse_entity.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
