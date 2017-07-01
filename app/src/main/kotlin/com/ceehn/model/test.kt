package com.ceehn.model

/**
 * Created by lebang on 2017/7/1.
 */

class test(private var name: String?) {
    fun setName(name: String) {
        this.name = name
    }

    fun getName(name: String): String {
        return name
    }
}
