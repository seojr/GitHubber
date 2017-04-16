package com.orangecaw.android.githubber.data.source;

import android.text.TextUtils;

import com.orangecaw.android.githubber.BuildConfig;
import com.orangecaw.android.githubber.data.Event;
import com.orangecaw.android.githubber.data.Token;
import com.orangecaw.android.githubber.data.User;
import com.orangecaw.android.githubber.data.source.preferences.TokenPreferences;
import com.orangecaw.android.githubber.data.source.server.GitHubService;
import com.orangecaw.android.githubber.data.source.server.OAuthService;
import com.orangecaw.android.githubber.util.Credentials;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final Repository instance = new Repository();

    private static final String API_BASE_URL = "https://api.github.com/";

    public static Repository getInstance() {
        return instance;
    }

    private GitHubService githubService;

    private Repository() {
        String token = TokenPreferences.getInstance().get();
        if(!TextUtils.isEmpty(token)) {
            setGitHubService(token);
        }
    }

    private OkHttpClient getClient(String credentials) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("User-Agent", "Githubber-Android-App")
                    .build();
            return chain.proceed(request);
        });

        if(credentials != null) {
            httpClient.authenticator((route, response) ->
                    response.request().newBuilder()
                            .addHeader("Authorization", credentials)
                            .build());
        }
        return httpClient.build();
    }

    private Retrofit getRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    public void setGitHubService(String token) {
        String credential = Credentials.token(token);
        OkHttpClient client = getClient(credential);
        githubService = getRetrofit(client).create(GitHubService.class);
    }

    public Observable<Token> login(String username, String password) {
        String credential = Credentials.basic(username, password);

        HashMap<String, String> body = new HashMap<>();
        body.put("note", "GitHubber");
        body.put("client_id", BuildConfig.CLIENT_ID);
        body.put("client_secret", BuildConfig.CLIENT_SECRET);

        OkHttpClient client = getClient(credential);
        OAuthService oauthService = getRetrofit(client).create(OAuthService.class);
        return oauthService.createToken(body)
                .map(token -> {
                    TokenPreferences.getInstance().save(token.getToken());
                    setGitHubService(token.getToken());
                    return token;
                });
    }

    public Observable<User> myProfile() {
        return githubService.getMyProfile();
    }

    public Observable<List<Event>> getReceivedEvents(String receivedEventUrl) {
        return githubService.getReceivedEvents(receivedEventUrl);
    }

}
