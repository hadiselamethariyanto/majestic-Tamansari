package com.bwx.tamansari.utils

import banyuwangi.digital.core.domain.model.*
import com.bwx.tamansari.model.*

object DataDummy {

    fun generateGalleryWisata(): List<GalleryWisataDomain> {
        val listGallery = arrayListOf<GalleryWisataDomain>()
        listGallery.add(
            GalleryWisataDomain(
                "1",
                "https://tamansariijen.com/wp-content/uploads/2021/02/wisata-alam-1-570x320.jpg"
            )
        )
        listGallery.add(
            GalleryWisataDomain(
                "2",
                "https://tamansariijen.com/wp-content/uploads/2020/09/WhatsApp-Image-2020-09-27-at-11.04.19.jpeg"
            )
        )
        listGallery.add(
            GalleryWisataDomain(
                "3",
                "https://tamansariijen.com/wp-content/uploads/2020/09/WhatsApp-Image-2020-09-27-at-11.24.06.jpeg"
            )
        )
        listGallery.add(
            GalleryWisataDomain(
                "4",
                "https://tamansariijen.com/wp-content/uploads/2020/10/WhatsApp-Image-2020-09-27-at-11.40.53.jpeg"
            )
        )
        listGallery.add(
            GalleryWisataDomain(
                "5",
                "https://tamansariijen.com/wp-content/uploads/2021/02/7pancuran-570x320.jpg"
            )
        )
        listGallery.add(
            GalleryWisataDomain(
                "6",
                "https://tamansariijen.com/wp-content/uploads/2021/09/2021-01-15.jpg"
            )
        )
        return listGallery
    }






//    fun generateRestaurant(): List<RestaurantDomain> {
//        val list = ArrayList<RestaurantDomain>()
//        list.add(
//            RestaurantDomain(
//                "1",
//                "Warung Oseng",
//                "Traditional Food, Ayam & Bebek",
//                0.0,
//                0.0,
//                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
//                4f,
//                1.4,
//                12
//            )
//        )
//        list.add(
//            RestaurantDomain(
//                "2",
//                "Warung Oseng 2",
//                "Traditional Food, Bakmie, Aneka Nasi",
//                0.0,
//                0.0,
//                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
//                4f,
//                1.8,
//                21
//            )
//        )
//        list.add(
//            RestaurantDomain(
//                "3",
//                "Sarine Kopi",
//                "Aneka kopi, Minuman",
//                0.0,
//                0.0,
//                "https://tamansariijen.com/wp-content/uploads/2021/10/v60-sarine-kopi.jpg",
//                4f,
//                2.0,
//                30
//            )
//        )
//        return list
//    }

    fun generateMenuRestaurant(): List<MenuRestaurantDomain> {
        val menus = arrayListOf<MenuRestaurantDomain>()
        menus.add(
            MenuRestaurantDomain(
                "1",
                "https://awsimages.detik.net.id/community/media/visual/2019/11/22/da949754-170b-48ad-938e-ed72baf2f9f7.jpeg?w=700&q=90",
                "Sego Tempong",
                10000
            )
        )
        menus.add(
            MenuRestaurantDomain(
                "2",
                "https://cdn.idntimes.com/content-images/community/2019/04/img-6609-687ef1e7ba0d94ed1a489586a8d49b63_600x400.JPG",
                "Sego Cawuk",
                10000
            )
        )
        menus.add(
            MenuRestaurantDomain(
                "3",
                "https://awsimages.detik.net.id/community/media/visual/2021/04/10/mantap-sarapan-pecel-rawon-khas-banyuwangi-berlauk-lengkap-4.jpeg?w=700&q=90",
                "Pecel Rawon",
                10000
            )
        )
        menus.add(
            MenuRestaurantDomain(
                "4",
                "https://cdn0-production-images-kly.akamaized.net/V6IjXyx8-AEv80wQCPqRsWvxcPs=/1200x1200/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1564272/original/034634100_1491974161-Pecel_Petek__2_.jpg",
                "Pecel Pitik",
                100000
            )
        )
        menus.add(
            MenuRestaurantDomain(
                "5",
                "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2021/8/18/a5a38710-2e53-4dec-8302-00de95085135.jpg",
                "Es Teh",
                4000
            )
        )
        return menus
    }


