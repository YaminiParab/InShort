package com.example.practice.inshort.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.inshort.R
import com.example.practice.inshort.model.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.search.view.*

class CategoryAdapter(val categoryList: ArrayList<Category>, val context: Context): RecyclerView.Adapter<CategoryAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return CategoryAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.search, parent, false))
    }

    override fun getItemCount(): Int {
        return categoryList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList?.get(position);
        holder.name.setText(category.title)
//        holder.news_image.setImageResource(category.image)
        Picasso.with(context).load(category.image).error(R.drawable.sample_7).placeholder(R.drawable.sample_0).into(holder.news_image)
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val name = view.category_text;
        val news_image = view.category_image


    }

}
