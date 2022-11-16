package com.bwx.tamansari.ui.wisata.detail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailWisataBinding
import com.bwx.tamansari.model.WisataDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy
import com.bwx.tamansari.utils.Utils
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

        val tickets = DataDummy.generateTicketWisata()
        if (tickets.isNotEmpty()){
            binding.rlChooseTicket.visibility = View.VISIBLE
            binding.tvPriceStartFrom.text = "IDR ${Utils.thousandSeparator(tickets[0].price)}"
        }else{
            binding.rlChooseTicket.visibility = View.GONE
        }

        binding.btnChooseTicket.setOnClickListener {
            val bundle = bundleOf("tickets" to tickets)
            findNavController().navigate(R.id.action_navigation_detail_wisata_to_navigation_choose_ticket_wisata, bundle)
        }
    }

}