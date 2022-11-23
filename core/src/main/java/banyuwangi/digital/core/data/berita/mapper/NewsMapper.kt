package banyuwangi.digital.core.data.berita.mapper

import banyuwangi.digital.core.data.berita.repository.source.remote.response.NewsItem
import banyuwangi.digital.core.domain.model.NewsDomain

object NewsMapper {

    fun mapNewsItemToDomain(news:List<NewsItem>):List<NewsDomain> = news.map {
        NewsDomain(
            id = it.id,
            title = it.title,
            createdDate = it.createdDate * 1000,
            photo = it.photoUrl,
            content = it.content,
            totalComments = it.totalComment,
            totalLikes = it.totalLike,
            category = it.category
        )
    }
}