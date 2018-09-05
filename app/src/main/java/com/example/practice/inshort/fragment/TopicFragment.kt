package com.example.practice.inshort.fragment

import android.annotation.SuppressLint
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
import android.app.Activity
import android.util.Log
import android.widget.Toast


class TopicFragment : Fragment(){
    var frgment_page:Int = 0



    val categoryList: ArrayList<Category> = ArrayList()
    val topicList: ArrayList<Topic> = ArrayList()
    private lateinit var mCallback2: Callback
    private var listener: Callback? = null

    lateinit var topic_context:Context


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view: View
        view = inflater.inflate(R.layout.search_by_category, container, false)
        topic_context = view.context
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

        val topics_adapter = TopicAdapter(this, topicList, view.context,{name:Int, msg:String->itemClicked(name,msg)} )
        topics.adapter = topics_adapter

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Callback) {
            listener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement FragmentEvent")
        }
    }
    fun itemClicked(name:Int, msg:String){
        onButtonPressed(name, msg)
    }


    fun onButtonPressed(pageno:Int, msg:String) {
        listener?.setViewPagerCurrentPage(pageno, msg)
    }

    interface Callback {
        fun setViewPagerCurrentPage(page: Int, msg:String)
    }

//    fun setListener(callback:AppCompatActivity) {
//        this.mCallback2 = callback as Callback
//    }
}



