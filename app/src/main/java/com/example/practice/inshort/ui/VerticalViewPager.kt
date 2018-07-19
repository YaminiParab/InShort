package com.example.practice.inshort.ui

import android.content.Context
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.VISIBLE
import android.widget.LinearLayout
import android.widget.TextView
import com.example.practice.inshort.R

class VerticalViewPager : ViewPager {

    constructor(context: Context) : super(context) {
        init()
    }

    fun init() {
        setPageTransformer(true, VerticalViewPagerTransform())
        overScrollMode = View.OVER_SCROLL_NEVER
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }
    companion object {

        private val Min_Scale = 0.65f
    }

    private fun swapXY(event: MotionEvent): MotionEvent {
        val x = width.toFloat()
        val y = height.toFloat()

        val newX = event.y / y * y
        val newY = event.x / x * x

        event.setLocation(newX, newY)
        return event
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val intercept = super.onInterceptTouchEvent(swapXY(ev))
        swapXY(ev)
        return intercept
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
//        var user_activity :LinearLayout
//         user_activity = findViewById<LinearLayout>(R.id.user_activity_layout)
//        if (user_activity.getVisibility() == View.VISIBLE)
//        {
//            user_activity.setVisibility(View.INVISIBLE);
//        }
//        else
//        {
//            user_activity.setVisibility(View.VISIBLE);
//        }

        return super.onTouchEvent(swapXY(ev))
    }


    private inner class VerticalViewPagerTransform : ViewPager.PageTransformer {
        override fun transformPage(page: View, position: Float) {

            if (position < -1) {
                page.alpha = 0f
            } else if (position <= 0) {
                page.alpha = 1f
                page.translationX = page.width * -position
                page.translationY = page.height * position
                page.scaleX = 1f
                page.scaleY = 1f
            } else if (position <= 1) {
                page.alpha = 1 - position
                page.translationX = page.width * -position
                page.translationY = 0f
                val scaleFactor = Min_Scale + (1 - Min_Scale) * (1 - Math.abs(position))
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else if (position > 1) {
                page.alpha = 0f
            }
        }
    }
}