package com.omi.demograph.home.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omi.demograph.R
import com.omi.demograph.databinding.ActivityMainBinding
import com.omi.demograph.home.GraphDetailsListener
import com.omi.demograph.home.adapter.GraphDetailsAdapter
import com.omi.demograph.home.data.App
import com.omi.demograph.home.viewModel.GraphViewModel

class LauncherActivity : AppCompatActivity(), GraphDetailsListener {

    private var storeList = mutableListOf<App>()
    private lateinit var graphViewModel: GraphViewModel
    private lateinit var graphDetailsAdapter: GraphDetailsAdapter
    private lateinit var bindingImpl: ActivityMainBinding
    private lateinit var storeListRecyclerView: RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingImpl = DataBindingUtil.setContentView(this, R.layout.activity_main)

        graphViewModel =
            ViewModelProvider(this).get(GraphViewModel::class.java)

        initView()
        initAdapter()
        initLayoutManager()
        initStoreList()
        registerObserver()
        getGraphDetails()
    }

    private fun initView() {
        bindingImpl.isDataAvailable = false
        storeListRecyclerView = bindingImpl.storesRecyclerView
    }

    private fun initAdapter() {
        graphDetailsAdapter = GraphDetailsAdapter(storeList, this, this)
    }

    private fun initLayoutManager() {
        mLayoutManager = LinearLayoutManager(this)
    }

    private fun initStoreList() {
        storeListRecyclerView.layoutManager = mLayoutManager
        storeListRecyclerView.adapter = graphDetailsAdapter
    }

    private fun registerObserver() {
        graphViewModel.getGraphLiveData().observe(this) {
            if (it != null) {
                storeList.addAll(it.apps as MutableList<App>)
                graphDetailsAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun getGraphDetails() {
        graphViewModel.getGraphDetails()
    }

    override fun onStoreNameClickListener(graphDetails: App) {
        val intent = Intent(this, ChartActivity::class.java)
        intent.putExtra("GRAPH_DETAILS", graphDetails)
        startActivity(intent)
    }


}

