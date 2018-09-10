package com.example.practice.inshort.ui

import android.content.Context

class SharedPreferenceClass(context: Context) {
    val PREFERENCENAME = "INSHORT_URL"
    val SOURCE_URL = "source_url"

    val mypref = context?.getSharedPreferences("source_url", Context.MODE_PRIVATE)
}