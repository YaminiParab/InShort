package com.example.practice.inshort.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.example.practice.inshort.R
import com.example.practice.inshort.adapter.NewsAdapter
import com.example.practice.inshort.modal.News
import kotlinx.android.synthetic.main.activity_news.*

import java.util.*
//import com.example.practice.inshort.modal.JSONResponse
import android.R.attr.data
//import jdk.nashorn.internal.objects.Global.getJSON
import com.example.practice.inshort.modal.RequestInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import android.R.attr.data
import android.util.Log
//import jdk.nashorn.internal.objects.Global.getJSON
import com.example.practice.inshort.modal.JSONResponse
import android.R.attr.data






class NewsActivity : Activity() {
    val newsList: ArrayList<News> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_news)
        initViews();

         //on click of search icon redirect to search detail activity
         val topstories = findViewById<View>(R.id.topStoriesView)
         topstories.setOnClickListener {

             val newsActivityIntent = Intent(this,SearchByCategory::class.java);
             startActivity(newsActivityIntent)

         }

         // Recycler view for news detail page
//        news_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

//        newsList.add(News(R.drawable.angry_bird, "Angry Birds' maker Rovio pummeled after profit warning", "63195540\n" +
//                "Tim Whitby | Getty Images\n" +
//                "Angry Birds game maker Rovio Entertainment warned on profits on Thursday, wiping more than a third off the Finnish firm's stock price amid deepening doubts about its valuation.\n" +
//                "\n" +
//                "Investors in the company behind the Angry Birds games and movie franchise have had a rocky ride since last year's initial public offering of Rovio, which blamed increased marketing costs and other investments for the lower profit outlook.\n" +
//                "\n", "22/05/2018"))
//        newsList.add(News(R.drawable.business, "Xiaomi's Mi Credit offers instant loans up to Rs 1 lakh to MIUI users in India", "WE RECOMMEND\n" +
//                "OnePlus 6 gets new software update; allows to hide the notch, record slow-mo videos How a 100% tax on petrol is burning a hole in your pocket\n" +
//                "MORE FROM THE AUTHOR\n" +
//                "Podcast: Sterlite Copper CEO P Ramnath speaks to Business Today Reliance Jio gets the better of Airtel, adds 94 lakh new users in March\n" +
//                "Expanding its portfolio of value-added internet services, Xiaomi has launched its own instant lending platform Mi Credit in India. The platform lists financial loan providers that MIUI users can access to apply for quick loans.\n" +
//                "MIUI users can avail personal loans from Rs 1,000 to Rs 1 lakh from the only loan provider listed on Mi Credit, Kreditbee. Xiaomi claims that loans can be initiated in 10 minutes through Mi Credit with simple KYC verification. All loan verification and user information input is done on the partner platforms, while Mi Credit only lists loan providers.", "22/05/2018"))
//
//        newsList.add(News(R.drawable.india, "PM Modi apologises for lack of drinking water in Santiniketan", "Modi is the Chancellor of the university.\n" +
//                "\"As the Chancellor of Visva Bharati University, I seek your apology. While I was coming here, some students through gestures told me about lack of arrangement for drinking water.\"\n" +
//                "\"I seek your apology for the all the inconvenience caused,\" said Modi amid loud cheers.\n" +
//                "Earlier in the day, the university, built by Nobel laureate Rabindranath Tagore in Bolpur sub-division of West Bengal's Birbhum district, witnessed unruly scenes over lack of drinking water.\n" +
//                "As per reports, some students also fell sick due to inadequate water supply.\n" +
//                "Modi's Bangladesh counterpart Sheikh Hasina, West Bengal Governor KN Tripathi and Chief Minister Mamata Banerjee were present on the occasion.\n","25/05/2018"))
//        newsList.add(News(R.drawable.karnataka_polls,"I am the CM, dad won’t do any back-seat driving: HD Kumaraswamy \n" +
//                "\n" +
//                "", "Haradanahalli Deve Gowda Kumaraswamy, 58, was a busy man on Wednesday, dealing with the 20-plus national leaders who had come for his inauguration. He took time out to speak to TOI’s Rakesh Prakash on the challenges ahead. Excerpts from his first, exclusive interview as CM:\n" +
//                "\n" +
//                "Your oath-taking ceremony was successfully marketed as the beginning of a new chapter in national politics… \n" +
//                "It is special as over 20 national leaders, including chief ministers and minis .. \n" +
//                "\n" +
//                "Read more at:\n" +
//                "//economictimes.indiatimes.com/articleshow/64299533.cms?utm_source=contentofinterest&utm_medium=text&utm_campaign=cppst","25/05/2018"))
        val adapter = NewsAdapter(newsList, this);
        news_detail.adapter = adapter







    }

    private fun initViews() {
        news_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        loadJSON()

    }

    private fun loadJSON() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                //                .baseUrl("https://earthquake.usgs.gov/fdsnws/event/1/query?")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val request = retrofit.create(RequestInterface::class.java)
        val call = request.getJSON()
        call.enqueue(object : Callback<JSONResponse> {
            override fun onResponse(call: Call<JSONResponse>, response: Response<JSONResponse>) {

                val jsonResponse = response.body()
//                data = ArrayList(Arrays.asList(jsonResponse.getAndroid())).toInt()
//                val adapter = NewsAdapter(data, this);
//                news_detail.adapter = adapter

//                data = ArrayList(Arrays.asList(jsonResponse.getAndroid())).toInt()

            }

            override fun onFailure(call: Call<JSONResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })
    }
}

