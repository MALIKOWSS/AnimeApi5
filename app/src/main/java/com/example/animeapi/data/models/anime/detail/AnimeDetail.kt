package com.example.animeapi.data.models.anime.detail

import com.example.animeapi.data.models.anime.DataItem
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: DataItem
)
