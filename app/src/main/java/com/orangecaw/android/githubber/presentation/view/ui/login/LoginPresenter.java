package com.orangecaw.android.githubber.presentation.view.ui.login;

import com.orangecaw.android.githubber.data.source.Repository;

import org.androidannotations.annotations.EBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@EBean(scope = EBean.Scope.Singleton)
public class LoginPresenter implements LoginContract.Presenter {

    CompositeDisposable compositeDisposable;

    private LoginContract.View view;

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onLoginClick(String id, String pwd) {
        compositeDisposable.add(Repository.getInstance().login(id, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        token -> view.startGitHub(),
                        e -> view.showLogInFail()
                )
        );
    }

    @Override
    public void dispose() {
        compositeDisposable.dispose();
    }
}
