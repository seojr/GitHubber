package com.orangecaw.android.githubber.view.ui.timeline.event.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.orangecaw.android.githubber.data.Event;
import com.orangecaw.android.githubber.view.base.RecyclerViewAdapterBase;
import com.orangecaw.android.githubber.view.base.ViewHolder;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class ReceivedEventAdapter extends RecyclerViewAdapterBase<Event, ReceivedEventItemView> {

    @RootContext
    Context context;

    public void setEvents(List<Event> events) {
        list = events;
    }

    @Override
    protected ReceivedEventItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ReceivedEventItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewHolder<ReceivedEventItemView> holder, int position) {
        ReceivedEventItemView view = holder.getView();
        view.bind(list.get(position));
    }

}
