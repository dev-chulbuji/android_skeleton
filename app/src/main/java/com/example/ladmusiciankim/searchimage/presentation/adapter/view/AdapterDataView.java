package com.example.ladmusiciankim.searchimage.presentation.adapter.view;
import com.example.ladmusiciankim.searchimage.presentation.interfaces.OnRecyclerItemClickListener;

public interface AdapterDataView {
    void refresh();
    void setItemClickListener(OnRecyclerItemClickListener listener);
}
