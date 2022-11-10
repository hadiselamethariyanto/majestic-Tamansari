package com.bwx.tamansari.ui.wisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ActivityDashboardWisataBinding
import com.bwx.tamansari.model.BannerPromo
import com.bwx.tamansari.model.MenuModel
import com.bwx.tamansari.model.WisataModel
import com.bwx.tamansari.ui.homestay.HomestayActivity
import com.bwx.tamansari.ui.paket.PaketActivity
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class DashboardWisata : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardWisataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardWisataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupProfile()
        setupBanner()
        setupMenu()
        setupWisataPopuler()
    }

    private fun setupToolbar() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Pariwisata"
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupProfile() {
        Glide.with(this)
            .load("https://www.pngfind.com/pngs/m/610-6104451_image-placeholder-png-user-profile-placeholder-image-png.png")
            .transform(CenterCrop(), RoundedCorners(70))
            .into(binding.imgProfile)
    }

    private fun setupBanner() {
        val banner = mutableListOf<BannerPromo>()
        banner.add(
            BannerPromo(
                "https://cdn-2.tstatic.net/travel/foto/bank/images/traveloka-10.jpg",
                "https://cdn-2.tstatic.net/travel/foto/bank/images/traveloka-10.jpg"
            )
        )
        banner.add(
            BannerPromo(
                "https://cdn-2.tstatic.net/travel/foto/bank/images/traveloka-10.jpg",
                "https://cdn-2.tstatic.net/travel/foto/bank/images/traveloka-10.jpg"
            )
        )
        banner.add(
            BannerPromo(
                "https://cdn-2.tstatic.net/travel/foto/bank/images/traveloka-10.jpg",
                "https://cdn-2.tstatic.net/travel/foto/bank/images/traveloka-10.jpg"
            )
        )

        val adapter = BannerAdapter(banner)
        binding.imageSlider.setSliderAdapter(adapter)
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.imageSlider.autoCycleDirection =
            SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        binding.imageSlider.scrollTimeInSec = 3
        binding.imageSlider.isAutoCycle = true
        binding.imageSlider.startAutoCycle()
    }

    private fun setupMenu() {
        val list = ArrayList<MenuModel>()
        list.add(MenuModel("Homestay", R.drawable.ic_homestay))
        list.add(MenuModel("Paket", R.drawable.ic_luggage))
        list.add(MenuModel("Destinasi", R.drawable.ic_destination))

        val adapter = MenuWisataAdapter(this, list)
        binding.menu.adapter = adapter
        binding.menu.setOnItemClickListener { _, _, i, _ ->
            if (i == 0) {
                startActivity(Intent(this, HomestayActivity::class.java))
            } else if (i == 1) {
                startActivity(Intent(this, PaketActivity::class.java))
            } else if (i == 2) {
                startActivity(Intent(this, DaftarWisataActivity::class.java))
            }
        }
    }

    private fun setupWisataPopuler() {
        val wisata = mutableListOf<WisataModel>()
        wisata.add(
            WisataModel(
                "Sendang Seruni",
                "https://1.bp.blogspot.com/-ieRLBNtIKmA/XfX8x5zY-7I/AAAAAAAARXY/yanVJaCxyDUUf3p0QeV9bOU4TmhmuNoJwCLcBGAsYHQ/s1600/SendangSeruni_011.JPG",
                4f,
                123
            )
        )
        wisata.add(
            WisataModel(
                "Kawah Ijen",
                "https://phinemo.com/wp-content/uploads/2016/06/kawah-ijen1.jpg",
                4.8f,
                522
            )
        )
        wisata.add(
            WisataModel(
                "Taman Gandrung Terakota",
                "https://cdn-image.hipwee.com/wp-content/uploads/2020/03/hipwee-83895811_212508193261440_5504186544504385728_n-750x750.jpg",
                4f,
                56
            )
        )

        val adapter = WisataPopulerAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.rvWisata.adapter = adapter
        binding.rvWisata.layoutManager = layoutManager

        adapter.updateData(wisata)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}