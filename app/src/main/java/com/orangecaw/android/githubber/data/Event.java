package com.orangecaw.android.githubber.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Event {

    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
    @SerializedName("public") private boolean pub;
    @SerializedName("created_at") private String createdAt;
    private Org org;

    public List<String> getMessages() {
        List<String> messages = new ArrayList<>();
        String message = null;
        String description = null;
        if("CreateEvent".equals(type)) {
            message = "Created a repository";
            description = new StringBuilder("New repository is at ")
                    .append(repo.getName())
                    .toString();
        } else if ("WatchEvent".equals(type)) {
            message = new StringBuilder("starred ")
                    .append(repo.getName())
                    .toString();
        } else if ("ForkEvent".equals(type)) {
            message = new StringBuilder("Forked ")
                    .append(repo.getName())
                    .toString();
            description = new StringBuilder("Forked repository is at ")
                    .append(payload.getForkee().getFullName())
                    .toString();
        } else if ("MemberEvent".equals(type)) {
            message = new StringBuilder("Added ")
                    .append(payload.getMember().getLogin())
                    .append(" to ")
                    .append(repo.getName())
                    .toString();
        } else {

        }

        messages.add(message);
        if(description != null) {
            messages.add(description);
        }

        return messages;
    }

}
