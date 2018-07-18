package com.example.practice.inshort.adapter

import android.support.v7.widget.RecyclerView
import com.example.practice.inshort.model.News
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.practice.inshort.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.singlenews.view.*


class NewsAdapter(val context: Context, val newsList:List<News>?)
    : PagerAdapter() {

    var mLayoutInflater: LayoutInflater
    var position:Int=0
    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.singlenews, container, false)
        this.position=position
        Log.d("position", position.toString())
        val newsImg = itemView.findViewById(R.id.news_image) as ImageView
        val newsHead = itemView.findViewById(R.id.news_title) as TextView
        val newsDesc = itemView.findViewById(R.id.short_desciption) as TextView
        val newsDate = itemView.findViewById(R.id.published_date) as TextView
//        val newsSource = itemView.findViewById(R.id.news_source) as TextView
//        val newsAuthor = itemView.findViewById(R.id.news_author) as TextView

        Picasso.with(context).load(newsList?.get(position)?.urlToImage).into(newsImg)
        newsHead.text = newsList?.get(position)?.title
        newsDesc.text = newsList?.get(position)?.description
        newsDate.text = newsList?.get(position)?.publishedAt
//        newsSource.text = newsList?.get(position)?.source
//        val source_url = newsList?.get(position.toInt())?.url


        container.addView(itemView)
        return itemView

    }

    fun getCurrentIndex():Int{
        Log.d("currunt index", position.toString())
        return position
    }

    override fun getCount(): Int {
        if (newsList == null) {
            return 0
        } else {
            return newsList!!.size
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }



    override fun getItemPosition(`object`: Any): Int {
        Log.d("tag123", super.getItemPosition(`object`).toString())
        return super.getItemPosition(`object`)
    }}







