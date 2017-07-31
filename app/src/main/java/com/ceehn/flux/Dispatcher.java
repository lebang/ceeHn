package com.ceehn.flux;

import com.ceehn.flux.actions.Action;
import com.ceehn.flux.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lebang on 2017/7/30.
 */

public class Dispatcher {
    private static Dispatcher instance;
    private final List<Store> stores = new ArrayList<>();

    public static Dispatcher getInstance() {
        if (instance == null) {
            synchronized (Dispatcher.class) {
                instance = new Dispatcher();
            }
        }
        return instance;
    }

    public void register(final Store store) {
        if (!stores.contains(store)) {
            stores.add(store);
        }
    }

    public void unregister(final Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}
