package com.bwx.tamansari.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentHomeBinding
import com.bwx.tamansari.model.MenuModel
import com.bwx.tamansari.model.PromoModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupProfile()
        setupMenu()
        setupPromo()
    }

    private fun setupMenu() {
        val list = ArrayList<MenuModel>()
        list.add(MenuModel("Wisata", R.drawable.ic_wisata))
        list.add(MenuModel("Homestay", R.drawable.ic_homestay))
        list.add(MenuModel("Paket", R.drawable.ic_luggage))
        list.add(MenuModel("Restoran", R.drawable.ic_restaurant))
        list.add(MenuModel("Peta", R.drawable.ic_map))
        list.add(MenuModel("Berita", R.drawable.ic_berita))
        list.add(MenuModel("TPS3R", R.drawable.ic_tps3r))

        val gridLayoutManager = GridLayoutManager(activity, 5, GridLayoutManager.VERTICAL, false)
        val adapter = MenuGridAdapter(list, requireActivity())
        adapter.setOnItemClickCallback(object : MenuGridAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MenuModel, position: Int) {
                when (position) {
                    0 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_daftarWisataFragment)
                    }
                    1 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_homestay)
                    }
                    2 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_travel_package)
                    }
                    3 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_restaurant)
                    }
                    4 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_peta)
                    }
                    5 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_news)
                    }
                }
            }
        })

        binding.menu.layoutManager = gridLayoutManager
        binding.menu.adapter = adapter
    }

    private fun setupPromo() {
        val list = ArrayList<PromoModel>()
        list.add(
            PromoModel(
                "https://www.linkaja.id/uploads/images/promo//YW50aWtvZGVfXzE2MzAzOTU0ODRfd2ViLWJhbm5lci0yMDIxLTA4LTMxdDE0MzcxNy0xMTAtanBn.jpg",
                "https://www.linkaja.id/uploads/images/promo//YW50aWtvZGVfXzE2MzAzOTU0ODRfd2ViLWJhbm5lci0yMDIxLTA4LTMxdDE0MzcxNy0xMTAtanBn.jpg"
            )
        )
        list.add(
            PromoModel(
                "https://www.linkaja.id/uploads/images/promo//YW50aWtvZGVfXzE2MzAzOTU0ODRfd2ViLWJhbm5lci0yMDIxLTA4LTMxdDE0MzcxNy0xMTAtanBn.jpg",
                "https://www.linkaja.id/uploads/images/promo//YW50aWtvZGVfXzE2MzAzOTU0ODRfd2ViLWJhbm5lci0yMDIxLTA4LTMxdDE0MzcxNy0xMTAtanBn.jpg"
            )
        )
        list.add(
            PromoModel(
                "https://www.linkaja.id/uploads/images/promo//YW50aWtvZGVfXzE2MzAzOTU0ODRfd2ViLWJhbm5lci0yMDIxLTA4LTMxdDE0MzcxNy0xMTAtanBn.jpg",
                "https://www.linkaja.id/uploads/images/promo//YW50aWtvZGVfXzE2MzAzOTU0ODRfd2ViLWJhbm5lci0yMDIxLTA4LTMxdDE0MzcxNy0xMTAtanBn.jpg"
            )
        )

        val adapter = PromoAdapter()
        val linearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter.updateData(list)

        binding.promo.layoutManager = linearLayoutManager
        binding.promo.adapter = adapter

    }

    private fun setupProfile() {
        Glide.with(this)
            .load("https://www.pngfind.com/pngs/m/610-6104451_image-placeholder-png-user-profile-placeholder-image-png.png")
            .transform(CenterCrop(), RoundedCorners(50))
            .into(binding.imgProfile)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}