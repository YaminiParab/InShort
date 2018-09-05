package com.example.practice.inshort.repository

import android.arch.lifecycle.LiveData
import com.example.practice.inshort.dao.NewsDao
import com.example.practice.inshort.dao.NewsDatabase
import com.example.practice.inshort.entity.NewsEntity
import android.app.Application
import android.os.AsyncTask


class NewsRepository(application: Application) {

    private var mNewsDao: NewsDao
    lateinit var  allNews: LiveData<List<NewsEntity>>
    var db: NewsDatabase? = null
    init {
        db = NewsDatabase.getDatabase(application)
        mNewsDao = db!!.newsDao()

    }

    fun insert(word: NewsEntity) {
        insertAsyncTask(mNewsDao).execute(word)
    }

    fun getNewsByTopics(topic:String):LiveData<List<NewsEntity>> {
        return mNewsDao.filterNews(topic)

    }
    fun repoAllNews():LiveData<List<NewsEntity>> {
        return  mNewsDao.getAllNews()
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: NewsDao) : AsyncTask<NewsEntity, Void, Void>() {

        override fun doInBackground(vararg params: NewsEntity): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }



    }

