package com.agneshandayani.myapplication.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agneshandayani.myapplication.MainActivity;
import com.agneshandayani.myapplication.POJO.ResponseItem;
import com.agneshandayani.myapplication.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<ResponseItem> dataUser;
    private final Context mContext;


    public RecycleAdapter(int listItem, MainActivity mContext) {
        this.dataUser = dataUser;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(dataUser.get(i).getTitle());
        viewHolder.tvURL.setText(dataUser.get(i).getUrl());
        Glide.with(mContext).load(dataUser.get(i).getThumbnailUrl()).into(viewHolder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.img_avatar)
        ImageView imgAvatar;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_url)
        TextView tvURL;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
