package com.example.practice.inshort.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.NewsAdapter
import com.example.practice.inshort.model.News
import com.example.practice.inshort.ui.NewsActivity
import com.example.practice.inshort.ui.VerticalViewPager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.activity_news.view.*
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

lateinit var adapter : NewsAdapter
class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View
        view = inflater.inflate(R.layout.activity_news, container, false)

        var news_detail = view.news_detail
        var newsActivity = NewsActivity()
        var newsList = get_json();

//        news_detail.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false);
        adapter = NewsAdapter(view.context, newsList);
        val verticalViewPager = view.findViewById(R.id.vPager) as VerticalViewPager?
        verticalViewPager?.adapter = adapter
//        news_detail.adapter = adapter

//        view.setOnTouchListener {v: View, m: MotionEvent ->
//            // Perform tasks here
//            Log.d("touch here","touchhhhhhhhhhhhhhhh")
//            true
//        }

        return view


    }

    public fun get_json(): ArrayList<News> {
        val newsList: ArrayList<News> = ArrayList()
        var json:String
        try {
            var gson: Gson = Gson()
            val inputStream: InputStream = activity?.assets?.open("news.json")!!
            val inputString = inputStream.bufferedReader().use{it.readText()}

            // convert string into jsonobject
            var jsonObject: JSONObject = JSONObject(inputString)

            // It will return specific JsonArray from json object
            var articleArray = jsonObject.getJSONArray("articles")

            for (article_index in 0 until articleArray.length()) {
                try {
                    var oneObject = articleArray.getJSONObject(article_index)
                    var response = gson.fromJson(oneObject.toString(), News::class.java)
                    newsList.add(response)

                } catch (e: JSONException) {
                    Log.d("JSONException", e.toString())
                }

            }

        } catch (e:Exception){
            Log.d("error :", e.toString())
        }
        return newsList
    }



}
