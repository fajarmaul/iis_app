package com.mauldev.iisapp.adapter

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mauldev.iisapp.R
import com.mauldev.iisapp.model.Pengumuman
import kotlinx.android.synthetic.main.layout_item_card.view.*

class MainItemViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val context = view.context
    private var title = view.item_title
    private var name = view.item_name
    private var schoolName = view.item_school_name
    private var date = view.item_date
    private var time = view.item_clock
    private var bottomAction = view.item_bottom_action
    private var bottomActionLayout = view.v_bottom_action

    fun setData(item: Pengumuman, listener: MainItemAdapter.OnItemClickListener){
        title.text = item.title
        name.text = item.name
        schoolName.text = item.schoolName
        date.text = item.date
        time.text = item.time

        bottomAction.setOnClickListener {
            listener.onItemClick(item)
        }

        initView(item)
    }

    private fun initView(item: Pengumuman){

        if (item.isConfirmed){
            bottomActionLayout.background = context.getDrawable(R.color.white)
            bottomAction.setTextColor(ContextCompat.getColor(context, R.color.orange))
            bottomAction.text = item.confirmationStatus
        } else {
            bottomActionLayout.background = context.getDrawable(R.color.colorAccent)
            bottomAction.text = context.getString(R.string.konfirmasi_kedatangan)
        }

    }



}