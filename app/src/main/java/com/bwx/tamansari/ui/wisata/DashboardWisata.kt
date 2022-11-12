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
import com.bwx.tamansari.model.WisataDomain
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
//                startActivity(Intent(this, DaftarWisataActivity::class.java))
            }
        }
    }

    private fun setupWisataPopuler() {
        val wisata = mutableListOf<WisataDomain>()
        wisata.add(
            WisataDomain(
                "1",
                "Sendang Seruni",
                "https://1.bp.blogspot.com/-ieRLBNtIKmA/XfX8x5zY-7I/AAAAAAAARXY/yanVJaCxyDUUf3p0QeV9bOU4TmhmuNoJwCLcBGAsYHQ/s1600/SendangSeruni_011.JPG",
                4f,
                123,
                100.0,
                0.0,
                "Segar dan jernih itulah dua kesan pertama saat melihat panorama pemandian Sendang Seruni, menurut nenek moyang setempat Sendang Seruni dahulunya adalah sumber mata air yang disebut sumber Seruni karena dikelilingi oleh hutan dan tanaman bunga seruni, di area tersebut terdapat  tujuh sumber mata air jernih menyatu menjadi satu, sumber mata air ini  mengalir dari salah satu pegunungan dan membentuk danau kecil yang digunakan mandi oleh masyarakat sekitar dan menurut cerita dahulu. Pernah dibuat mandi para bidadari, sehingga masyarakat Osing setempat menyebutnya dengan nama “Sendang” disamping itu disekitar sumber mata air terdapat banyak tanaman bunga, maka masyarakat Osing setempat menyebutnya tanaman bunga seruni, kemudian masyarakat Osing  setempat memberi nama “Sendang Seruni” untuk  ikon objek wisata di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin. Masyarakat Osing setempat  meyakini air Sendang Seruni bisa membuat awet muda dan mampu mengurangi penyakit dalam dan rasa capek pada tubuh. Setiap satu tahun di malam satu suro juru kunci Sendang Seruni, Pak Karsono dan masyarakat Osing setempat mengadakan ritual rutin untuk menghormati leluhur yang terdahulu, agar tujuh sumber mata air di Sendang Seruni tetap terjaga kelestariannya juga pengunjung terjaga keselamatannya, khusus kalangan wisatawan perempuan yang sedang berhalangan tidak diperbolehkan melewati tujuh sumber mata air tanpa seijin dari juru kunci karena diyakini sakral oleh masyarakat Osing setempat."
            )
        )
        wisata.add(
            WisataDomain(
                "2",
                "Kawah Ijen",
                "https://phinemo.com/wp-content/uploads/2016/06/kawah-ijen1.jpg",
                4.8f,
                522,
                0.0,
                0.0,
                "Kawah Ijen adalah sebuah danau kawah yang bersifat asam yang berada di puncak Gunung Ijen dengan kedalaman danau 200 meter dan luas kawah mencapai 5.466 Hektar. Danau kawah Ijen dikenal merupakan danau air asam kuat terbesar di dunia[1]. Kawah Ijen berada dalam wilayah Cagar Alam Taman Wisata Ijen Kabupaten Bondowoso dan Kabupaten Banyuwangi, Jawa Timur. Fenomena eternal blue fire atau api biru abadi berada di dalam kawah Ijen, dan pemandangan alami ini hanya terjadi di dua tempat di dunia yaitu Islandia dan Ijen. Blue fire hanya dapat dilihat oleh mata manusia saat tidak ada cahaya, karenanya waktu ideal untuk melihatnya adalah jam 2 hingga jam 4 dinihari, karena pendakian Gunung Ijen baru mulai dibuka jam 2 dinihari. Dari Kawah Ijen, kita dapat melihat pemandangan gunung lain yang ada di kompleks Pegunungan Ijen, di antaranya adalah puncak Gunung Marapi yang berada di timur Kawah Ijen, Gunung Raung, Gunung Suket, dan Gunung Rante."
            )
        )
        wisata.add(
            WisataDomain(
                "3",
                "Taman Gandrung Terakota",
                "https://cdn-image.hipwee.com/wp-content/uploads/2020/03/hipwee-83895811_212508193261440_5504186544504385728_n-750x750.jpg",
                4f,
                56,
                0.0,
                0.0,
                "Taman Gandrung Terakota adalah situs rawat ruwat seni budaya Banyuwangi yang terletak di sebuah kawasan kaki gunung Ijen dan bukit hijau dan hamparan sawah yang didalamnya dapat ditemukan galeri seni rupa, amfiteater terbuka sendratari, pementasan dramatari “Meras Gandrung”, perlehatan musik. Taman Gandrung Terakota berlokasi di Dusun Blimbingsari Desa Tamansari Kecamatan Licin Kabupaten Banyuwangi Provinsi Jawa Timur. Kawasan ini digagas oleh Sigit Pramono."
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