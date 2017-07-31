package com.ceehn.util;

import android.content.Context;

/**
 * Created by lebang on 2017/7/1.
 */

public class CommonUtil {
    private static CommonUtil sInstance;
    private Context mContext;

    public CommonUtil(Context context) {
        this.mContext = context;
    }

    public static CommonUtil getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (CommonUtil.class) {
                if (sInstance == null) {
                    sInstance = new CommonUtil(context);
                }
            }
        }
        return sInstance;
    }
}
