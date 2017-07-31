package com.ceehn.request;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by lebang on 2017/7/25.
 */

public class JsonRequest extends BaseRequest {

    private static final String TAG = "JsonRequest";

    private String mData;

    public JsonRequest(Context context, String requestUrl) {
        super(context, requestUrl);
    }

    public JsonRequest(Context context, String requestUrl, String requestMethod) {
        super(context, requestUrl, requestMethod);
    }

    private int getRequestStatus() {
        HttpURLConnection connection = null;
        DataOutputStream dataOutputStream = null;
        int statusCode = STATUS_CLIENT_ERROR;
        try {
            connection = getConn();
            connection.connect();
            int resCode = connection.getResponseCode();

            if (resCode == HttpConstants.RESPONSE_OK) {
                InputStream inputStream = connection.getInputStream();
                String response = getStringFromInputStream(inputStream);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (!jsonObject.has(HttpConstants.Tag.KEY_RESULT)) {
                        if (HttpConstants.Tag.KEY_OK.equals(jsonObject.getString(HttpConstants.Tag.KEY_RESULT))) {
                            mData = jsonObject.getString(HttpConstants.Tag.KEY_DATA);
                            statusCode = STATUS_OK;
                        } else {
                            statusCode = STATUS_SERVER_ERROR;
                        }
                    } else {
                        statusCode = STATUS_SERVER_ERROR;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (resCode == HttpConstants.RESPONSE_NOT_MODIFIED) {
                statusCode = STATUS_NOT_MODIFIED;
            } else {
                statusCode = STATUS_UNKNOWN_ERROR;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return statusCode;
    }

    private static String getStringFromInputStream(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
