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
        val berita = mutableListOf<BeritaModel>()
        berita.add(
            BeritaModel(
                "Tamansari Banyuwangi Masuk 50 Besar Anugerah Desa Wisata Indonesia Tahun 2021 dari Kemenparekraf",
                "Rabu, 25 Agustus 2021 | 13:16 WIB",
                "https://assets.promediateknologi.com/crop/0x0:0x0/x/photo/2021/08/25/1875519396.png"
            )
        )
        berita.add(
            BeritaModel(
                "Desa Tamansari Banyuwangi Menuju Ajang ADWI 2021",
                "28 Agustus 2021",
                "https://grafikanews.com/foto_berita/14WhatsApp%20Image%202021-08-28%20at%2019.35.55.jpeg"
            )
        )
        berita.add(
            BeritaModel(
                "Kawan Ijen dan 14 Lokasi Wisata di Banyuwangi Resmi Dibuka Kembali",
                "Jum'at, 10 September 2021 15:55 WIB",
                "https://img.idxchannel.com/media/700/images/idx/2021/06/10/SBY_Wisata_Kawah_Ijen_Ali_Masduki__14___1_.jpg"
            )
        )

        val adapter = BeritaAdapter()
        adapter.updateData(berita)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvBerita.layoutManager = linearLayoutManager
        binding.rvBerita.adapter = adapter
        binding.rvBerita.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

    }
}