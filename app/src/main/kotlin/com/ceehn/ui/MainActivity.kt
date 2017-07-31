package com.ceehn.ui

import android.os.Bundle
import com.ceehn.R
import com.ceehn.request.JsonRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        txt_hello.text = "kotlin, hello world!"
        txt_hello.setOnClickListener {
            toast("hello world")

//            startActivity(Intent(this@MainActivity, CollegeListActivity::class.java));
            startActivity<CollegeListActivity>()

//            Intent intent = new Intent(MainActivity.this, CollegeListActivity.class);
//            intent.putExtra("id", 10001);
//            intent.putExtra("name", "ricky");
//            startActivity(intent);
//            startActivity<CollegeListActivity>("id" to 1001, "name" to "ricky")

//            var req = JsonRequest(applicationContext, "");

        }

    }


}
