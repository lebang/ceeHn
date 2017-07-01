package com.ceehn.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.ceehn.R
import com.ceehn.adapter.CollegeAdapter
import com.ceehn.model.College
import kotlinx.android.synthetic.main.activity_college_list.*

class CollegeListActivity : BaseActivity() {

    private val items = listOf<College>(
            College("清华大学"),
            College("北京大学"),
            College("复旦大学"),
            College("中山大学")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_list)

        college_list.layoutManager = LinearLayoutManager(this)
        college_list.adapter = CollegeAdapter(items)
    }
}
