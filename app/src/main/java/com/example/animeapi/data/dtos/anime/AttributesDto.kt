package com.example.animeapi.data.dtos.anime

import com.example.animeapi.domain.models.Attributes
import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("posterImage")
    val posterImage: PosterImageDto,
    @SerializedName("titles")
    val titles: TitlesDto,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
)

fun AttributesDto.toDomain(): Attributes = Attributes(
    description,
    posterImage.toDomain(),
    titles.toDomain(),
    canonicalTitle)