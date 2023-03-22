package com.example.data.dtos.anime

import com.google.gson.annotations.SerializedName

data class MangaResponseDto<T>(
    @SerializedName("data")
    val data: List<T>,
)