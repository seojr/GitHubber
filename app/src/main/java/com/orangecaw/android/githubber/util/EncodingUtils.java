package com.orangecaw.android.githubber.util;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingUtils {

    /**
     * Base64 인코딩
     */
    public static String getBase64encode(String content){
        byte[] data = new byte[0];
        try {
            data = content.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(data, Base64.NO_WRAP);
    }

    /**
     * Base64 디코딩
     */
    public static String getBase64decode(String content){
        return new String(Base64.decode(content, 0));
    }

    /**
     * getURLEncode
     */
    public static String getURLEncode(String content){
        try {
          return URLEncoder.encode(content, "utf-8");   // UTF-8
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * getURLDecode
     */
    public static String getURLDecode(String content){
        try {
          return URLDecoder.decode(content, "utf-8");   // UTF-8
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
