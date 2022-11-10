package com.bwx.tamansari.ui.spbu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.ActivitySpbuBinding
import com.bwx.tamansari.model.RiwayatSpbuModel

class SpbuActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpbuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpbuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRiwayat()
    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = ""
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRiwayat() {
        val riwayat = mutableListOf<RiwayatSpbuModel>()
        riwayat.add(RiwayatSpbuModel(10000, "10 September 21"))
        riwayat.add(RiwayatSpbuModel(15000, "15 September 21"))
        riwayat.add(RiwayatSpbuModel(50000, "20 September 21"))
        riwayat.add(RiwayatSpbuModel(20000, "29 September 21"))
        riwayat.add(RiwayatSpbuModel(10000, "30 September 21"))

        val adapter = RiwayatSpbuAdapter()
        adapter.updateData(riwayat)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvTransaksi.adapter = adapter
        binding.rvTransaksi.layoutManager = linearLayoutManager
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}