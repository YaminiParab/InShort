package com.example.practice.inshort.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.SwipeAdapter
import com.example.practice.inshort.fragment.NewsFragment
import com.example.practice.inshort.fragment.TopicFragment
import android.support.v4.view.ViewPager.OnPageChangeListener
import android.util.Log
import android.webkit.WebViewFragment
import com.example.practice.inshort.fragment.BlankFragment


class MainViewPager: AppCompatActivity(),TopicFragment.Callback {


    var change_page = 1
    lateinit var viewpager:ViewPager
    var category:String = ""
    var url:String = ""
    lateinit var web_fragment:BlankFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        viewpager = findViewById(R.id.main_viewpager)
        if (viewpager != null) {
            val pagerAdapter = SwipeAdapter(supportFragmentManager, 0, this@MainViewPager,
                    category, url)
            viewpager.adapter = pagerAdapter
            viewpager.currentItem = change_page
        }
        viewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                if (position == 2) {
//                    web_fragment = viewpager.adapter!!.instantiateItem(viewpager,viewpager.currentItem) as BlankFragment
//                    web_fragment.load_url()
                    //viewpager.currentItem = 2
                }
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menus, menu)
        menu?.findItem(R.id.action_search);


        return true;
    }
    override fun setViewPagerCurrentPage(page: Int, category:String) {
        if (viewpager != null) {
            var url:String=""
            if (page == 1) {
                var abc = NewsFragment()
                abc.set_cat(category)
            }
            val pagerAdapter = SwipeAdapter(supportFragmentManager, 0,
                    this@MainViewPager, category, url)
            viewpager.adapter = pagerAdapter
            viewpager.currentItem = change_page
        }
        else{
            change_page = page
            viewpager.currentItem = change_page
        }

    }

}

private fun ViewPager.addOnPageChangeListener() {

    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
