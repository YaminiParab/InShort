package com.example.practice.inshort.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewFragment
import com.example.practice.inshort.fragment.BlankFragment
import com.example.practice.inshort.fragment.NewsFragment
import com.example.practice.inshort.fragment.TopicFragment

public class SwipeAdapter(fragmentManager: FragmentManager, position: Int, mactivity:AppCompatActivity) : FragmentPagerAdapter(fragmentManager) {

    lateinit var mactivity:AppCompatActivity

    init{
        this.mactivity = mactivity
    }

    override fun getItem(position: Int): Fragment {
        var topicfragment = TopicFragment()
//        topicfragment.setListener(mactivity)
        var newsfragment = NewsFragment()
        var webviewfragment = BlankFragment()
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