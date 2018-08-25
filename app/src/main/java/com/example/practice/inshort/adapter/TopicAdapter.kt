package com.example.practice.inshort.adapter

import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.inshort.R
import com.example.practice.inshort.fragment.NewsFragment
import com.example.practice.inshort.fragment.TopicFragment
import com.example.practice.inshort.model.Topic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.singleitem.view.*
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.practice.inshort.ui.MainViewPager


class TopicAdapter (val fragment : Fragment, val topicsList: ArrayList<Topic>, val context:Context):RecyclerView.Adapter<TopicAdapter.ViewHolder>() {
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

        val topics = topicsList?.get(position);
        holder.topic_name.setText(topics.image_name)
        Picasso.with(context).load(topics.image).error(R.drawable.sample_7).placeholder(R.drawable.sample_0).into(holder.topic_image)
        holder.topic_image.setOnClickListener {
            var newsfragment = NewsFragment()
            var topicfragement = TopicFragment()
           // lateinit var fragment_manager: FragmentManager


//            val manager: FragmentManager
//            val fragmentManager = manager.beginTransaction()

//            val transaction = fragment.fragmentManager
//            if (transaction != null) {
////                transaction.beginTransaction().remove(topicfragement).commit()
////                transaction.beginTransaction().add(R.id.vPager,newsfragment).commit()
//                transaction.beginTransaction().replace(
//                        R.id.main_search_layout, newsfragment).commit();
//                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                transaction.tran
//            }
//            val fragmentManager = context.getFragmentManager()
//            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
//                    .commit()


//            val intent:Intent = Intent(context, NewsFragment::class.java)

//            intent.putExtra("topic_name", topics.image_name);
            var view_pager_obj = MainViewPager()
            //view_pager_obj.setViewPagerCurrentPage(1)
//            topicfragement.setViewPager(1)
//            CallViewPagerInterface().setViewPagerCurrentPage(1)

//            if(fragment is TopicFragment){
//                fragment.setViewPager(1)
//            }

                var newsadp = NewsAdapter(mContext)
//            view_pager_obj.adapter = newsadp
            //SwipeAdapter(fragment_manager, 1, AppCompatActivity())

        }
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






    }



}
