package com.bwx.tamansari.ui.berita.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailBeritaBinding
import com.bwx.tamansari.model.BeritaModel
import com.bwx.tamansari.ui.base.BaseFragment


class DetailBeritaFragment :
    BaseFragment<FragmentDetailBeritaBinding>(FragmentDetailBeritaBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news = arguments?.getParcelable<BeritaModel>("berita")

        binding.tvNewsTitle.text = news?.judul
        binding.tvTotalLikes.text = news?.totalLikes.toString()
        binding.tvTotalComments.text = news?.totalComments.toString()
        binding.tvNews.text = news?.description
        binding.tvNewsDate.text = news?.tanggal
        binding.tvNewsCategory.text = news?.category

        Glide.with(requireActivity()).load(news?.foto).placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder).into(binding.imgNews)
    }

}