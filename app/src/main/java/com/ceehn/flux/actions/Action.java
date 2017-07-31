package com.ceehn.flux.actions;

/**
 * Created by lebang on 2017/7/30.
 */

public class Action<T> {
    private final String type;
    private final T data;

    public Action(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
