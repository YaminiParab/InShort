package com.example.practice.inshort.modal

//data class News(val image:Int, val title:String, val short_description:String, val date:String)

data class News(val source:String, val author:String, val title:String, val description:String, val url:String,
                val urlToImage:String, val publishedAt:String, val topics:String, val categories:String)


