package com.example.practice.inshort.ui

import android.content.Context
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
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
        var snackbar = Snackbar.make(this, "Had a snack at Snackbar", Snackbar.LENGTH_LONG)
                    snackbar.setActionTextColor(Color.BLACK);
                    var snackbarView = snackbar.getView();
                    var textView = snackbarView.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.like, 0, 0, 0);
//        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.share, 0, 0, 0);
        textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.fab_margin));
                    snackbarView.setBackgroundColor(Color.WHITE);
                    snackbar.show()

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