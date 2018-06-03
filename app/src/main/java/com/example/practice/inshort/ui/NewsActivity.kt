package com.example.practice.inshort.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.NewsAdapter
import com.example.practice.inshort.modal.News
import kotlinx.android.synthetic.main.activity_news.*

import java.util.*
//import com.example.practice.inshort.modal.JSONResponse
import android.R.attr.data
//import jdk.nashorn.internal.objects.Global.getJSON
import com.example.practice.inshort.modal.RequestInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import android.R.attr.data
import android.util.Log
//import jdk.nashorn.internal.objects.Global.getJSON
import com.example.practice.inshort.modal.JSONResponse
import android.R.attr.data
import android.util.JsonReader
//import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.nio.file.Files.size

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.search_by_category.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONStringer
import java.io.BufferedReader
import java.io.File
import java.io.InputStream


class NewsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        get_json();

         //on click of search icon redirect to search detail activity
         val topstories = findViewById<View>(R.id.topStoriesView)
         topstories.setOnClickListener {
             val newsActivityIntent = Intent(this,SearchByCategory::class.java);
             startActivity(newsActivityIntent)
         }
    }



    public fun get_json() {
        val newsList: ArrayList<News> = ArrayList()
        var json:String

        try {
            var gson:Gson=Gson()
            val inputStream:InputStream = assets.open("news.json")
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
            news_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            val adapter = NewsAdapter(newsList, this);
            news_detail.adapter = adapter

        } catch (e:Exception){
            Log.d("error :", e.toString())
        }

            }

    }
