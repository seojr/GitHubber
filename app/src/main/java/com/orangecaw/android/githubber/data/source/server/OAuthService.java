package com.orangecaw.android.githubber.data.source.server;

import com.orangecaw.android.githubber.data.Token;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OAuthService {

    @POST("authorizations")
    Observable<Token> createToken(@Body HashMap<String, String> body);

}
