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

    fun generateHomestay(): List<HomestayModel> {
        val homestay = arrayListOf<HomestayModel>()
        homestay.add(
            HomestayModel(
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
                )
            )
        )
        homestay.add(
            HomestayModel(
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
                )
            )
        )
        homestay.add(
            HomestayModel(
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
                "https://tamansariijen.com/wp-content/uploads/2019/10/WhatsApp-Image-2019-09-24-at-21.38.02-1.jpeg"
            )
        )
        paket.add(
            PaketWisataModel(
                "Nikmati Destinasi Wisata Tamansari",
                500000,
                4.0f,
                "https://tamansariijen.com/wp-content/uploads/2020/10/runi.jpg"
            )
        )
        paket.add(
            PaketWisataModel(
                "Budaya dan Edukasi Tamansari",
                750000,
                4.0f,
                "https://tamansariijen.com/wp-content/uploads/2020/11/DSC06920-scaled.jpg"
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
                "Traditional Food",
                0.0,
                0.0,
                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
                4f
            )
        )
        list.add(
            RestaurantDomain(
                "2",
                "Warung Oseng 2",
                "Traditional Food",
                0.0,
                0.0,
                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
                4f
            )
        )
        list.add(
            RestaurantDomain(
                "3",
                "Warung Oseng 3",
                "Traditional Food",
                0.0,
                0.0,
                "https://asset.kompas.com/crops/A7H0vt6v6p95MQfOQTqIhMqhklE=/41x0:554x256/375x240/data/photo/2019/10/15/5da5188e04c2c.png",
                4f
            )
        )
        return list
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
}