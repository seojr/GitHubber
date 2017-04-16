package com.orangecaw.android.githubber.view.ui.timeline.event;

import com.orangecaw.android.githubber.data.Event;
import com.orangecaw.android.githubber.view.base.BasePresenter;
import com.orangecaw.android.githubber.view.base.BaseView;

import java.util.List;

public interface ReceivedEventContract {

    interface View extends BaseView {

        void setEvents(List<Event> events);

    }

    interface Presenter extends BasePresenter<View> {

        void loadEvents();

    }

}
