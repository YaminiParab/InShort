package com.example.practice.inshort.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.practice.inshort.dao.Converters

@Entity(tableName = "news_table")

class NewsEntity(

        val source: String,
        @field:PrimaryKey
        val author:String,
        val title:String,
        val description:String,
        val url:String,
        val urlToImage:String,
        val publishedAt:String,
        @TypeConverters(Converters::class)
        val category: List<String>?=null,
        @TypeConverters(Converters::class)
        val topics:List<String>?=null
        )