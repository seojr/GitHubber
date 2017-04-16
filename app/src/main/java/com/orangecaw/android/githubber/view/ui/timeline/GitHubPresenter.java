package com.orangecaw.android.githubber.view.ui.timeline;

import com.orangecaw.android.githubber.data.source.Repository;
import com.orangecaw.android.githubber.data.User;

import org.androidannotations.annotations.EBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

@EBean(scope = EBean.Scope.Singleton)
public class GitHubPresenter implements GitHubContract.Presenter {

    private GitHubContract.View view;

    @Override
    public void setView(GitHubContract.View view) {
        this.view = view;
    }

    @Override
    public void loadProfile() {
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).findFirst();
        if(user == null) {
            Repository.getInstance().myProfile()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(u -> {
                        Realm.getDefaultInstance().executeTransaction(r -> r.copyToRealmOrUpdate(u));
                        view.setProfile(user);
                        view.setEvent();
                    }, error -> {
                        //Toast.makeText(getApplicationContext(), "error profile", Toast.LENGTH_SHORT).show();
                    });
        } else {
            view.setProfile(user);
            view.setEvent();
        }
    }

}
