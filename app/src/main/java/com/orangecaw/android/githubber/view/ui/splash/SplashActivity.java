package com.orangecaw.android.githubber.view.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.orangecaw.android.githubber.R;
import com.orangecaw.android.githubber.data.source.preferences.TokenPreferences;
import com.orangecaw.android.githubber.view.ui.login.LoginFragment_;
import com.orangecaw.android.githubber.view.ui.timeline.GitHubActivity_;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        if(!isLoggedin()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.splash_container, new LoginFragment_())
                    .commit();
        } else {
            startActivity(new Intent(getApplicationContext(), GitHubActivity_.class));
            finish();
        }
    }

    private boolean isLoggedin() {
        String token = TokenPreferences.getInstance().get();
        return !TextUtils.isEmpty(token);
    }
}
