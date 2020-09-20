package com.omi.demograph.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.omi.demograph.R
import com.omi.demograph.databinding.ListItemStoreBinding
import com.omi.demograph.home.data.App

class GraphDetailsAdapter(
    private val graphStoreList: List<App>,
    private val context: Context
) : RecyclerView.Adapter<GraphDetailsAdapter.GraphStoreListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphStoreListViewHolder {
        val storeBinding: ListItemStoreBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_store,
                parent,
                false
            )
        return GraphStoreListViewHolder(storeBinding)
    }

    override fun getItemCount(): Int = graphStoreList.size

    override fun onBindViewHolder(holder: GraphStoreListViewHolder, position: Int) {
        val storeList: App = graphStoreList.get(position)
        holder.storeBinding.graphDetails = storeList
        holder.storeBinding.executePendingBindings()
    }




    class GraphStoreListViewHolder(val storeBinding: ListItemStoreBinding) :
        RecyclerView.ViewHolder(storeBinding.root)
}