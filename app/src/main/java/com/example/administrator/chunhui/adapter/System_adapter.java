package com.example.administrator.chunhui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.entity.System_entity;

import java.util.List;
import java.util.Random;

public class System_adapter extends RecyclerView.Adapter<System_adapter.Holder> {

    private List<System_entity.DataBean> list;
    private Context context;
    Random random = new Random();
    onCli mOnCli;

    public void setOnCli(onCli onCli) {
        mOnCli = onCli;
    }

    public System_adapter(List<System_entity.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.system_layout, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.layout_text.setText(list.get(i).getName());

        int[] ints = {R.color.colorPrimary, R.color.colorAccent, R.color.splash_blue, R.color.hong, R.color.hei, R.color.lan};

        int lenth = random.nextInt(5) + 1;
        holder.layout_text.setTextColor(ints[lenth]);


        String string = null;
        for (int j = 0; j < list.get(i).getChildren().size(); j++) {
            string = string + list.get(i).getChildren().get(j).getName() + "   ";
        }
        holder.layout_rv.setText(string);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCli.show(list.get(i).getChildren(),i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView layout_text;
        TextView layout_rv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            layout_text = itemView.findViewById(R.id.layout_text);
            layout_rv = itemView.findViewById(R.id.layout_rv);
        }
    }

    public interface onCli{
        void show(List<System_entity.DataBean.ChildrenBean> list,int id);
    }
}