    fun generateWisata(): List<WisataDomain> {
        val wisata = arrayListOf<WisataDomain>()
        wisata.add(
            WisataDomain(
                "1",
                "Sendang Seruni",
                arrayListOf(),
                4f,
                123,
                -8.1773991,
                114.2418842,
                "Segar dan jernih itulah dua kesan pertama saat melihat panorama pemandian Sendang Seruni, menurut nenek moyang setempat Sendang Seruni dahulunya adalah sumber mata air yang disebut sumber Seruni karena dikelilingi oleh hutan dan tanaman bunga seruni, di area tersebut terdapat  tujuh sumber mata air jernih menyatu menjadi satu, sumber mata air ini  mengalir dari salah satu pegunungan dan membentuk danau kecil yang digunakan mandi oleh masyarakat sekitar dan menurut cerita dahulu. Pernah dibuat mandi para bidadari, sehingga masyarakat Osing setempat menyebutnya dengan nama “Sendang” disamping itu disekitar sumber mata air terdapat banyak tanaman bunga, maka masyarakat Osing setempat menyebutnya tanaman bunga seruni, kemudian masyarakat Osing  setempat memberi nama “Sendang Seruni” untuk  ikon objek wisata di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin. Masyarakat Osing setempat  meyakini air Sendang Seruni bisa membuat awet muda dan mampu mengurangi penyakit dalam dan rasa capek pada tubuh. Setiap satu tahun di malam satu suro juru kunci Sendang Seruni, Pak Karsono dan masyarakat Osing setempat mengadakan ritual rutin untuk menghormati leluhur yang terdahulu, agar tujuh sumber mata air di Sendang Seruni tetap terjaga kelestariannya juga pengunjung terjaga keselamatannya, khusus kalangan wisatawan perempuan yang sedang berhalangan tidak diperbolehkan melewati tujuh sumber mata air tanpa seijin dari juru kunci karena diyakini sakral oleh masyarakat Osing setempat.",
            )
        )
        wisata.add(
            WisataDomain(
                "2",
                "Kawah Ijen",
                arrayListOf(),
                4.8f,
                522,
                -8.1773991,
                114.2418842,
                "Kawah Ijen adalah sebuah danau kawah yang bersifat asam yang berada di puncak Gunung Ijen dengan kedalaman danau 200 meter dan luas kawah mencapai 5.466 Hektar. Danau kawah Ijen dikenal merupakan danau air asam kuat terbesar di dunia[1]. Kawah Ijen berada dalam wilayah Cagar Alam Taman Wisata Ijen Kabupaten Bondowoso dan Kabupaten Banyuwangi, Jawa Timur. Fenomena eternal blue fire atau api biru abadi berada di dalam kawah Ijen, dan pemandangan alami ini hanya terjadi di dua tempat di dunia yaitu Islandia dan Ijen. Blue fire hanya dapat dilihat oleh mata manusia saat tidak ada cahaya, karenanya waktu ideal untuk melihatnya adalah jam 2 hingga jam 4 dinihari, karena pendakian Gunung Ijen baru mulai dibuka jam 2 dinihari. Dari Kawah Ijen, kita dapat melihat pemandangan gunung lain yang ada di kompleks Pegunungan Ijen, di antaranya adalah puncak Gunung Marapi yang berada di timur Kawah Ijen, Gunung Raung, Gunung Suket, dan Gunung Rante.",
            )
        )
        wisata.add(
            WisataDomain(
                "3",
                "Taman Gandrung Terakota",
                arrayListOf(),
                4f,
                56,
                -8.1773991,
                114.2418842,
                "Taman Gandrung Terakota adalah situs rawat ruwat seni budaya Banyuwangi yang terletak di sebuah kawasan kaki gunung Ijen dan bukit hijau dan hamparan sawah yang didalamnya dapat ditemukan galeri seni rupa, amfiteater terbuka sendratari, pementasan dramatari “Meras Gandrung”, perlehatan musik. Taman Gandrung Terakota berlokasi di Dusun Blimbingsari Desa Tamansari Kecamatan Licin Kabupaten Banyuwangi Provinsi Jawa Timur. Kawasan ini digagas oleh Sigit Pramono.",
            )
        )
        return wisata
    }

    fun generateTicketWisata(): List<TicketWisataDomain> {
        val arrayList = arrayListOf<TicketWisataDomain>()
        arrayList.add(TicketWisataDomain("1", "Tiket Domestik", 5000))
        arrayList.add(TicketWisataDomain("2", "Tiket Manca", 25000))
        arrayList.add(TicketWisataDomain("3", "Tiket Spesial", 100000))
        return arrayList
    }


//    fun generateTravelPackageTicket(): List<TravelPackageDomain> {
//        val list = arrayListOf<TravelPackageDomain>()
//        list.add(TravelPackageDomain("1", "1", "Private Trip 6 Orang", 190000, ""))
//        list.add(TravelPackageDomain("2", "1", "Private Trip 5 Orang", 225000, ""))
//        list.add(TravelPackageDomain("3", "1", "Private Trip 4 Orang", 280000, ""))
//        list.add(TravelPackageDomain("4", "1", "Private Trip 3 Orang", 345000, ""))
//        return list
//    }
}