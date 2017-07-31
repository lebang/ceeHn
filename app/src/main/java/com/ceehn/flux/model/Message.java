package com.ceehn.flux.model;

/**
 * Created by lebang on 2017/7/30.
 */

public class Message {
    private String mText;
    public Message() {

    }

    public Message(String text) {
        this.mText = text;
    }

    public String getMessage() {
        return mText;
    }

    public void setMessage(String text) {
        this.mText = text;
    }
}
