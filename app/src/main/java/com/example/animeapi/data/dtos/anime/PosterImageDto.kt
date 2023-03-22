package com.example.animeapi.data.dtos.anime

import com.example.animeapi.domain.models.PosterImage
import com.google.gson.annotations.SerializedName

data class PosterImageDto(
    @SerializedName("original")
    val original: String,
)

fun PosterImageDto.toDomain() : PosterImage = PosterImage(
    original
)