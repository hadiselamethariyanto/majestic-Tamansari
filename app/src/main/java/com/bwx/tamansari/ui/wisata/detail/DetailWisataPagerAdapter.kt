package com.bwx.tamansari.ui.wisata.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bwx.tamansari.ui.wisata.detail.gallery.GalleryWisataFragment
import com.bwx.tamansari.ui.wisata.detail.overview.OverviewWisataFragment
import com.bwx.tamansari.ui.wisata.detail.rating.RatingWisataFragment
import com.google.gson.Gson

class DetailWisataPagerAdapter(activity: FragmentActivity, val wisata: WisataDomain?) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        val wisataJson = Gson().toJson(wisata)

        when (position) {
            0 -> fragment = OverviewWisataFragment.newInstance(wisataJson)
            1 -> fragment = GalleryWisataFragment.newInstance(wisataJson)
            2 -> fragment = RatingWisataFragment.newInstance(wisataJson)
        }
        return fragment as Fragment
    }

}