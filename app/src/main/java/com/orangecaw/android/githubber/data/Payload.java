package com.orangecaw.android.githubber.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Payload {

    private String action;
    private String ref;
    @SerializedName("ref_type") private String refType;
    @SerializedName("master_branch") private String masterBranch;
    private String description;
    @SerializedName("pusher_type") private String pusherType;
    private Repo forkee;
    private User member;

}
