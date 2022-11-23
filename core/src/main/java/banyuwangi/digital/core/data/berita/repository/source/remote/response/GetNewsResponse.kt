package banyuwangi.digital.core.data.berita.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetNewsResponse(val success: Boolean, val message: String, val data: List<NewsItem>)

data class NewsItem(
    val id: String,
    val title: String,
    val content: String,
    @field:SerializedName("photo_url") val photoUrl: String,
    @field:SerializedName("created_date") val createdDate: Long,
    @field:SerializedName("total_like") val totalLike: Int,
    @field:SerializedName("total_comment") val totalComment: Int,
    val category:String
)
