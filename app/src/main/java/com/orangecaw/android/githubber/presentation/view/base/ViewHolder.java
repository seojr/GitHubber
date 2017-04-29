package com.orangecaw.android.githubber.presentation.view.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewHolder<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewHolder(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }

}