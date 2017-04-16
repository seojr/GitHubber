package com.orangecaw.android.githubber.data.source.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.orangecaw.android.githubber.App;

public class TokenPreferences {

    private static TokenPreferences instance = new TokenPreferences();

    private SharedPreferences prefs;

    private SharedPreferences.Editor editor;

    public static TokenPreferences getInstance() {
        return instance;
    }

    private TokenPreferences() {
        Context context = App.getContext();
        prefs = context.getSharedPreferences("oauth", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void save(String token) {
        editor.putString("token", token);
        editor.apply();
    }

    public String get() {
        return prefs.getString("token", "");
    }

}
