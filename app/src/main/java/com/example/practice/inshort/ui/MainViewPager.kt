package com.example.practice.inshort.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.SwipeAdapter
import com.example.practice.inshort.fragment.TopicFragment

class MainViewPager: Callback, AppCompatActivity() {
    var change_page = 0
    lateinit var viewpager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        viewpager = findViewById(R.id.main_viewpager)
        if (viewpager != null) {
            val pagerAdapter = SwipeAdapter(supportFragmentManager, 0, this@MainViewPager)
            viewpager.adapter = pagerAdapter
            viewpager.currentItem = change_page
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menus, menu)
        menu?.findItem(R.id.action_search);


        return true;
    }
    override fun setViewPagerCurrentPage(page: Int) {
        //var viewpager1 = findViewById<ViewPager>(R.id.main_viewpager)
        if (page >= 0) {
        if(viewpager == null){
            viewpager = findViewById<ViewPager>(R.id.main_viewpager)
        }
            change_page = page
            viewpager.currentItem = change_page
        }
    }
}