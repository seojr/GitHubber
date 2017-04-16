package com.orangecaw.android.githubber.util;

public class Credentials {

    public static String basic(String username, String password) {
        return okhttp3.Credentials.basic(username, password);
    }

    public static String token(String token) {
        return "token " + token;
    }

}
