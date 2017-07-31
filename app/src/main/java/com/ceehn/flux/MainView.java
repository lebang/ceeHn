package com.ceehn.flux;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ceehn.R;

/**
 * Created by lebang on 2017/7/30.
 */

public class MainView extends Activity implements View.OnClickListener {
    private Button mBtn;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_flux);

        mBtn = (Button) findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                break;
            default:
                break;
        }
    }
}
