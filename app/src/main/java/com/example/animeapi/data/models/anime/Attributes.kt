package com.example.animeapi.data.models.anime

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("ratingRank")
    val ratingRank: Int = 0,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("subtype")
    val subtype: String = "",
    @SerializedName("averageRating")
    val averageRating: String = "",
    @SerializedName("volumeCount")
    val volumeCount: Int = 0,
    @SerializedName("abbreviatedTitles")
    val abbreviatedTitles: List<String>?,
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("updatedAt")
    val updatedAt: String = "",
    @SerializedName("chapterCount")
    val chapterCount: Int = 0,
    @SerializedName("mangaType")
    val mangaType: String = "",
    @SerializedName("synopsis")
    val synopsis: String = "",
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("favoritesCount")
    val favoritesCount: Int = 0,
    @SerializedName("serialization")
    val serialization: String = "",
    @SerializedName("coverImageTopOffset")
    val coverImageTopOffset: Int = 0,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String = "",
    @SerializedName("userCount")
    val userCount: Int = 0,
    @SerializedName("popularityRank")
    val popularityRank: Int = 0,
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: String = ""
)