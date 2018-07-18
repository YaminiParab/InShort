package com.example.practice.inshort.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup

import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.CategoryAdapter
import com.example.practice.inshort.adapter.TopicAdapter
import com.example.practice.inshort.model.Category
import com.example.practice.inshort.model.Topic
import kotlinx.android.synthetic.main.search_by_category.*
import kotlinx.android.synthetic.main.search_by_category.view.*
import java.util.ArrayList

class TopicFragment : Fragment() {

    val categoryList: ArrayList<Category> = ArrayList()
    val topicList: ArrayList<Topic> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view: View
        view = inflater.inflate(R.layout.search_by_category, container, false)
        var recyclerview = view.recyclerview
        var topics = view.topics

        // recycler view for horizontal news category

        recyclerview.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false);

        categoryList.add(Category("MY FEED",R.drawable.business))
        categoryList.add(Category("ALL NEWS",R.drawable.business))
        categoryList.add(Category("TOP STORIES",R.drawable.business))
        categoryList.add(Category("TRENDING",R.drawable.business))
        categoryList.add(Category("BOOKMARKS",R.drawable.business))
        categoryList.add(Category("UNREAD",R.drawable.business))
        val adapter = CategoryAdapter(categoryList, view.context);
        recyclerview.adapter = adapter

        // recycler view for vertical news topics

        topics.layoutManager = GridLayoutManager(view.context, 3)
        topicList.add(Topic(R.drawable.ipl, "IPL 2018"))
        topicList.add(Topic(R.drawable.karnataka_polls, "Karnataka Polls"))
        topicList.add(Topic(R.drawable.india, "India"))
        topicList.add(Topic(R.drawable.business, "Business"))
        topicList.add(Topic(R.drawable.politics, "Politics"))
        topicList.add(Topic(R.drawable.sports, "Sports"))
        topicList.add(Topic(R.drawable.technology, "Technology"))
        topicList.add(Topic(R.drawable.startup, "Startups"))
        topicList.add(Topic(R.drawable.entertainment, "Entertainment"))
        topicList.add(Topic(R.drawable.hatke, "Hatke"))
        topicList.add(Topic(R.drawable.international, "International"))
        topicList.add(Topic(R.drawable.automobile, "Automobile"))
        topicList.add(Topic(R.drawable.science, "Science"))
        topicList.add(Topic(R.drawable.travel, "Travel"))
        topicList.add(Topic(R.drawable.misc, "Miscellaneous"))

        val topics_adapter = TopicAdapter(topicList, view.context)
        topics.adapter = topics_adapter
        return view
    }



}


