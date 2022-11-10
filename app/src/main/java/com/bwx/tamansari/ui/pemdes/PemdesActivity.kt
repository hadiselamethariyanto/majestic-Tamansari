package com.bwx.tamansari.ui.pemdes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityPemdesBinding
import com.bwx.tamansari.model.MenuModel
import com.bwx.tamansari.ui.wisata.MenuWisataAdapter

class PemdesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPemdesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPemdesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupMenu()
    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.toolbar_pemdes)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setupMenu() {
        val list = ArrayList<MenuModel>()
        list.add(MenuModel("E-Surat", R.drawable.ic_email))
        list.add(MenuModel("E-Pajak", R.drawable.ic_tax))
        list.add(MenuModel("Perangkat", R.drawable.ic_perangkat))
        list.add(MenuModel("Pengaduan", R.drawable.ic_pengaduan))
        list.add(MenuModel("Dana Desa", R.drawable.ic_budget))
        list.add(MenuModel("Galeri", R.drawable.ic_gallery))

        val adapter = MenuWisataAdapter(this, list)
        binding.menu.adapter = adapter
        binding.menu.setOnItemClickListener { adapterView, view, i, l -> }
    }


}