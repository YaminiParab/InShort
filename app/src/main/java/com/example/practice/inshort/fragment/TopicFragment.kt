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

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
    lateinit var topic_context:Context


    companion object{
        private val ARG_CAUGHT = "myFragment_caught"
//        lateinit var activity: AppCompatActivity
        private lateinit var mCallback1: Callback
        fun newInstance(my_activity: AppCompatActivity):TopicFragment{
//            if (context is Callback){
            mCallback1 = my_activity as Callback
//            }
            val fragment = TopicFragment()
            return fragment
        }
        fun getcontext():Callback {
            return mCallback1
        }
    }



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

        val topics_adapter = TopicAdapter(this, topicList, view.context,{name:Int->itemClicked(name,"Business")} )
        topics.adapter = topics_adapter

        return view
    }

    /*override fun setViewPagerCurrentPage(page: Int) {
        frgment_page = page
    }
*/
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Callback) {
            listener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement FragmentEvent")
        }
    }
    fun itemClicked(name:Int, msg:String){
        Toast.makeText(context,"item clicked"+name, Toast.LENGTH_LONG).show()
        Log.d("msg","item clicked"+name)
        onButtonPressed(name, msg)
    }


    fun onButtonPressed(pageno:Int, msg:String) {
        listener?.setViewPagerCurrentPage(pageno, msg)
    }

    interface Callback {
        fun setViewPagerCurrentPage(page: Int, msg:String)
    }

    fun setListener(callback:AppCompatActivity) {
        this.mCallback2 = callback as Callback
    }
}



