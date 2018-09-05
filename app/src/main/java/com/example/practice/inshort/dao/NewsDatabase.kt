package com.example.practice.inshort.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.practice.inshort.entity.NewsEntity
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.TypeConverters
import android.os.AsyncTask
import com.example.practice.inshort.ui.Utility

@TypeConverters(Converters::class)
@Database(entities = arrayOf(NewsEntity::class), version = 1)

abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
//
    companion object {
        private var INSTANCE: NewsDatabase? = null
        lateinit var new_context:Context

        internal fun getDatabase(context: Context): NewsDatabase {
            new_context = context as Context
            if (INSTANCE == null) {
                synchronized(NewsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                NewsDatabase::class.java, "word_database")
                                // Wipes and rebuilds instead of migrating
                                // if no Migration object.
                                // Migration is not part of this practical.
                                .fallbackToDestructiveMigration().addCallback(sRoomDatabaseCallback)
                                .build()
                    }
                }
            }
            return INSTANCE as NewsDatabase
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE, new_context).execute()
            }
        }

        private class PopulateDbAsync internal constructor(db: NewsDatabase?, context: Context) : AsyncTask<Void, Void, Void>() {

            private val mDao: NewsDao
//            lateinit var context: Context
            var mf = Utility()
            internal var words = mf.get_json(context);


            init {
                mDao = db!!.newsDao()
            }

            override fun doInBackground(vararg params: Void): Void? {
                // Start the app with a clean database every time.
                // Not needed if you only populate the database
                // when it is first created
                mDao.deleteAll()
                mDao.insertWithNews(words)

                return null
            }
        }


    }
}