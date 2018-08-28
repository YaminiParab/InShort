package com.example.practice.inshort.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.NewsAdapter
import com.example.practice.inshort.model.News
import kotlinx.android.synthetic.main.activity_news.*

import java.util.*
//import com.example.practice.inshort.modal.JSONResponse
//import jdk.nashorn.internal.objects.Global.getJSON
//import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import android.widget.Toast
import com.example.practice.inshort.fragment.TopicFragment
//import jdk.nashorn.internal.objects.Global.getJSON
//import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream
import kotlin.collections.ArrayList


class NewsActivity : Activity() {
//    override fun setViewPagerCurrentPage(page: Int, msg:String) {
//        Toast.makeText(this,"Btn2 pressed", Toast.LENGTH_SHORT).show()
////        if (viewpager!=null){
////            viewpager.currentItem = 0
////        }
//
//    }

    lateinit var viewPagerAdapter: NewsAdapter

    lateinit var viewPager: VerticalViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        viewPager = findViewById(R.id.vPager) as VerticalViewPager
        viewPagerAdapter = NewsAdapter(this)
        viewPager.setAdapter(viewPagerAdapter)


//        get_json();

         //on click of search icon redirect to search detail activity
         val topstories = findViewById<View>(R.id.topStoriesView)
         topstories.setOnClickListener {
             val newsActivityIntent = Intent(this,SearchByCategory::class.java);
             startActivity(newsActivityIntent)
         }
    }


    public fun get_json(): ArrayList<News> {
        val newsList: ArrayList<News> = ArrayList()
        var json:String
        try {
            var gson:Gson=Gson()
            val inputStream:InputStream = application.assets.open("news.json")
            val inputString = inputStream.bufferedReader().use{it.readText()}

            // convert string into jsonobject
            var jsonObject: JSONObject= JSONObject(inputString)

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
