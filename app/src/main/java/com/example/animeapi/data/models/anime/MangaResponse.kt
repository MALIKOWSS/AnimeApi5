package com.example.animeapi.data.models.anime

import com.google.gson.annotations.SerializedName


data class MangaResponse<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: Links
)