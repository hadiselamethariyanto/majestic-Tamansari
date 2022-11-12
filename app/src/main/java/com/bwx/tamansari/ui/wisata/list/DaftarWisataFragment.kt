package com.bwx.tamansari.ui.wisata.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDaftarWisataBinding
import com.bwx.tamansari.model.WisataDomain
import com.bwx.tamansari.ui.base.BaseFragment

class DaftarWisataFragment : BaseFragment<FragmentDaftarWisataBinding>(FragmentDaftarWisataBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWisata()
    }

    private fun setupWisata() {
        val wisata = mutableListOf<WisataDomain>()
        wisata.add(
            WisataDomain(
                "1",
                "Sendang Seruni",
                "https://1.bp.blogspot.com/-ieRLBNtIKmA/XfX8x5zY-7I/AAAAAAAARXY/yanVJaCxyDUUf3p0QeV9bOU4TmhmuNoJwCLcBGAsYHQ/s1600/SendangSeruni_011.JPG",
                4f,
                123,
                -8.1773991,
                114.2418842,
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
                -8.1773991,
                114.2418842,
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
                -8.1773991,
                114.2418842,
                "Taman Gandrung Terakota adalah situs rawat ruwat seni budaya Banyuwangi yang terletak di sebuah kawasan kaki gunung Ijen dan bukit hijau dan hamparan sawah yang didalamnya dapat ditemukan galeri seni rupa, amfiteater terbuka sendratari, pementasan dramatari “Meras Gandrung”, perlehatan musik. Taman Gandrung Terakota berlokasi di Dusun Blimbingsari Desa Tamansari Kecamatan Licin Kabupaten Banyuwangi Provinsi Jawa Timur. Kawasan ini digagas oleh Sigit Pramono."
            )
        )

        val adapter = ListWisataAdapter()
        adapter.updateData(wisata)
        adapter.setOnItemClickCallback(object : ListWisataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: WisataDomain) {
                val bundle = bundleOf("wisata" to data)
                findNavController().navigate(
                    R.id.action_navigation_daftar_wisata_to_navigation_detail_wisata,
                    bundle
                )
            }
        })
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvWisata.layoutManager = layoutManager
        binding.rvWisata.adapter = adapter
    }

}