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

class MainViewPager: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        var viewpager = findViewById<ViewPager>(R.id.main_viewpager)
        if (viewpager != null) {
            val pagerAdapter = SwipeAdapter(supportFragmentManager, 0)
            viewpager.adapter = pagerAdapter
            viewpager.currentItem = 0
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menus, menu)
        menu?.findItem(R.id.action_search);


        return true;
    }

}