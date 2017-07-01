package com.ceehn.ui

import android.content.Intent
import android.os.Bundle
import com.ceehn.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_hello.text = "kotlin, hello world!"
        txt_hello.setOnClickListener {
            toast("hello world")

            startActivity(Intent(this@MainActivity, CollegeListActivity::class.java));
        }
    }


}
