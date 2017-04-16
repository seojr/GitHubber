package com.orangecaw.android.githubber.view.ui.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orangecaw.android.githubber.R;
import com.orangecaw.android.githubber.view.ui.timeline.GitHubActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.login_fragment)
public class LoginFragment extends Fragment implements LoginContract.View {

    @ViewById(R.id.id_input)
    EditText idInput;

    @ViewById(R.id.pw_input)
    EditText pwInput;

    @Bean(LoginPresenter.class)
    LoginContract.Presenter presenter;

    @AfterInject
    void injectView() {
        presenter.setView(this);
    }

    @Click(R.id.login_button)
    public void onClickLogin(View view) {
        if(TextUtils.isEmpty(idInput.getText())) {
            new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.insert_id)
                    .show();
            return;
        }

        if(TextUtils.isEmpty(pwInput.getText())) {
            new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.insert_password)
                    .show();
            return;
        }
        presenter.onLoginClick(idInput.getText().toString(), pwInput.getText().toString());
    }

    @Override
    public void onDestroy() {
        presenter.dispose();
        super.onDestroy();
    }

    @Override
    public void startGitHub() {
        Toast.makeText(getActivity(), R.string.log_in_success, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity().getApplicationContext(), GitHubActivity_.class));
        getActivity().finish();
    }

    @Override
    public void showLogInFail() {
        Toast.makeText(getActivity(), R.string.log_in_fail, Toast.LENGTH_SHORT).show();
    }
}
