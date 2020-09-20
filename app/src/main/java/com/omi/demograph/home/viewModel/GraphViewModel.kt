package com.omi.demograph.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.omi.demograph.home.data.GraphResponse
import com.omi.demograph.home.repository.GraphRepository

class GraphViewModel : ViewModel() {

    private var graphDetailaRepository: GraphRepository = GraphRepository()
    private lateinit var graphDetailsLiveData: LiveData<GraphResponse>

    fun getGraphLiveData(): LiveData<GraphResponse> {
        graphDetailsLiveData = graphDetailaRepository.getGraphDetailsLiveData()
        return graphDetailsLiveData
    }

    fun getGraphDetails() {
        graphDetailaRepository.getGraphData()
    }
}