package com.example.practice.inshort.ui

import android.content.Context
import android.util.Log
import com.example.practice.inshort.entity.NewsEntity
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class Utility {

    public fun get_json(context:Context): ArrayList<NewsEntity> {
        val newsList: ArrayList<NewsEntity> = ArrayList()
        var json:String
        try {
            var gson: Gson = Gson()
            val inputStream: InputStream = context.assets?.open("news.json")!!
            val inputString = inputStream.bufferedReader().use{it.readText()}

            // convert string into jsonobject
            var jsonObject: JSONObject = JSONObject(inputString)

            // It will return specific JsonArray from json object
            var articleArray = jsonObject.getJSONArray("articles")

            for (article_index in 0 until articleArray.length()) {
                try {
                    var oneObject = articleArray.getJSONObject(article_index)
                    var response = gson.fromJson(oneObject.toString(), NewsEntity::class.java)
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