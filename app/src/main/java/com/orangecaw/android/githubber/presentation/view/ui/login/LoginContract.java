package com.orangecaw.android.githubber.presentation.view.ui.login;

import com.orangecaw.android.githubber.presentation.view.base.BasePresenter;
import com.orangecaw.android.githubber.presentation.view.base.BaseView;

public interface LoginContract {

    interface View extends BaseView {

        void startGitHub();

        void showLogInFail();

    }

    interface Presenter extends BasePresenter<View> {

        void onLoginClick(String id, String pwd);

        void dispose();

    }

}
