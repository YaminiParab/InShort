package com.example.practice.inshort.dao

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun stringToList(value: String?): List<String>? {

        try {
            val listType = object : TypeToken<List<String>>() {}.type
            return Gson().fromJson(value, listType)
        } catch (e: Exception) {
            return null
        }

    }


    @TypeConverter
    fun listToString(list:List<String>?): String? {
        try {
            val gson = Gson()
            val json = gson.toJson(list)
            return json
        } catch (e: Exception) {
            return null
        }

    }

}