package com.example.practice.inshort.fragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

import com.example.practice.inshort.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters

    var mywebview: WebView? = null
    var new_url:String=""
    companion object {

        var news_url:String = ""

        fun newInstance(url: String): BlankFragment {
            news_url = url
            val fragment = BlankFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View

        view = inflater.inflate(R.layout.news_webview, container, false)
        mywebview = view.findViewById<WebView>(R.id.webview)
        val mypref = context?.getSharedPreferences("source_url", MODE_PRIVATE)
        if (mypref != null) {
            new_url = mypref.getString("news_url","")
        }
        load_url()
        return view
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        val mypref = context?.getSharedPreferences("source_url", MODE_PRIVATE)
        if (mypref != null) {
            new_url = mypref.getString("news_url","")
            load_url()
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

    fun load_url(){


        mywebview!!.setWebViewClient(object : WebViewClient() {

            override fun onPageFinished(view: WebView, new_url: String) {
                // And Here.
                view.clearHistory()
                super.onPageFinished(view, new_url)
            }
        })
        mywebview!!.loadUrl("about:blank")
        mywebview!!.loadUrl(new_url)
    }



}
