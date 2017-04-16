package com.orangecaw.android.githubber.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Actor {

    private long id;
    private String login;
    @SerializedName("display_login") private String displayLogin;
    @SerializedName("gravatar_id") private String gravatarId;
    private String url;
    @SerializedName("avatar_url") private String avatarUrl;

}
