package com.example.practice.inshort.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.inshort.R
import com.example.practice.inshort.model.Topic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.singleitem.view.*
import android.support.v4.app.Fragment
import com.example.practice.inshort.ui.MainViewPager


class TopicAdapter (val fragment : Fragment, val topicsList: ArrayList<Topic>, val context:Context,val clickListener:(Int) -> Unit):RecyclerView.Adapter<TopicAdapter.ViewHolder>() {



    lateinit var mContext:Context

    init {
        mContext=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicAdapter.ViewHolder{
        return TopicAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.singleitem, parent, false),mContext)
    }

    override fun getItemCount(): Int {
        return topicsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(topicsList.get(position).image_name,clickListener)
        val topics = topicsList?.get(position);
        holder.topic_name.setText(topics.image_name)
        Picasso.with(context).load(topics.image).error(R.drawable.sample_7).placeholder(R.drawable.sample_0).into(holder.topic_image)
        var view_pager_obj = MainViewPager()
        var newsadp = NewsAdapter(mContext)
    }

    class ViewHolder(view:View, context:Context):RecyclerView.ViewHolder(view)  {
        lateinit var viewContext:Context
        lateinit var mView:View
        init {
            viewContext=context
            mView=view

        }
        val topic_image = view.imageview

        val topic_name = view.image_name
        fun bindItems(name:String,clickListener:(Int)->Unit){
           topic_name.text=name
            topic_name.setOnClickListener{clickListener(1)}
            topic_image.setOnClickListener{clickListener(1)}
        }

    }



}
