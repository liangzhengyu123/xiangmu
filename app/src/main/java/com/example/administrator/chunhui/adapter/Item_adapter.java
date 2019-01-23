package com.example.administrator.chunhui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.chunhui.R;

import java.util.List;

public class Item_adapter extends RecyclerView.Adapter<Item_adapter.Holder> {

    private List<String> list;
    private Context context;

    public Item_adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout2,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.layout2_text.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView layout2_text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            layout2_text = itemView.findViewById(R.id.layout2_text);
        }
    }
}
