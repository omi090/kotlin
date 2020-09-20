package com.omi.demograph.home.repository

import com.empoweredtls.constants.APPURL
import com.omi.demograph.home.data.GraphResponse
import retrofit2.Call
import retrofit2.http.GET

interface GraphService {

    @GET(APPURL.GET_GRAPH_DATA)
    fun getGraphDataDetails(): Call<GraphResponse>
}