package com.bwx.tamansari.ui.wisata.detail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bwx.tamansari.databinding.FragmentGalleryWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy

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

        val galleryWisataAdapter = GalleryWisataAdapter(DataDummy.generateGalleryWisata())
        binding.rvGalleryWisata.adapter = galleryWisataAdapter
        binding.rvGalleryWisata.layoutManager = GridLayoutManager(requireActivity(), 2, GridLayoutManager.VERTICAL, false)
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