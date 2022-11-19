package com.bwx.tamansari.ui.wisata.detail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bwx.tamansari.databinding.FragmentGalleryWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.gson.Gson

private const val ARG_PARAM_WISATA = "wisata"

class GalleryWisataFragment :
    BaseFragment<FragmentGalleryWisataBinding>(FragmentGalleryWisataBinding::inflate) {
    private var wisata: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            wisata = it.getString(ARG_PARAM_WISATA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wisataDomain = Gson().fromJson(wisata, WisataDomain::class.java)
        val galleryWisataAdapter = GalleryWisataAdapter(wisataDomain.photos)
        binding.rvGalleryWisata.adapter = galleryWisataAdapter
        binding.rvGalleryWisata.layoutManager =
            GridLayoutManager(requireActivity(), 2, GridLayoutManager.VERTICAL, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            GalleryWisataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_WISATA, param1)
                }
            }
    }
}