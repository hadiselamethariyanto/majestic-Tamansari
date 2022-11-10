package com.bwx.tamansari.ui.paket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityPaketBinding
import com.bwx.tamansari.model.PaketWisataModel

class PaketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        setupPaket()

    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.toolbar_paket)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }


    private fun setupPaket() {
        val paket = mutableListOf<PaketWisataModel>()
        paket.add(
            PaketWisataModel(
                "Nikmati Sedikit Waktu Luang",
                250000,
                4.0f,
                "https://tamansariijen.com/wp-content/uploads/2019/10/WhatsApp-Image-2019-09-24-at-21.38.02-1.jpeg"
            )
        )
        paket.add(
            PaketWisataModel(
                "Nikmati Destinasi Wisata Tamansari",
                500000,
                4.0f,
                "https://tamansariijen.com/wp-content/uploads/2020/10/runi.jpg"
            )
        )
        paket.add(
            PaketWisataModel(
                "Budaya dan Edukasi Tamansari",
                750000,
                4.0f,
                "https://tamansariijen.com/wp-content/uploads/2020/11/DSC06920-scaled.jpg"
            )
        )
        val adapter = PaketAdapter()
        adapter.updateData(paket)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvPaket.layoutManager = layoutManager
        binding.rvPaket.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}