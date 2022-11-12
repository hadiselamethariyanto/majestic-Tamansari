package com.bwx.tamansari.ui.wisata.detail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.FragmentDetailWisataBinding
import com.bwx.tamansari.model.WisataDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator


class DetailWisataFragment :
    BaseFragment<FragmentDetailWisataBinding>(FragmentDetailWisataBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wisata = arguments?.getParcelable<WisataDomain>("wisata")

        binding.tvWisataName.text = wisata?.nama
        binding.tvWisataRating.text = "${wisata?.rating} (${wisata?.vote_count})"
        Glide.with(requireActivity()).load(wisata?.foto).centerCrop().into(binding.imageWisata)

        val pagerAdapter = DetailWisataPagerAdapter(requireActivity(),wisata)
        binding.pager.adapter = pagerAdapter
        val tabLayoutTitle = arrayListOf("Overview", "Gallery", "Rating")
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabLayoutTitle[position].split(" ")[0]
        }.attach()
    }

}