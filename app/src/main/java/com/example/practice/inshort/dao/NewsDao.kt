package com.example.practice.inshort.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.practice.inshort.entity.NewsEntity

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: NewsEntity)

    @Query("Delete from news_table")
    fun deleteAll()

    @Query("SELECT * from news_table ORDER BY title ASC")
    fun getAllNews(): LiveData<List<NewsEntity>>


    @Query("SELECT * from news_table where news_table.topics like :category_name ORDER BY title ASC")
    fun filterNews(category_name: String): LiveData<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWithNews(news: List<NewsEntity>)
}