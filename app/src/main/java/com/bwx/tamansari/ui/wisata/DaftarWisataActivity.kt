package com.bwx.tamansari.ui.wisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityDaftarWisataBinding
import com.bwx.tamansari.model.WisataModel

class DaftarWisataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarWisataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarWisataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupWisata()
    }

    private fun setupWisata() {
        val wisata = mutableListOf<WisataModel>()
        wisata.add(
            WisataModel(
                "Sendang Seruni",
                "https://1.bp.blogspot.com/-ieRLBNtIKmA/XfX8x5zY-7I/AAAAAAAARXY/yanVJaCxyDUUf3p0QeV9bOU4TmhmuNoJwCLcBGAsYHQ/s1600/SendangSeruni_011.JPG",
                4f,
                123
            )
        )
        wisata.add(
            WisataModel(
                "Kawah Ijen",
                "https://phinemo.com/wp-content/uploads/2016/06/kawah-ijen1.jpg",
                4.8f,
                522
            )
        )
        wisata.add(
            WisataModel(
                "Taman Gandrung Terakota",
                "https://cdn-image.hipwee.com/wp-content/uploads/2020/03/hipwee-83895811_212508193261440_5504186544504385728_n-750x750.jpg",
                4f,
                56
            )
        )

        val adapter = ListWisataAdapter()
        adapter.updateData(wisata)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvWisata.layoutManager = layoutManager
        binding.rvWisata.adapter = adapter
    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.toolbar_paket)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}