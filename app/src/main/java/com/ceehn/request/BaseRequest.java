package com.ceehn.request;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lebang on 2017/7/25.
 */

public abstract class BaseRequest {
    private static final String TAG = "BaseRequest";

    protected Context mContext;
    protected String mRequestUrl;
    protected String mRequsetMethod;

    private final String DEFAULT_REQUEST_METHOD_GET = "GET";
    private final int DEFAULT_REQUEST_TIMEOUT = 10*1000;
    private final int DEFAULT_REQUEST_READ_TIMEOUT = 5*1000;

    public static final int STATUS_OK = 0;
    public static final int STATUS_NETWORK_UNAVAILABLE = 1;
    public static final int STATUS_SERVICE_UNAVAILABLE = 2;
    public static final int STATUS_UNKNOWN_ERROR = 3;
    public static final int STATUS_CLIENT_ERROR = 4;
    public static final int STATUS_SERVER_ERROR = 5;
    public static final int STATUS_NOT_MODIFIED = 7;


    public BaseRequest(Context context, String requestUrl) {
        this.mContext = context;
        this.mRequestUrl = requestUrl;
        this.mRequsetMethod = DEFAULT_REQUEST_METHOD_GET;
    }

    public BaseRequest(Context context, String requestUrl, String requestMethod) {
        this.mContext = context;
        this.mRequestUrl = requestUrl;
        this.mRequsetMethod = requestMethod;
    }

    protected HttpURLConnection getConn() {
        if (TextUtils.isEmpty(mRequestUrl)) {
            return null;
        }
        HttpURLConnection connection = null;
        try {
            URL req = new URL(mRequestUrl);
            connection = (HttpURLConnection) req.openConnection();
            connection.setReadTimeout(DEFAULT_REQUEST_READ_TIMEOUT);
            connection.setConnectTimeout(DEFAULT_REQUEST_TIMEOUT);
            connection.setRequestMethod(mRequsetMethod);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
