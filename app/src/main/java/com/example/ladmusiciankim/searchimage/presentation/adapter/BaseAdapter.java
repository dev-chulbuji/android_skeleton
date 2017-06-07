package com.example.ladmusiciankim.searchimage.presentation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.ladmusiciankim.searchimage.presentation.adapter.model.AdapterDataModel;
import com.example.ladmusiciankim.searchimage.presentation.adapter.view.AdapterDataView;
import com.example.ladmusiciankim.searchimage.presentation.adapter.viewholder.BaseViewHolder;
import com.example.ladmusiciankim.searchimage.presentation.interfaces.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseAdapter<M, VH extends BaseViewHolder>
        extends RecyclerView.Adapter<VH>
        implements AdapterDataModel<M>, AdapterDataView {
    private final List<M> mModels;
    private OnRecyclerItemClickListener mItemClickListener = null;
    public Context mContext;

    @NonNull
    protected abstract Object getModelId(@NonNull M model);

    public BaseAdapter(Context ctx) {
        this.mModels = new ArrayList<>();
        this.mContext = ctx;
    }

    public void clearAndAddAll(Collection<M> data) {
        mModels.clear();

        for (M item : data) {
            addInternal(item);
        }

        notifyDataSetChanged();
    }

    public void addAll(Collection<M> data) {
        for (M item : data) {
            addInternal(item);
        }

        int addedSize = data.size();
        int oldSize = mModels.size() - addedSize;
        notifyItemRangeInserted(oldSize, addedSize);
    }

    public void addItem(M item) {
        addInternal(item);
        notifyItemInserted(mModels.size());
    }

    public void updateItem(M item) {
        Object modelId = getModelId(item);

        // Swap the model
        int position = getItemPosition(item);
        if (position >= 0) {
            mModels.remove(position);
            mModels.add(position, item);
        }

        if (position >= 0) {
            notifyItemChanged(position);
        }
    }

    public void removeItem(int position) {
        M item = getItem(position);
        if (position >= 0) {
            mModels.remove(item);
        }

        if (position >= 0) {
            notifyItemRemoved(position);
        }
    }

    private int getItemPosition(M item) {
        Object modelId = getModelId(item);

        int position = -1;
        for (int i = 0; i < mModels.size(); i++) {
            M model = mModels.get(i);
            if (getModelId(model).equals(modelId)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public void addInternal(M item) {
        System.err.println("Adding item " + getModelId(item));
        mModels.add(item);
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        ((BaseViewHolder)holder).bindView(mContext, position, mModels.get(position), mItemClickListener);
    }

    protected M getItem(int position) {
        return mModels.get(position);
    }
}
