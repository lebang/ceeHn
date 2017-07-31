package com.ceehn.flux.stores;


import com.ceehn.flux.actions.Action;
import com.ceehn.flux.actions.MessageAction;
import com.ceehn.flux.model.Message;

/**
 * Created by lebang on 2017/7/30.
 */

public class MessageStore extends Store {

    private static MessageStore singleton;
    private Message mMessage = new Message();

    public MessageStore() {
        super();
    }

    public String getMessage() {
        return mMessage.getMessage();
    }

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent();
    }

    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case MessageAction.ACTION_NEW_MESSAGE:
                mMessage.setMessage((String) action.getData());
                break;
            default:
                break;
        }
        emitStoreChange();
    }
}
