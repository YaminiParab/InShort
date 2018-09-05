package com.example.practice.inshort.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.SwipeAdapter
import com.example.practice.inshort.fragment.NewsFragment
import com.example.practice.inshort.fragment.TopicFragment

class MainViewPager: AppCompatActivity(),TopicFragment.Callback {


    var change_page = 1
    lateinit var viewpager:ViewPager
    var category:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        viewpager = findViewById(R.id.main_viewpager)
        if (viewpager != null) {
            val pagerAdapter = SwipeAdapter(supportFragmentManager, 0, this@MainViewPager,
                    category)
            viewpager.adapter = pagerAdapter
            viewpager.currentItem = change_page
        }



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menus, menu)
        menu?.findItem(R.id.action_search);


        return true;
    }
    override fun setViewPagerCurrentPage(page: Int, category:String) {
        if (viewpager != null) {
            if (page == 1) {
                NewsFragment.newInstance(category)
            }
            val pagerAdapter = SwipeAdapter(supportFragmentManager, 0,
                    this@MainViewPager, category)
            viewpager.adapter = pagerAdapter
            viewpager.currentItem = change_page
        }
        else{
            change_page = page
            viewpager.currentItem = change_page
        }

    }
}