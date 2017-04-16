package com.orangecaw.android.githubber.data;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

@Getter
public class User extends RealmObject {

    private String login;
    @PrimaryKey private long id;
    @SerializedName("avatar_url") private String avatarUrl;
    @SerializedName("gravatar_id") private String gravatarId;
    private String url;
    @SerializedName("html_url") private String htmlUrl;
    @SerializedName("followers_url") private String followersUrl;
    @SerializedName("following_url") private String followingUrl;
    @SerializedName("gists_url") private String gistsUrl;
    @SerializedName("starred_url") private String starredUrl;
    @SerializedName("subscriptions_url") private String subscriptionsUrl;
    @SerializedName("organizations_url") private String organizationsUrl;
    @SerializedName("repos_url") private String reposUrl;
    @SerializedName("events_url") private String eventsUrl;
    @SerializedName("received_events_url") private String receivedEventsUrl;
    private String type;
    @SerializedName("site_admin") private boolean siteAdmin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private boolean hireable;
    private String bio;
    @SerializedName("public_repos") private int publicRepos;
    @SerializedName("public_gists") private int publicGists;
    private int followers;
    private int following;
    @SerializedName("created_at") private String createdAt;
    @SerializedName("updated_at") private String updatedAt;

}
