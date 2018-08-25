package com.example.practice.inshort.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.practice.inshort.R
import android.view.Menu
import com.example.practice.inshort.adapter.CategoryAdapter
import com.example.practice.inshort.adapter.TopicAdapter
import com.example.practice.inshort.model.Category
import com.example.practice.inshort.model.Topic
import kotlinx.android.synthetic.main.search_by_category.*
import java.util.ArrayList


class SearchByCategory  : AppCompatActivity (){
    val categoryList: ArrayList<Category> = ArrayList()
    val topicList:ArrayList<Topic> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_by_category)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        // recycler view for horizontal news category

        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        categoryList.add(Category("MY FEED",R.drawable.business))
        categoryList.add(Category("ALL NEWS",R.drawable.business))
        categoryList.add(Category("TOP STORIES",R.drawable.business))
        categoryList.add(Category("TRENDING",R.drawable.business))
        categoryList.add(Category("BOOKMARKS",R.drawable.business))
        categoryList.add(Category("UNREAD",R.drawable.business))
        val adapter = CategoryAdapter(categoryList, this);
        recyclerview.adapter = adapter

        // recycler view for vertical news topics

        topics.layoutManager = GridLayoutManager(this, 3)
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

//        val topics_adapter = TopicAdapter(topicList, this)
//        topics.adapter = topics_adapter



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menus, menu)
        menu?.findItem(R.id.action_search);


        return true;
    }
}