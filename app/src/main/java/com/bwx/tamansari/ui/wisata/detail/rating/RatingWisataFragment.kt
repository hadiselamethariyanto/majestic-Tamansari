package com.bwx.tamansari.ui.wisata.detail.rating

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentRatingWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM_WISATA = "wisata"

class RatingWisataFragment :
    BaseFragment<FragmentRatingWisataBinding>(FragmentRatingWisataBinding::inflate) {

    private var wisata: String? = null
    private lateinit var ratingWisataAdapter: RatingWisataAdapter
    private val viewModel: RatingWisataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            wisata = it.getString(ARG_PARAM_WISATA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wisataDomain = Gson().fromJson(wisata, WisataDomain::class.java)

        ratingWisataAdapter = RatingWisataAdapter()
        binding.rvRatingWisata.adapter = ratingWisataAdapter

        viewModel.getWisataRating(wisataDomain.id).observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val ratings = res.data ?: arrayListOf()
                    if (ratings.isNotEmpty()) {
                        ratingWisataAdapter.updateData(ratings)
                        binding.rvRatingWisata.visibility = View.VISIBLE
                        binding.tvMessage.visibility = View.GONE
                    } else {
                        binding.rvRatingWisata.visibility = View.GONE
                        binding.tvMessage.visibility = View.VISIBLE
                        binding.tvMessage.text = getString(R.string.empty_data)
                    }
                }
                is Resource.Error -> {
                    binding.rvRatingWisata.visibility = View.GONE
                    binding.tvMessage.visibility = View.VISIBLE
                    binding.tvMessage.text = res.message
                }
            }
        }

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