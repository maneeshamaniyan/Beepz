package com.example.beepz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beepz.data.BZOrder
import com.example.beepz.data.BZResponse
import com.example.beepz.webservice.BZApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

/*Created by Maneesha on 25/01/2022*/
class BZCategoryListActivity : AppCompatActivity(), BZItemClickListener {

    var dataList = ArrayList<BZOrder>()
    lateinit var itemRecyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    private val dataObject: String = "data_object"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_list)
        val leftIcon: ImageView = findViewById(R.id.leftIcon)
        leftIcon.setImageResource(R.drawable.menu)
        itemRecyclerView = findViewById(R.id.recyclerView)
        itemRecyclerView.adapter = BZCategoryListAdapter(dataList, this, this)
        itemRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        getData()

    }

    /*Function to get data from the server*/
    private fun getData() {
        val call: Call<BZResponse> = BZApiClient.getClient.getData()
        call.enqueue(object : Callback<BZResponse> {

            override fun onResponse(
                call: Call<BZResponse>?,
                response: Response<BZResponse>?
            ) {
                progressBar.visibility = View.GONE
                dataList.addAll(response!!.body()!!.data.orderList)
                itemRecyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<BZResponse>?, t: Throwable?) {
                progressBar.visibility = View.GONE
            }
        })
    }

    /*Function that implements RecyclerView item click*/
    override fun onItemClickListener(data: BZOrder) {
        val intent = Intent(this, BZOrderDetailsActivity::class.java)
        intent.putExtra(dataObject, data as Serializable)
        startActivity(intent)
    }


}