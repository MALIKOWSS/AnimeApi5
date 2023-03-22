package com.example.presentation.models

import com.example.domain.models.PosterImage
import com.google.gson.annotations.SerializedName


data class PosterImageUI(
    @SerializedName("original")
    val original: String,
)
fun PosterImage.toUI() : PosterImageUI = PosterImageUI(
    original
)