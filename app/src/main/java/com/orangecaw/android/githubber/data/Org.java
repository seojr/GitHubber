package com.orangecaw.android.githubber.data;

import com.google.gson.annotations.SerializedName;

public class Org {

    private long id;
    private String login;
    @SerializedName("gravatar_id") private String gravatarId;
    private String url;
    @SerializedName("avatar_url") private String avatarUrl;

}
