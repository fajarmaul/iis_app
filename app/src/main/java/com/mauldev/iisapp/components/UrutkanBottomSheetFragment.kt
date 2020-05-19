package com.mauldev.iisapp.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mauldev.iisapp.R
import kotlinx.android.synthetic.main.layout_urutkan_bottomsheet.*
import kotlinx.android.synthetic.main.layout_urutkan_bottomsheet.view.*

class UrutkanBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var listener: OnTypeSelectedListener
    private var type: Int = LATEST

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_urutkan_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        processCheckButton(type)

        view.iv_checkbox_terbaru.setOnClickListener {
            processCheckButton(LATEST)
        }

        view.iv_checkbox_tanggal_terdekat.setOnClickListener {
            processCheckButton(CLOSEST)
        }

        view.iv_checkbox_belum_dibaca.setOnClickListener {
            processCheckButton(UNREAD)
        }

        view.iv_close.setOnClickListener {
            this.dismiss()
        }
    }

    fun setListener(listener: OnTypeSelectedListener){
        this.listener = listener
    }

    private fun processCheckButton(type: Int){
        listener.onTypeSelected(type)

        when (type) {
            LATEST -> {
                iv_checkbox_terbaru.setImageResource(R.drawable.ic_checkbox)
                iv_checkbox_belum_dibaca.setImageResource(R.drawable.ic_checkbox_unchecked)
                iv_checkbox_tanggal_terdekat.setImageResource(R.drawable.ic_checkbox_unchecked)
            }
            CLOSEST -> {
                iv_checkbox_terbaru.setImageResource(R.drawable.ic_checkbox_unchecked)
                iv_checkbox_belum_dibaca.setImageResource(R.drawable.ic_checkbox_unchecked)
                iv_checkbox_tanggal_terdekat.setImageResource(R.drawable.ic_checkbox)
            }
            UNREAD -> {
                iv_checkbox_terbaru.setImageResource(R.drawable.ic_checkbox_unchecked)
                iv_checkbox_belum_dibaca.setImageResource(R.drawable.ic_checkbox)
                iv_checkbox_tanggal_terdekat.setImageResource(R.drawable.ic_checkbox_unchecked)
            }
        }
    }

    interface OnTypeSelectedListener {
        fun onTypeSelected(type: Int)
    }

    companion object {

        const val LATEST = 1
        const val CLOSEST = 2
        const val UNREAD = 3

        fun newInstance(latestType: Int, listener: OnTypeSelectedListener): UrutkanBottomSheetFragment {
            val bottomSheet = UrutkanBottomSheetFragment()
            bottomSheet.setListener(listener)
            bottomSheet.type = latestType
            return bottomSheet
        }

    }
}