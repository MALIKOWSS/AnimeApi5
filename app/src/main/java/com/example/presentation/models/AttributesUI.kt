package com.example.presentation.models

import com.example.animeapi.domain.models.Attributes
import com.google.gson.annotations.SerializedName

data class AttributesUI(
    @SerializedName("description")
    val description: String,
    @SerializedName("posterImage")
    val posterImage: PosterImageUI,
    @SerializedName("titles")
    val titles: TitlesUI,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
    )

fun Attributes.toUI(): AttributesUI = AttributesUI(
    description,
    posterImage.toUI(),
    titles.toUI(),
    canonicalTitle,
)