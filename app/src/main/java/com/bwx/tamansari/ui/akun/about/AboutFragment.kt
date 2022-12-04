package com.bwx.tamansari.ui.akun.about

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentAboutBinding
import com.bwx.tamansari.ui.base.BaseBottomSheetDialog


class AboutFragment : BaseBottomSheetDialog<FragmentAboutBinding>(FragmentAboutBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgClose.setOnClickListener {
            dismiss()
        }
        binding.tvAbout.text =
            "Tamansari App adalah aplikasi yang memudahkan wisatawan yang berkunjung ke Banyuwangi khususnya Desa Tamansari untuk menemukan dan memesan beragam produk perjalanan, local services, dan layanan sampah. \n\nDengan adanya Tamansari App, wisatawan bisa mendapatkan harga yang lebih murah karena membeli langsung kepada pengelola dan tanpa perantara siapapun karena aplikasi ini dikelola langsung oleh Bumdes Ijen Lestari dibawah naungan Desa Wisata Tamansari.\n\nPihak Bumdes sangat berterimakasih kepada Bank BCA karena melalui program Bakti BCA, akselerasi digitalisasi di Desa Tamansari bisa sangat cepat dan terarah."
    }

}