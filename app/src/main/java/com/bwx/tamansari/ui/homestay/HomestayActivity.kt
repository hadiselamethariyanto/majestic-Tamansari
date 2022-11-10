package com.bwx.tamansari.ui.homestay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityHomestayBinding
import com.bwx.tamansari.model.HomestayModel

class HomestayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomestayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomestayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        setupHomestay()
    }

    private fun setupHomestay() {
        val homestay = mutableListOf<HomestayModel>()
        homestay.add(
            HomestayModel(
                "Jambu Merah Homestay",
                1.4,
                150000,
                4.3f,
                "https://tamansariijen.com/wp-content/uploads/2021/02/Jambu-Merah-Homestay.jpg"
            )
        )
        homestay.add(
            HomestayModel(
                "Kastini Homestay",
                1.4,
                150000,
                4.3f,
                "https://tamansariijen.com/wp-content/uploads/2021/02/kastini-homestay-1.jpg"
            )
        )
        homestay.add(
            HomestayModel(
                "Tolak Homestay",
                1.4,
                150000,
                4.3f,
                "https://tamansariijen.com/wp-content/uploads/2021/02/Tolak-Homestay.jpg"
            )
        )
        val adapter = HomestayAdapter()
        adapter.updateData(homestay)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvHomestay.adapter = adapter
        binding.rvHomestay.layoutManager = layoutManager
    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.toolbar_homestay)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}