package com.example.practice.inshort.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.practice.inshort.fragment.BlankFragment
import com.example.practice.inshort.fragment.NewsFragment
import com.example.practice.inshort.fragment.TopicFragment

public class SwipeAdapter(fragmentManager: FragmentManager, position: Int, mactivity:AppCompatActivity, category: String, url:String) : FragmentPagerAdapter(fragmentManager) {

    lateinit var mactivity:AppCompatActivity
    var category=category
    var url=url
    init{
        this.mactivity = mactivity
    }

    override fun getItem(position: Int): Fragment {
        var topicfragment = TopicFragment()
        var newsfragment = NewsFragment.newInstance(category)
        var webviewfragment = BlankFragment.newInstance(url)
        return when (position) {
            0 -> topicfragment
            1 ->  newsfragment
            else ->  webviewfragment
        }
    }

    override fun getCount(): Int {
        return 3
    }
}