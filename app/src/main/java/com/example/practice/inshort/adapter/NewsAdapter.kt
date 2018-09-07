package com.example.practice.inshort.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.practice.inshort.R
import com.example.practice.inshort.entity.NewsEntity
import com.example.practice.inshort.ui.VerticalViewPager
import com.squareup.picasso.Picasso


class NewsAdapter(val context: Context)
    : PagerAdapter() {

    var mLayoutInflater: LayoutInflater
    var position:Int=0
    private var mWords : List<NewsEntity> = emptyList()
    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.singlenews, container, false)
        this.position=position
        val current = mWords!!.get(position)
        val newsImg = itemView.findViewById(R.id.news_image) as ImageView
        val newsHead = itemView.findViewById(R.id.news_title) as TextView
        val newsDesc = itemView.findViewById(R.id.short_desciption) as TextView
        val newsDate = itemView.findViewById(R.id.published_date) as TextView
        newsHead.text = current.title
        newsDesc.text = current.description
        newsDate.text = current.publishedAt
        Picasso.with(context).load(current.urlToImage).into(newsImg)

        container.addView(itemView)

        itemView.setOnTouchListener {v: View, m: MotionEvent ->
            var user_activity :LinearLayout
            user_activity = v.findViewById<LinearLayout>(R.id.user_activity_layout)

            if (user_activity.getVisibility() == View.VISIBLE)
            {
                user_activity.setVisibility(View.INVISIBLE);
            }
            else
            {
                user_activity.setVisibility(View.VISIBLE);
            }
            val mypref = context.getSharedPreferences("source_url", Context.MODE_PRIVATE)
            val editor =mypref.edit()
            editor.commit()

        }



        return itemView

    }
    internal fun setNews(news: List<NewsEntity>) {
        mWords = news
        notifyDataSetChanged()
    }

    fun getCurrentIndex():Int{
        return position
    }

    override fun getCount(): Int {
        if (mWords == null) {
            return 0
        } else {
            return mWords!!.size
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }}








