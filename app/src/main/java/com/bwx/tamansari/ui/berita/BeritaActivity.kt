package com.bwx.tamansari.ui.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.ActivityBeritaBinding
import com.bwx.tamansari.model.BeritaModel

class BeritaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBeritaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeritaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBerita()
    }

    private fun setupBerita() {


    }
}