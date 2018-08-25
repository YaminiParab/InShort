package com.example.practice.inshort.ui

class CallViewPagerInterface:Callback {
    var new_page:Int = 0
    override fun setViewPagerCurrentPage(page: Int) {
        new_page=page
    }
}

interface Callback {
    fun setViewPagerCurrentPage(page: Int)
}