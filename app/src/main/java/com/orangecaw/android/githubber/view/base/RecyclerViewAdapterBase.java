package com.orangecaw.android.githubber.view.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewAdapterBase<T, V extends View> extends RecyclerView.Adapter<ViewHolder<V>> {

    protected List<T> list = new ArrayList<>();

    @Override
    public final ViewHolder<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder<>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return list.size();
    }
}
