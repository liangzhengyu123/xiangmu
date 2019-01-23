package com.example.administrator.chunhui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.bean.ProjectContent;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private List<ProjectContent.DataBean.DatasBean> list;
    private Context context;


    public ProjectAdapter(List<ProjectContent.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.project_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Glide.with(context).load(list.get(i).getEnvelopePic()).into(viewHolder.project_envelopePic);
        viewHolder.project_title.setText(list.get(i).getTitle());
        viewHolder.project_desc.setText(list.get(i).getDesc());
        viewHolder.project_time.setText(list.get(i).getNiceDate());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickListener(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView project_envelopePic;
        private ImageView project_image;
        private TextView project_title;
        private TextView project_desc;
        private TextView project_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            project_envelopePic = itemView.findViewById(R.id.project_envelopePic);
            project_image = itemView.findViewById(R.id.project_image);
            project_title = itemView.findViewById(R.id.project_title);
            project_desc = itemView.findViewById(R.id.project_desc);
            project_time = itemView.findViewById(R.id.project_time);
        }
    }

    OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onClickListener(int position);

        void onClickLongListener(int position);
    }
}
