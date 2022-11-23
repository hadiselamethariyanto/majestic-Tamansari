package com.bwx.tamansari.ui.berita.detail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailBeritaBinding
import banyuwangi.digital.core.domain.model.NewsDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils


class DetailBeritaFragment :
    BaseFragment<FragmentDetailBeritaBinding>(FragmentDetailBeritaBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news = arguments?.getParcelable<NewsDomain>("berita")

        binding.tvNewsTitle.text = news?.title
        binding.tvTotalLikes.text = news?.totalLikes.toString()
        binding.tvTotalComments.text = news?.totalComments.toString()
        binding.tvNews.text = news?.content
        binding.tvNewsDate.text = Utils.formatCalendarToStringDate(news?.createdDate ?: 0)
        binding.tvNewsCategory.text = news?.category

        Glide.with(requireActivity()).load(news?.photo).placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder).into(binding.imgNews)
    }

}