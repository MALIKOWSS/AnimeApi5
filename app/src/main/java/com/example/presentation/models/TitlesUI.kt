package com.example.presentation.models

import com.example.animeapi.domain.models.Titles
import com.google.gson.annotations.SerializedName

data class TitlesUI(
    @SerializedName("en")
    val en: String?,
    @SerializedName("ja_jp")
    val jaJp: String?,
    @SerializedName("en_jp")
    val enJp: String?,
)
fun Titles.toUI(): TitlesUI = TitlesUI(en, jaJp, enJp)