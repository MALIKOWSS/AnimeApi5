package com.example.presentation.models

import com.example.domain.models.AnimeDetail
import com.google.gson.annotations.SerializedName

data class AnimeDetailUI(
    @SerializedName("data")
    val data: DataItemUI
)
fun AnimeDetail.toUI(): AnimeDetailUI = AnimeDetailUI(
    data.toUI()
)