package com.example.practice.inshort.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "news_table")
class NewsEntity(
        val source: String,
        @field:PrimaryKey
        val author:String,
        val title:String,
        val description:String,
        val url:String,
        val urlToImage:String,
        val publishedAt:String
        )