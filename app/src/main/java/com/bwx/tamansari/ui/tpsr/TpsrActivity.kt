package com.bwx.tamansari.ui.tpsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityTpsrBinding
import com.bwx.tamansari.model.RiwayatClaimSampahModel
import com.bwx.tamansari.model.SampahModel

class TpsrActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTpsrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTpsrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupHargaSampah()
        setupRiwayatClaim()
    }

    private fun setupRiwayatClaim() {
        val claim = mutableListOf<RiwayatClaimSampahModel>()
        claim.add(RiwayatClaimSampahModel("#JHKDSA342", "", 10000, "13 September 2021"))
        claim.add(RiwayatClaimSampahModel("#JHKDSA342", "", 10000, "13 September 2021"))
        claim.add(RiwayatClaimSampahModel("#JHKDSA342", "", 10000, "13 September 2021"))
        claim.add(RiwayatClaimSampahModel("#JHKDSA342", "", 10000, "13 September 2021"))
        claim.add(RiwayatClaimSampahModel("#JHKDSA342", "", 10000, "13 September 2021"))

        val adapter = RiwayatClaimSampahAdapter()
        adapter.updateData(claim)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRiwayat.layoutManager = layoutManager
        binding.rvRiwayat.adapter = adapter
    }

    private fun setupHargaSampah() {

        val sampah = mutableListOf<SampahModel>()
        sampah.add(
            SampahModel(
                "Botol Plastik",
                "https://d2qjkwm11akmwu.cloudfront.net/products/images/14022.jpg",
                300
            )
        )
        sampah.add(
            SampahModel(
                "Botol Plastik",
                "https://d2qjkwm11akmwu.cloudfront.net/products/images/14022.jpg",
                300
            )
        )
        sampah.add(
            SampahModel(
                "Botol Plastik",
                "https://d2qjkwm11akmwu.cloudfront.net/products/images/14022.jpg",
                300
            )
        )
        sampah.add(
            SampahModel(
                "Botol Plastik",
                "https://d2qjkwm11akmwu.cloudfront.net/products/images/14022.jpg",
                300
            )
        )

        val adapter = HargaSampahAdapter()
        adapter.updateData(sampah)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.rvHargaSampah.layoutManager = linearLayoutManager
        binding.rvHargaSampah.adapter = adapter

    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.toolbar_tps3r)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}