package com.orangecaw.android.githubber.data.source.server;

import com.orangecaw.android.githubber.data.Event;
import com.orangecaw.android.githubber.data.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GitHubService {

    @GET("user")
    Observable<User> getMyProfile();

    @GET
    Observable<List<Event>> getReceivedEvents(@Url String url);

}
