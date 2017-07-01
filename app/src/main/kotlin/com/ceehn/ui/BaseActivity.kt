package com.ceehn.ui

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by lebang on 2017/6/30.
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun Context.toast(msg: CharSequence) =
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}