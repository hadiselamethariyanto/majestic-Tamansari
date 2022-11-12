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
                "Jambu Merah Homestay",
                1.4,
                150000,
                4.3f,
                "https://tamansariijen.com/wp-content/uploads/2021/02/Jambu-Merah-Homestay.jpg"
            )
        )
        homestay.add(
            HomestayModel(
                "Kastini Homestay",
                1.4,
                150000,
                4.3f,
                "https://tamansariijen.com/wp-content/uploads/2021/02/kastini-homestay-1.jpg"
            )
        )
        homestay.add(
            HomestayModel(
                "Tolak Homestay",
                1.4,
                150000,
                4.3f,
                "https://tamansariijen.com/wp-content/uploads/2021/02/Tolak-Homestay.jpg"
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
                "Rabu, 25 Agustus 2021 | 13:16 WIB",
                "https://assets.promediateknologi.com/crop/0x0:0x0/x/photo/2021/08/25/1875519396.png"
            )
        )
        berita.add(
            BeritaModel(
                "Desa Tamansari Banyuwangi Menuju Ajang ADWI 2021",
                "28 Agustus 2021",
                "https://grafikanews.com/foto_berita/14WhatsApp%20Image%202021-08-28%20at%2019.35.55.jpeg"
            )
        )
        berita.add(
            BeritaModel(
                "Kawan Ijen dan 14 Lokasi Wisata di Banyuwangi Resmi Dibuka Kembali",
                "Jum'at, 10 September 2021 15:55 WIB",
                "https://img.idxchannel.com/media/700/images/idx/2021/06/10/SBY_Wisata_Kawah_Ijen_Ali_Masduki__14___1_.jpg"
            )
        )
        return berita
    }
}