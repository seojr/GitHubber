package com.orangecaw.android.githubber.view.ui.timeline;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.orangecaw.android.githubber.R;
import com.orangecaw.android.githubber.data.User;
import com.orangecaw.android.githubber.view.ui.timeline.event.ReceivedEventFragment_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.github_activity)
public class GitHubActivity extends AppCompatActivity implements GitHubContract.View, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = GitHubActivity.class.getSimpleName();

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.github_drawer_layout)
    DrawerLayout drawer;

    @ViewById(R.id.github_nav_view)
    NavigationView navigationView;

    GitHubNavigationHeader navigationHeader;

    @Bean(GitHubPresenter.class)
    GitHubContract.Presenter presenter;

    @AfterInject
    public void injectView() {
        presenter.setView(this);
    }

    @AfterViews
    public void init() {
        setSupportActionBar(toolbar);
        setDrawer();
        setNavigationView();
        selectMenu(0);
    }

    private void setDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        navigationHeader = GitHubNavigationHeader_.build(getApplicationContext());
        navigationView.addHeaderView(navigationHeader);
    }

    private void selectMenu(int position) {
        MenuItem item = navigationView.getMenu().getItem(position);
        item.setChecked(true);
        onNavigationItemSelected(item);
    }

    @UiThread
    @Override
    public void setEvent() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ReceivedEventFragment_())
                .commit();
    }

    @UiThread
    @Override
    public void setProfile(User user) {
        navigationHeader.bindProfile(user);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_received_events:
                presenter.loadProfile();
                Log.d(TAG, "nav_received_events");
                break;
            case R.id.nav_received_repos:
                Log.d(TAG, "nav_received_repos");
                break;
            case R.id.nav_settings:
                Log.d(TAG, "nav_settings");
                break;
            case R.id.nav_info:
                Log.d(TAG, "nav_info");
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
