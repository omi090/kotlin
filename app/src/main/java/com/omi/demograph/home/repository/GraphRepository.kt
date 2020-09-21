package com.omi.demograph.home.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.omi.demograph.home.data.GraphResponse
import com.omi.demograph.home.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GraphRepository {

    private var graphService: GraphService =
        RetrofitInstance.getInstance().create(GraphService::class.java)

    private val graphDetailsMutableLiveData: MutableLiveData<GraphResponse> = MutableLiveData()

    fun getGraphDetailsLiveData(): LiveData<GraphResponse> {
        return graphDetailsMutableLiveData
    }

    fun getGraphData() {
        val graphDetailsCall = graphService.getGraphDataDetails()
        graphDetailsCall.enqueue(object : Callback<GraphResponse> {
            override fun onFailure(call: Call<GraphResponse>, t: Throwable) {
                Log.i("TAG", "OnFailure")

            }

            override fun onResponse(call: Call<GraphResponse>, response: Response<GraphResponse>) {
                if (response.body() != null) {
                    graphDetailsMutableLiveData.value = response.body()
                } else {
                    Log.i("TAG", "--> ")
                }
            }
        });
    }

}