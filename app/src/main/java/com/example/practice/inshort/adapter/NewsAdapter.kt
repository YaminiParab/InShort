package com.example.practice.inshort.adapter

import android.support.v7.widget.RecyclerView
import com.example.practice.inshort.modal.News
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.view.ViewGroup
import com.example.practice.inshort.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.singlenews.view.*

class NewsAdapter(val newsList: ArrayList<News>, val context:Context) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    private val android: ArrayList<News>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.singlenews, parent, false))
    }

    override fun getItemCount(): Int {
        return newsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList?.get(position);
        holder.published_date.setText(news.publishedAt)
        holder.news_title.setText(news.title)
        holder.short_desciption.setText(news.description)
        Picasso.with(context).load(news.urlToImage).error(R.drawable.sample_7).placeholder(R.drawable.sample_0).into(holder.news_image)
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val news_image = view.news_image;
        val news_title = view.news_title;
        val short_desciption = view.short_desciption;
        val published_date = view.published_date;




    }

    fun setData(newsList: List<News>) {
        this.newsList.addAll(newsList)
        notifyDataSetChanged()
    }
}


