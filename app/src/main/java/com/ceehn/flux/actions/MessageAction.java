package com.ceehn.flux.actions;

/**
 * Created by lebang on 2017/7/30.
 */

public class MessageAction extends Action<String> {
    public static final String ACTION_NEW_MESSAGE = "new_message";

    public MessageAction(String type, String data) {
        super(type, data);
    }
}
