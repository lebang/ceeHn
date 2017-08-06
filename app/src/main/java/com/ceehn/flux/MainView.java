package com.ceehn.flux;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ceehn.R;
import com.ceehn.flux.actions.ActionCreator;
import com.ceehn.flux.stores.MessageStore;
import com.ceehn.flux.stores.Store;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by lebang on 2017/7/30.
 */

public class MainView extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn;
    private EditText mEdit;
    private TextView mTxt;

    private Dispatcher dispatcher;
    private ActionCreator actionCreator;
    private MessageStore messageStore;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_flux);

        initDependecies();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        messageStore.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        messageStore.unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispatcher.unregister(messageStore);
    }

    private void  initDependecies() {
        dispatcher = Dispatcher.getInstance();
        actionCreator = ActionCreator.getInstance(dispatcher);
        messageStore = new MessageStore();
        dispatcher.register(messageStore);
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.message_button);
        mEdit = (EditText) findViewById(R.id.message_editor);
        mTxt = (TextView) findViewById(R.id.message_view);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_button:
                if (mEdit.getText() != null) {
                    actionCreator.sendMessage(mEdit.getText().toString());
                    mEdit.setText(null);
                }
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event) {
        render(messageStore);
    }

    private void render(MessageStore store) {
        mTxt.setText(store.getMessage());
    }
}
