package com.bwx.tamansari.ui.wisata.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemRatingWisataBinding
import com.bwx.tamansari.model.RatingWisataDomain

class RatingWisataAdapter(private val list: List<RatingWisataDomain>) :
    RecyclerView.Adapter<RatingWisataAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRatingWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rating: RatingWisataDomain) {
            binding.tvUserName.text = rating.username
            binding.tvDate.text = rating.createdDate
            binding.tvReview.text = rating.review

            val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(70))
            Glide.with(itemView.context).load(rating.photoUrl).placeholder(R.drawable.placeholder).apply(requestOptions)
                .into(binding.imageUser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRatingWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}