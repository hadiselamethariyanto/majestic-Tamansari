package com.bwx.tamansari.ui.bumdes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityBumdesBinding
import com.bwx.tamansari.model.MenuListModel

class BumdesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBumdesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBumdesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupMenu()
    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.toolbar_bumdes)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupMenu() {
        val menu = mutableListOf<MenuListModel>()
        menu.add(
            MenuListModel(
                "Informasi Pendirian",
                "sejarah berdirinya bumdes ijen lestari",
                R.drawable.ic_information
            )
        )

        menu.add(
            MenuListModel(
                "Unit Bisnis", "Daftar bisnis yang dikelola oleh bumdes ijen lestari",
                R.drawable.ic_lamp
            )
        )

        menu.add(
            MenuListModel(
                "Manajemen",
                "Pengurus bumdes ijen lestari",
                R.drawable.ic_management
            )
        )

        val adapter = MenuBumdesAdapter()
        adapter.updateData(menu)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMenu.layoutManager = linearLayoutManager
        binding.rvMenu.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}