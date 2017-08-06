package com.ceehn.flux.stores;

import com.ceehn.flux.MainView;
import com.ceehn.flux.actions.Action;
import com.squareup.otto.Bus;

import java.util.Objects;

/**
 * Created by lebang on 2017/7/30.
 */

public abstract class Store {
    private static final Bus bus = new Bus();

    protected Store() {
    }

    public void register(final Object view) {
        this.bus.register(view);
    }

    public void unregister(final Object view) {
        this.bus.unregister(view);
    }

    void emitStoreChange() {
        this.bus.post(changeEvent());
    }

    public abstract StoreChangeEvent changeEvent();
    public abstract void onAction(Action action);

    public class StoreChangeEvent{}
}
