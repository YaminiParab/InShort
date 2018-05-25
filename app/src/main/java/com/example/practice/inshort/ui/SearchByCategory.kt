package com.example.practice.inshort.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.practice.inshort.R
import android.support.v7.widget.SearchView;
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem


class SearchByCategory  : AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_by_category)
        setSupportActionBar(findViewById(R.id.my_toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menus, menu)
        menu?.findItem(R.id.action_search);


        return true;
    }
}