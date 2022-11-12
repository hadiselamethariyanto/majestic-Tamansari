package com.bwx.tamansari.utils

import com.bwx.tamansari.model.GalleryWisataDomain
import com.bwx.tamansari.model.RatingWisataDomain

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
}