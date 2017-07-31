package com.ceehn.flux.actions;

import com.ceehn.flux.Dispatcher;

/**
 * Created by lebang on 2017/7/30.
 */

public class ActionCreator {
    private static ActionCreator instance;
    final Dispatcher dispatcher;

    protected ActionCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static ActionCreator getInstance(Dispatcher dispatcher) {
        if (instance == null) {
            synchronized (ActionCreator.class) {
                if (instance == null) {
                    instance = new ActionCreator(dispatcher);
                }
            }
        }
        return instance;
    }

    public void sendMessage(String message) {
//        dispatcher.
    }
}
