package com.orangecaw.android.githubber;


import android.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;

import com.orangecaw.android.githubber.view.ui.splash.SplashActivity;
import com.orangecaw.android.githubber.view.ui.login.LoginFragment;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAlertDialog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginValidationTest extends TestCase{

    SplashActivity splashActivity;
    LoginFragment loginFragment;
    EditText idEditText;
    EditText pwEditText;
    Button loginBtn;

    @Before
    public void setUp() throws Exception {
        splashActivity = Robolectric.setupActivity(SplashActivity.class);
        loginFragment = (LoginFragment)splashActivity.getSupportFragmentManager().getFragments().get(0);
        idEditText = (EditText)loginFragment.getView().findViewById(R.id.id_input);
        pwEditText = (EditText)loginFragment.getView().findViewById(R.id.pw_input);
        loginBtn = (Button)loginFragment.getView().findViewById(R.id.login_button);
    }

    @Test
    public void checkNullActivity() {
        assertNotNull(splashActivity);
    }

    @Test
    public void checkInsertUsername() {
        idEditText.setText("");
        pwEditText.setText("");
        loginBtn.performClick();

        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
        ShadowAlertDialog sAlert = shadowOf(alert);
        assertThat(sAlert.getTitle().toString()).isEqualTo(splashActivity.getString(R.string.insert_id));
    }

    @Test
    public  void checkInsertPassword() {
        idEditText.setText("username");
        pwEditText.setText("");
        loginBtn.performClick();

        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
        ShadowAlertDialog sAlert = shadowOf(alert);
        assertThat(sAlert.getTitle().toString()).isEqualTo(splashActivity.getString(R.string.insert_password));
    }

}
