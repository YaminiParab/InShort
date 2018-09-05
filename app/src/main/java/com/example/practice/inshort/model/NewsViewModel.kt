package com.example.practice.inshort.model

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.practice.inshort.entity.NewsEntity
import com.example.practice.inshort.repository.NewsRepository
import android.app.Application



class NewsViewModel(application: android.app.Application): AndroidViewModel(application){
    private var newsrepository = NewsRepository(application)
    lateinit var news : LiveData<List<NewsEntity>>
    lateinit var topic_news : LiveData<List<NewsEntity>>
    init {

    }
    fun insert(word: NewsEntity) {
        newsrepository.insert(word)
    }
    fun get_topic_related_news(topic:String):LiveData<List<NewsEntity>> {
        topic_news = newsrepository.getNewsByTopics(topic)
        return topic_news
    }
    fun all_news_data():LiveData<List<NewsEntity>> {
        news = newsrepository.repoAllNews()
        return news
    }
}