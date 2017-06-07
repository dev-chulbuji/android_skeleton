package com.example.ladmusiciankim.searchimage.presentation.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.ladmusiciankim.searchimage.presentation.interfaces.OnRecyclerItemClickListener;

public abstract class BaseViewHolder<M> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView, int viewType) {
        super(itemView);
    }

    public abstract void bindView(
            Context ctx, int position, M item, OnRecyclerItemClickListener listener);
}
