package com.ceehn.request;

/**
 * Created by lebang on 2017/7/25.
 */

public class HttpConstants {

    private static final String URL_BASE = "https://api.assistant.miui.com/stock";

    // search url: http://api.assistant.miui.com/stock/search?key=sz​
    public static final String URL_SEARCH = URL_BASE + "/search?";
    public static final String URL_SEARCH_PARAM_KET = "key";
    //getbatch url: http://api.assistant.miui.com/stock/getBatch?id=502049&id=502050
    public static final String URL_GETBATCH = URL_BASE + "/getBatch?";
    public static final String URL_GETBATCH_PARAM_KEY = "id";
    //get userId url: http://api.assistant.miui.com/stock/getUserName?imei=IMEI的MD5值
    public static final String URL_GET_USER_ID_URL =  URL_BASE + "/getUserName?";
    public static final String URL_GET_USER_ID_PARAM_IMEI = "imei";

    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_NOT_MODIFIED = 304;

    public static final class Tag {
        public static final String KEY_RESULT = "result";
        public static final String KEY_DATA = "data";
        public static final String KEY_OK = "OK";
    }
}
