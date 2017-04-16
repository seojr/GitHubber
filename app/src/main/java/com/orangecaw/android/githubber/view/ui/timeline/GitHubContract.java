package com.orangecaw.android.githubber.view.ui.timeline;

import com.orangecaw.android.githubber.data.User;
import com.orangecaw.android.githubber.view.base.BasePresenter;
import com.orangecaw.android.githubber.view.base.BaseView;

public interface GitHubContract {

    interface View extends BaseView {

        void setEvent();

        void setProfile(User user);

    }

    interface Presenter extends BasePresenter<View> {

        void loadProfile();

    }

}
