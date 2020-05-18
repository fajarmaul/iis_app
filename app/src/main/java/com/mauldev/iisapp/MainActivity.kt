package com.mauldev.iisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mauldev.iisapp.adapter.MainItemAdapter
import com.mauldev.iisapp.model.Pengumuman
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
    }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        toolbar.title = "Pengumuman"

        back_button.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initData(){
        val pengumumanList = mutableListOf<Pengumuman>()



        for (index in 1..4){
            val pengumuman = Pengumuman().apply {
                title = "Gladi Bersih Lomba Tari $index"
                name = "Kevin $index"
                schoolName = "TK Bintang Kecil Jakarta $index"
                date = "2$index Desember"
                time = "09.00 - 10.00"
                isConfirmed = true
                confirmationStatus = "Mungkin hadir"
            }
            pengumumanList.add(pengumuman)
        }

        pengumumanList[0] = pengumumanList[0].apply {
            isConfirmed = false
            confirmationStatus = ""
        }

        val adapter = MainItemAdapter(pengumumanList, object: MainItemAdapter.OnItemClickListener{
            override fun onItemClick(item: Pengumuman) {
                Toast.makeText(this@MainActivity, "${item.title} Clicked", Toast.LENGTH_SHORT).show()
            }
        })

        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = adapter
    }
}
