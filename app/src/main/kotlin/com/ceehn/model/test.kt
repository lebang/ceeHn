package com.ceehn.model

/**
 * Created by lebang on 2017/7/1.
 */

class test {

    var name: String? = null
    var title: String? = null

    constructor() {

    }

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, title: String) {
        this.name = name
        this.title = title
    }

}
