package com.bwx.tamansari.ui.wisata.detail

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentRatingWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy

private const val ARG_PARAM_WISATA = "wisata"

class RatingWisataFragment :
    BaseFragment<FragmentRatingWisataBinding>(FragmentRatingWisataBinding::inflate) {

    private var wisata: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            wisata = it.getString(ARG_PARAM_WISATA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ratingWisataAdapter = RatingWisataAdapter(DataDummy.generateRatingWisata())
        binding.rvRatingWisata.adapter = ratingWisataAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            RatingWisataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_WISATA, param1)
                }
            }
    }
}