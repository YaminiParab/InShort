package com.example.practice.inshort.fragment


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.NewsAdapter
import com.example.practice.inshort.entity.NewsEntity
import com.example.practice.inshort.model.NewsViewModel
import com.example.practice.inshort.ui.NewsActivity
import com.example.practice.inshort.ui.VerticalViewPager
import kotlinx.android.synthetic.main.activity_news.view.*

class NewsFragment : Fragment() {
    lateinit var mNewsViewModel: NewsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View
        mNewsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        view = inflater.inflate(R.layout.activity_news, container, false)

       /* var news_detail = view.news_detail

        news_detail.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false);*/
        var adapter = NewsAdapter(view.context);



        mNewsViewModel!!.news.observe(this, object : Observer<List<NewsEntity>> {
            override fun onChanged(t: List<NewsEntity>?) {
                if (t != null) {
                    adapter.setNews(t)
                }//To change body of created functions use File | Settings | File Templates.
            }


        })

        val verticalViewPager = view.findViewById(R.id.vPager) as VerticalViewPager?

        verticalViewPager?.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN ->{
                        Toast.makeText(activity,"view touch", Toast.LENGTH_SHORT).show()
                    } //Do Something
                }

                return v?.onTouchEvent(event) ?: true
            }
        })
        verticalViewPager?.adapter = adapter
        verticalViewPager?.setCurrentItem(1)
        return view


    }









}
