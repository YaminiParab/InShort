package com.example.practice.inshort.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.practice.inshort.fragment.NewsFragment
import com.example.practice.inshort.fragment.TopicFragment

public class SwipeAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        var topicfragment = TopicFragment()
        var newsfragment = NewsFragment()
        return when (position) {
            0 -> topicfragment
            1 ->  newsfragment
            else ->  topicfragment
        }
    }

    override fun getCount(): Int {
        return 3
    }
}