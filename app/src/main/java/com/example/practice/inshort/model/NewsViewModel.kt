package com.example.practice.inshort.model

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.practice.inshort.entity.NewsEntity
import com.example.practice.inshort.repository.NewsRepository
import android.app.Application



class NewsViewModel(application: android.app.Application): AndroidViewModel(application){
    private var newsrepository = NewsRepository(application)
    var news : LiveData<List<NewsEntity>>
    init {
        news = newsrepository.allNews
    }
    fun insert(word: NewsEntity) {
        newsrepository.insert(word)
    }

}