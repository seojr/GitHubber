package com.orangecaw.android.githubber.data;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Repo {

    private long id;
    private String name;
    @SerializedName("full_name") private String fullName;
    private User owner;
    @SerializedName("private") private boolean private_;
    @SerializedName("html_url") private String htmlUrl;
    private String description;
    private boolean fork;
    private String url;
    @SerializedName("forks_url") private String forksUrl;
    @SerializedName("keys_url") private String keysUrl;
    @SerializedName("collaborators_url") private String collaboratorsUrl;
    @SerializedName("teams_url") private String teamsUrl;
    @SerializedName("hooks_url") private String hooksUrl;
    @SerializedName("issue_events_url") private String issueEventsUrl;
    @SerializedName("events_url") private String eventsUrl;
    @SerializedName("assignees_url") private String assigneesUrl;
    @SerializedName("branches_url") private String branchesUrl;
    @SerializedName("tags_url") private String tagsUrl;
    @SerializedName("blobs_url") private String blobsUrl;
    @SerializedName("git_tags_url") private String gitTagsUrl;
    @SerializedName("git_refs_url") private String gitRefsUrl;
    @SerializedName("trees_url") private String treesUrl;
    @SerializedName("statuses_url") private String statusesUrl;
    @SerializedName("languages_url") private String languagesUrl;
    @SerializedName("stargazers_url") private String stargazersUrl;
    @SerializedName("contributors_url") private String contributorsUrl;
    @SerializedName("subscribers_url") private String subscribersUrl;
    @SerializedName("subscription_url") private String subscriptionUrl;
    @SerializedName("commits_url") private String commitsUrl;
    @SerializedName("git_commits_url") private String gitCommitsUrl;
    @SerializedName("comments_url") private String commentsUrl;
    @SerializedName("issue_comment_url") private String issueCommentUrl;
    @SerializedName("contents_url") private String contentsUrl;
    @SerializedName("compare_url") private String compareUrl;
    @SerializedName("merges_url") private String mergesUrl;
    @SerializedName("archive_url") private String archiveUrl;
    @SerializedName("downloads_url") private String downloadsUrl;
    @SerializedName("issues_url") private String issuesUrl;
    @SerializedName("pulls_url") private String pullsUrl;
    @SerializedName("milestones_url") private String milestonesUrl;
    @SerializedName("notifications_url") private String notificationsUrl;
    @SerializedName("labels_url") private String labelsUrl;
    @SerializedName("releases_url") private String releasesUrl;
    @SerializedName("deployments_url") private String deploymentsUrl;
    @SerializedName("created_at") private String createdAt;
    @SerializedName("updated_at") private String updatedAt;
    @SerializedName("pushed_at") private String pushedAt;
    @SerializedName("git_url") private String gitUrl;
    @SerializedName("ssh_url") private String sshUrl;
    @SerializedName("clone_url") private String cloneUrl;
    @SerializedName("svn_url") private String svnUrl;
    private String homepage;
    private long size;
    @SerializedName("stargazers_count") private int stargazersCount;
    @SerializedName("watchers_count") private int watchersCount;
    private String language;
    @SerializedName("has_issues") private boolean hasIssues;
    @SerializedName("has_downloads") private boolean hasDownloads;
    @SerializedName("has_wiki") private boolean hasWiki;
    @SerializedName("has_pages") private boolean hasPages;
    @SerializedName("forks_count") private int forksCount;
    @SerializedName("mirror_url") private String mirrorUrl;
    @SerializedName("open_issues_count") private int openIssuesCount;
    private int forks;
    @SerializedName("open_issues") private int openIssues;
    private int watchers;
    @SerializedName("default_branch") private String defaultBranch;
    @SerializedName("public") private boolean public_;

}
