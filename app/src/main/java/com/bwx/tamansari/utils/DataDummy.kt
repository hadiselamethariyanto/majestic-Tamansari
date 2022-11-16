package com.bwx.tamansari.utils

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

    fun generateRatingWisata(): List<RatingWisataDomain> {
        val list = arrayListOf<RatingWisataDomain>()
        list.add(
            RatingWisataDomain(
                id = "1",
                username = "Ferdi Sambo",
                rating = 4f,
                review = "Wisatanya keren",
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
                createdDate = "12 Nov"
            )
        )

        list.add(
            RatingWisataDomain(
                id = "2",
                username = "Kuat Ma'ruf",
                rating = 5f,
                review = "Wisatanya masih asri",
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
                createdDate = "12 Nov"
            )
        )

        list.add(
            RatingWisataDomain(
                id = "3",
                username = "Ricky Rizal",
                rating = 4f,
                review = "Kebersihannya terjaga",
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
                createdDate = "12 Nov"
            )
        )

        return list
    }

    fun generateHomestay(): List<HomestayDomain> {
        val homestay = arrayListOf<HomestayDomain>()
        homestay.add(
            HomestayDomain(
                "1",
                "Vivi Homestay",
                1.4,
                150000,
                4.3f,
                6,
                1f,
                arrayListOf(
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349212550.jpg?k=6508bb3a88a154676aea88c16af37e78e38826a02cc93d62b9232640d9eeb146&o=&hp=1",
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349212574.jpg?k=d88268d689a3765c9e8cb1770df33dea2339117fb8fb0986fe2cc0808cbc6bc5&o=&hp=1",
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349213407.jpg?k=0912d0a15a77d0e8167666199b5004f97e2e01e709a55dffa2abe192a8edc6bc&o=&hp=1"
                ),
                "14:00-23:59",
                "12:00",
                114.245907,
                -8.1727349,
                "Dusun Sumberwatu, RT.001/RW.002, Tamansari, Kec. Licin, Kabupaten Banyuwangi, Jawa Timur 68485",
                arrayListOf(
                    FacilityDomain(
                        "WiFi",
                        "https://wisata.online/assets/images/tamansari/wifi.png"
                    ),
                    FacilityDomain(
                        "AC",
                        "https://wisata.online/assets/images/tamansari/air-conditioner.png"
                    ),
                    FacilityDomain(
                        "Parkir",
                        "https://wisata.online/assets/images/tamansari/parking.png"
                    ),
                    FacilityDomain(
                        "TV",
                        "https://wisata.online/assets/images/tamansari/television.png"
                    )
                )
            )
        )

        homestay.add(
            HomestayDomain(
                "2",
                "Jambu Merah Homestay",
                1.4,
                150000,
                4.3f,
                14,
                1f,
                arrayListOf(
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349210208.jpg?k=5de59963e029ff038f9ce61891fb62ee0eda9cd16d7bec9497c18d3a762864ad&o=&hp=1",
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349210220.jpg?k=3e1924fbb353007b9bcc77906d3dcb1c447ad01bdf989cbb243b08d8681e2fc5&o=&hp=1",
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349210231.jpg?k=2c967f270c3531834f979e5970a0102f95fdced5b89998ce9b55b32d740df9a7&o=&hp=1"
                ),
                "14:00-23:59",
                "12:00",
                114.245907,
                -8.1727349,
                "Dusun Sumberwatu, RT.001/RW.002, Tamansari, Kec. Licin, Kabupaten Banyuwangi, Jawa Timur 68485",
                arrayListOf(
                    FacilityDomain(
                        "WiFi",
                        "https://wisata.online/assets/images/tamansari/wifi.png"
                    ),
                    FacilityDomain(
                        "AC",
                        "https://wisata.online/assets/images/tamansari/air-conditioner.png"
                    ),
                    FacilityDomain(
                        "Parkir",
                        "https://wisata.online/assets/images/tamansari/parking.png"
                    ),
                    FacilityDomain(
                        "TV",
                        "https://wisata.online/assets/images/tamansari/television.png"
                    )
                )
            )
        )
        homestay.add(
            HomestayDomain(
                "3",
                "Berliant Homestay",
                1.4,
                150000,
                4.3f,
                31,
                1f,
                arrayListOf(
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349212196.jpg?k=b67c576d2fc996d5ab58d7dfd612fb63d3a2e64b6ad0cde4564dbb96173c3f7a&o=&hp=1",
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349211643.jpg?k=7e92d1096cadfda8c3d5be53d7ada2c554221f2a4ba723cb1176db721d823dea&o=&hp=1",
                    "https://cf.bstatic.com/xdata/images/hotel/max1024x768/349211613.jpg?k=768b55e78781b2c072f4dbe84b8745c7519ea1913370fd5b0881ad0f6e37a986&o=&hp=1"
                ),
                "14:00-23:59",
                "12:00",
                114.245907,
                -8.1727349,
                "Dusun Sumberwatu, RT.001/RW.002, Tamansari, Kec. Licin, Kabupaten Banyuwangi, Jawa Timur 68485",
                arrayListOf(
                    FacilityDomain(
                        "WiFi",
                        "https://wisata.online/assets/images/tamansari/wifi.png"
                    ),
                    FacilityDomain(
                        "AC",
                        "https://wisata.online/assets/images/tamansari/air-conditioner.png"
                    ),
                    FacilityDomain(
                        "Parkir",
                        "https://wisata.online/assets/images/tamansari/parking.png"
                    ),
                    FacilityDomain(
                        "TV",
                        "https://wisata.online/assets/images/tamansari/television.png"
                    )
                )
            )
        )
        return homestay
    }

    fun generateTravelPackage(): List<PaketWisataModel> {
        val paket = arrayListOf<PaketWisataModel>()
        paket.add(
            PaketWisataModel(
                "Nikmati Sedikit Waktu Luang",
                250000,
                4.0f,
                arrayListOf(
                    "https://farm1.staticflickr.com/579/20221640953_532b833a80_b.jpg",
                    "https://tamansariijen.com/wp-content/uploads/2019/10/WhatsApp-Image-2019-09-24-at-21.38.02-1.jpeg",
                    "https://cdn.nativeindonesia.com/foto/2018/11/Kawah-Ijen-Blue.jpg",
                    "https://asset.kompas.com/crops/7-0zX9IZsHSzcZZz3bMTdMZq-oE=/0x0:1200x800/750x500/data/photo/2021/08/19/611e162fed8b4.jpg"
                ),
                11,
                20,
                arrayListOf(
                    ItineraryDomain("1", "00:00 - 00.30 WIB", "Penjemputan peserta"),
                    ItineraryDomain("2", "00.30 - 02.30 WIB", "Perjalanan ke Basecamp Jeep"),
                    ItineraryDomain(
                        "3",
                        "02.30 - 03.30 WIB",
                        "Perjalanan ke sunrise point menggunakan Jeep"
                    )
                ),
                114.245907,
                -8.1727349,
                "Dusun Sumberwatu, RT.001/RW.002, Tamansari, Kec. Licin, Kabupaten Banyuwangi, Jawa Timur 68485",
            )
        )
        paket.add(
            PaketWisataModel(
                "Nikmati Destinasi Wisata Tamansari",
                500000,
                4.0f,
                arrayListOf(
                    "https://tamansariijen.com/wp-content/uploads/2020/10/runi.jpg",
                    "https://farm1.staticflickr.com/579/20221640953_532b833a80_b.jpg",
                    "https://cdn.nativeindonesia.com/foto/2018/11/Kawah-Ijen-Blue.jpg",
                    "https://asset.kompas.com/crops/7-0zX9IZsHSzcZZz3bMTdMZq-oE=/0x0:1200x800/750x500/data/photo/2021/08/19/611e162fed8b4.jpg"
                ),
                21,
                30,
                arrayListOf(
                    ItineraryDomain("1", "00:00 - 00.30 WIB", "Penjemputan peserta"),
                    ItineraryDomain("2", "00.30 - 02.30 WIB", "Perjalanan ke Basecamp Jeep"),
                    ItineraryDomain(
                        "3",
                        "02.30 - 03.30 WIB",
                        "Perjalanan ke sunrise point menggunakan Jeep"
                    )
                ),
                114.245907,
                -8.1727349,
                "Dusun Sumberwatu, RT.001/RW.002, Tamansari, Kec. Licin, Kabupaten Banyuwangi, Jawa Timur 68485",
            )
        )
        paket.add(
            PaketWisataModel(
                "Budaya dan Edukasi Tamansari",
                750000,
                4.0f,
                arrayListOf(
                    "https://tamansariijen.com/wp-content/uploads/2020/11/DSC06920-scaled.jpg",
                    "https://farm1.staticflickr.com/579/20221640953_532b833a80_b.jpg",
                    "https://cdn.nativeindonesia.com/foto/2018/11/Kawah-Ijen-Blue.jpg",
                    "https://asset.kompas.com/crops/7-0zX9IZsHSzcZZz3bMTdMZq-oE=/0x0:1200x800/750x500/data/photo/2021/08/19/611e162fed8b4.jpg"
                ),
                14,
                15,
                arrayListOf(
                    ItineraryDomain("1", "00:00 - 00.30 WIB", "Penjemputan peserta"),
                    ItineraryDomain("2", "00.30 - 02.30 WIB", "Perjalanan ke Basecamp Jeep"),
                    ItineraryDomain(
                        "3",
                        "02.30 - 03.30 WIB",
                        "Perjalanan ke sunrise point menggunakan Jeep"
                    )
                ),
                114.245907,
                -8.1727349,
                "Dusun Sumberwatu, RT.001/RW.002, Tamansari, Kec. Licin, Kabupaten Banyuwangi, Jawa Timur 68485",
            )
        )

        return paket
    }

    fun generateRestaurant(): List<RestaurantDomain> {
        val list = ArrayList<RestaurantDomain>()
        list.add(
            RestaurantDomain(
                "1",
                "Warung Oseng",
                "Traditional Food, Ayam & Bebek",
                0.0,
                0.0,
                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
                4f,
                1.4,
                12
            )
        )
        list.add(
            RestaurantDomain(
                "2",
                "Warung Oseng 2",
                "Traditional Food, Bakmie, Aneka Nasi",
                0.0,
                0.0,
                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
                4f,
                1.8,
                21
            )
        )
        list.add(
            RestaurantDomain(
                "3",
                "Sarine Kopi",
                "Aneka kopi, Minuman",
                0.0,
                0.0,
                "https://tamansariijen.com/wp-content/uploads/2021/10/v60-sarine-kopi.jpg",
                4f,
                2.0,
                30
            )
        )
        return list
    }

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

    fun generateNews(): List<BeritaModel> {
        val berita = arrayListOf<BeritaModel>()
        berita.add(
            BeritaModel(
                "Tamansari Banyuwangi Masuk 50 Besar Anugerah Desa Wisata Indonesia Tahun 2021 dari Kemenparekraf",
                "25 Agustus 2021",
                "https://assets.promediateknologi.com/crop/0x0:0x0/x/photo/2021/08/25/1875519396.png",
                "Wisata alam menjadi salah satu andalan dunia Pariwisata Banyuwangi. Terdapat puluhan wisata alam, mulai pantai, gunung, air terjun hingga pemandian alam. Salah satunya adalah wisata alam Sendang Seruni. Wisata alam ini menyajikan keindahan alam plus kolam pemandian dengan air langsung dari mata air. Airnya dijamin dingin dan menyegarkan.\n" +
                        "\n" +
                        "Sendang Seruni berada di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin, Banyuwangi. Desa Tamansari ini merupakan satu dari 50 Desa Wisata terbaik di Indonesia. Lokasi ini berada 19km arah barat Kota Banyuwangi di ketinggian kurang lebih 600 meter di atas permukaan laut.  ",
                54,
                12,
                "Prestasi"
            )
        )
        berita.add(
            BeritaModel(
                "Desa Tamansari Banyuwangi Menuju Ajang ADWI 2021",
                "28 Agustus 2021",
                "https://grafikanews.com/foto_berita/14WhatsApp%20Image%202021-08-28%20at%2019.35.55.jpeg",
                "Wisata alam menjadi salah satu andalan dunia Pariwisata Banyuwangi. Terdapat puluhan wisata alam, mulai pantai, gunung, air terjun hingga pemandian alam. Salah satunya adalah wisata alam Sendang Seruni. Wisata alam ini menyajikan keindahan alam plus kolam pemandian dengan air langsung dari mata air. Airnya dijamin dingin dan menyegarkan.\n" +
                        "\n" +
                        "Sendang Seruni berada di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin, Banyuwangi. Desa Tamansari ini merupakan satu dari 50 Desa Wisata terbaik di Indonesia. Lokasi ini berada 19km arah barat Kota Banyuwangi di ketinggian kurang lebih 600 meter di atas permukaan laut.  ",
                54,
                12,
                "Wisata"
            )
        )
        berita.add(
            BeritaModel(
                "Kawan Ijen dan 14 Lokasi Wisata di Banyuwangi Resmi Dibuka Kembali",
                "10 September 2021",
                "https://img.idxchannel.com/media/700/images/idx/2021/06/10/SBY_Wisata_Kawah_Ijen_Ali_Masduki__14___1_.jpg",
                "Wisata alam menjadi salah satu andalan dunia Pariwisata Banyuwangi. Terdapat puluhan wisata alam, mulai pantai, gunung, air terjun hingga pemandian alam. Salah satunya adalah wisata alam Sendang Seruni. Wisata alam ini menyajikan keindahan alam plus kolam pemandian dengan air langsung dari mata air. Airnya dijamin dingin dan menyegarkan.\n" +
                        "\n" +
                        "Sendang Seruni berada di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin, Banyuwangi. Desa Tamansari ini merupakan satu dari 50 Desa Wisata terbaik di Indonesia. Lokasi ini berada 19km arah barat Kota Banyuwangi di ketinggian kurang lebih 600 meter di atas permukaan laut.  ",
                54,
                12,
                "Pengumuman"
            )
        )
        return berita
    }

    fun generateWisata():List<WisataDomain>{
        val wisata = arrayListOf<WisataDomain>()
        wisata.add(
            WisataDomain(
                "1",
                "Sendang Seruni",
                "https://1.bp.blogspot.com/-ieRLBNtIKmA/XfX8x5zY-7I/AAAAAAAARXY/yanVJaCxyDUUf3p0QeV9bOU4TmhmuNoJwCLcBGAsYHQ/s1600/SendangSeruni_011.JPG",
                4f,
                123,
                -8.1773991,
                114.2418842,
                "Segar dan jernih itulah dua kesan pertama saat melihat panorama pemandian Sendang Seruni, menurut nenek moyang setempat Sendang Seruni dahulunya adalah sumber mata air yang disebut sumber Seruni karena dikelilingi oleh hutan dan tanaman bunga seruni, di area tersebut terdapat  tujuh sumber mata air jernih menyatu menjadi satu, sumber mata air ini  mengalir dari salah satu pegunungan dan membentuk danau kecil yang digunakan mandi oleh masyarakat sekitar dan menurut cerita dahulu. Pernah dibuat mandi para bidadari, sehingga masyarakat Osing setempat menyebutnya dengan nama “Sendang” disamping itu disekitar sumber mata air terdapat banyak tanaman bunga, maka masyarakat Osing setempat menyebutnya tanaman bunga seruni, kemudian masyarakat Osing  setempat memberi nama “Sendang Seruni” untuk  ikon objek wisata di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin. Masyarakat Osing setempat  meyakini air Sendang Seruni bisa membuat awet muda dan mampu mengurangi penyakit dalam dan rasa capek pada tubuh. Setiap satu tahun di malam satu suro juru kunci Sendang Seruni, Pak Karsono dan masyarakat Osing setempat mengadakan ritual rutin untuk menghormati leluhur yang terdahulu, agar tujuh sumber mata air di Sendang Seruni tetap terjaga kelestariannya juga pengunjung terjaga keselamatannya, khusus kalangan wisatawan perempuan yang sedang berhalangan tidak diperbolehkan melewati tujuh sumber mata air tanpa seijin dari juru kunci karena diyakini sakral oleh masyarakat Osing setempat.",
                5000
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
                "Kawah Ijen adalah sebuah danau kawah yang bersifat asam yang berada di puncak Gunung Ijen dengan kedalaman danau 200 meter dan luas kawah mencapai 5.466 Hektar. Danau kawah Ijen dikenal merupakan danau air asam kuat terbesar di dunia[1]. Kawah Ijen berada dalam wilayah Cagar Alam Taman Wisata Ijen Kabupaten Bondowoso dan Kabupaten Banyuwangi, Jawa Timur. Fenomena eternal blue fire atau api biru abadi berada di dalam kawah Ijen, dan pemandangan alami ini hanya terjadi di dua tempat di dunia yaitu Islandia dan Ijen. Blue fire hanya dapat dilihat oleh mata manusia saat tidak ada cahaya, karenanya waktu ideal untuk melihatnya adalah jam 2 hingga jam 4 dinihari, karena pendakian Gunung Ijen baru mulai dibuka jam 2 dinihari. Dari Kawah Ijen, kita dapat melihat pemandangan gunung lain yang ada di kompleks Pegunungan Ijen, di antaranya adalah puncak Gunung Marapi yang berada di timur Kawah Ijen, Gunung Raung, Gunung Suket, dan Gunung Rante.",
                5000
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
                "Taman Gandrung Terakota adalah situs rawat ruwat seni budaya Banyuwangi yang terletak di sebuah kawasan kaki gunung Ijen dan bukit hijau dan hamparan sawah yang didalamnya dapat ditemukan galeri seni rupa, amfiteater terbuka sendratari, pementasan dramatari “Meras Gandrung”, perlehatan musik. Taman Gandrung Terakota berlokasi di Dusun Blimbingsari Desa Tamansari Kecamatan Licin Kabupaten Banyuwangi Provinsi Jawa Timur. Kawasan ini digagas oleh Sigit Pramono.",
                5000
            )
        )
        return wisata
    }

    fun generateTicketWisata():List<TicketWisataDomain>{
        val arrayList = arrayListOf<TicketWisataDomain>()
        arrayList.add(TicketWisataDomain("1","Tiket Domestik",5000))
        arrayList.add(TicketWisataDomain("2","Tiket Manca",25000))
        arrayList.add(TicketWisataDomain("3","Tiket Spesial",100000))
        return arrayList
    }
}