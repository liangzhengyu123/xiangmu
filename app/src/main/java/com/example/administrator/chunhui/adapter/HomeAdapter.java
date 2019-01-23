package com.example.administrator.chunhui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.bean.HomeData;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class HomeAdapter extends XRecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<HomeData.DataBean.DatasBean> HomeList;
    private Context context;

    public HomeAdapter(List<HomeData.DataBean.DatasBean> homeList, Context context) {
        HomeList = homeList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_pager, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder viewHolder, int i) {
        final HomeData.DataBean.DatasBean bean = HomeList.get(i);
        viewHolder.item_search_pager_author.setText(bean.getAuthor());
        viewHolder.item_search_pager_chapterName.setText(bean.getSuperChapterName()+"/"+bean.getChapterName());
        viewHolder.item_search_pager_title.setText(bean.getTitle());
        viewHolder.item_search_pager_niceDate.setText(bean.getNiceDate());
        //接口回调
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aaa!=null){
                    aaa.onclick(bean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HomeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_search_pager_author;
        TextView item_search_pager_chapterName;
        TextView item_search_pager_title;
        TextView item_search_pager_niceDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_search_pager_author = itemView.findViewById(R.id.item_search_pager_author);
            item_search_pager_chapterName = itemView.findViewById(R.id.item_search_pager_chapterName);
            item_search_pager_title = itemView.findViewById(R.id.item_search_pager_title);
            item_search_pager_niceDate = itemView.findViewById(R.id.item_search_pager_niceDate);
        }
    }
    //定义接口
    private AAA aaa;

    public void setAaa(AAA aaa) {
        this.aaa = aaa;
    }

    public interface AAA{
        void onclick(HomeData.DataBean.DatasBean bean);
    }
}
