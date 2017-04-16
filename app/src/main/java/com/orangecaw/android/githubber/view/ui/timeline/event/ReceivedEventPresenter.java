package com.orangecaw.android.githubber.view.ui.timeline.event;

import com.orangecaw.android.githubber.data.User;
import com.orangecaw.android.githubber.data.source.Repository;

import org.androidannotations.annotations.EBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

@EBean(scope = EBean.Scope.Singleton)
public class ReceivedEventPresenter implements ReceivedEventContract.Presenter {

    ReceivedEventContract.View view;

    public void setView(ReceivedEventContract.View view) {
        this.view = view;
    }

    @Override
    public void loadEvents() {
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).findFirst();

        if(user != null) {
            Repository.getInstance().getReceivedEvents(user.getReceivedEventsUrl())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(events -> view.setEvents(events), error -> {
                        //Toast.makeText(getApplicationContext(), "error getReceivedEvents", Toast.LENGTH_SHORT).show();
                    });
        }
    }

}
