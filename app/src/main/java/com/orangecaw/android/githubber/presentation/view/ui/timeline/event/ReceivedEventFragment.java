package com.orangecaw.android.githubber.presentation.view.ui.timeline.event;

import android.app.Fragment;
import android.support.annotation.UiThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orangecaw.android.githubber.R;
import com.orangecaw.android.githubber.data.Event;
import com.orangecaw.android.githubber.presentation.view.ui.timeline.event.recyclerview.ReceivedEventAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.received_event_fragment)
public class ReceivedEventFragment extends Fragment implements ReceivedEventContract.View {

    @ViewById(R.id.received_event_list)
    RecyclerView recyclerView;

    @Bean
    ReceivedEventAdapter eventAdapter;

    @Bean(ReceivedEventPresenter.class)
    ReceivedEventContract.Presenter presenter;

    @AfterInject
    void injectView() {
        presenter.setView(this);
    }

    @AfterViews
    void init() {
        presenter.loadEvents();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @UiThread
    @Override
    public void setEvents(List<Event> events) {
        eventAdapter.setEvents(events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(eventAdapter);
    }
}
