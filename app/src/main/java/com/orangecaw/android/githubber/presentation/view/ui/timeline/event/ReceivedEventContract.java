package com.orangecaw.android.githubber.presentation.view.ui.timeline.event;

import com.orangecaw.android.githubber.data.Event;
import com.orangecaw.android.githubber.presentation.view.base.BaseView;
import com.orangecaw.android.githubber.presentation.view.base.BasePresenter;

import java.util.List;

public interface ReceivedEventContract {

    interface View extends BaseView {

        void setEvents(List<Event> events);

    }

    interface Presenter extends BasePresenter<View> {

        void loadEvents();

    }

}
