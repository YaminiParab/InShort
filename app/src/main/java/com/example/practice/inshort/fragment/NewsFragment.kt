package com.example.practice.inshort.fragment


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.NewsAdapter
import com.example.practice.inshort.adapter.SwipeAdapter
import com.example.practice.inshort.entity.NewsEntity
import com.example.practice.inshort.model.NewsViewModel
import com.example.practice.inshort.ui.NewsActivity
import com.example.practice.inshort.ui.VerticalViewPager
import kotlinx.android.synthetic.main.activity_news.view.*
import android.support.v4.view.ViewPager.OnPageChangeListener



class NewsFragment() : Fragment(){

    lateinit var mNewsViewModel: NewsViewModel
    var current_item_position:Int=0
    var news_url:String=""
    lateinit var all_news:List<NewsEntity>
    companion object {

        lateinit var cat_name:String

        fun newInstance(name: String): NewsFragment {
            cat_name = name
            val fragment = NewsFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View
        mNewsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        view = inflater.inflate(R.layout.activity_news, container, false)

        var adapter = NewsAdapter(view.context);
        val verticalViewPager = view.findViewById(R.id.vPager) as VerticalViewPager?
        if (!cat_name.isEmpty()) {
            cat_name = "%"+ cat_name+"%"
            mNewsViewModel.get_topic_related_news(cat_name).observe(this, object : Observer<List<NewsEntity>> {
                override fun onChanged(t: List<NewsEntity>?) {
                    if (t != null) {

                        adapter.setNews(t)
                        all_news = t
                        if (verticalViewPager != null) {
                            news_url = all_news.get(verticalViewPager.currentItem).url
                            BlankFragment.newInstance(news_url)
                        }
                    }
                }
            })
        }
        else {
            mNewsViewModel!!.all_news_data().observe(this, object : Observer<List<NewsEntity>> {
                override fun onChanged(t: List<NewsEntity>?) {
                    if (t != null) {

                        adapter.setNews(t)
                        all_news = t
                        if (verticalViewPager != null) {
                            news_url = all_news.get(verticalViewPager.currentItem).url
                            BlankFragment.newInstance(news_url)
                        }

                    }//To change body of created functions use File | Settings | File Templates.
                }
            })

        }

        if (verticalViewPager != null) {
            verticalViewPager.addOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
                override fun onPageSelected(position: Int) {
                    current_item_position = verticalViewPager.currentItem
                    news_url = all_news.get(current_item_position).url
                    BlankFragment.newInstance(news_url)
                }
            })
        }
        verticalViewPager?.adapter = adapter
        return view


    }

}
