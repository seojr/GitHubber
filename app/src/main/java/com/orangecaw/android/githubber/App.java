package com.orangecaw.android.githubber;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Realm.init(context);
    }

    public static Context getContext() {
        return context;
    }
}
