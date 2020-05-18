package com.mauldev.iisapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mauldev.iisapp.R
import com.mauldev.iisapp.model.Pengumuman

class MainItemAdapter(var pengumumanList: List<Pengumuman>, val listener: OnItemClickListener) : RecyclerView.Adapter<MainItemViewHolder>(){

    override fun getItemCount(): Int {
        return pengumumanList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        return MainItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_card, parent, false))
    }

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.setData(pengumumanList[position], listener)
    }

    interface OnItemClickListener{
        fun onItemClick(item: Pengumuman)
    }

}