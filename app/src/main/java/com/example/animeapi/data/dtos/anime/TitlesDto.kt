package com.example.animeapi.data.dtos.anime

import com.example.animeapi.domain.models.Titles
import com.google.gson.annotations.SerializedName

data class TitlesDto(
    @SerializedName("en")
    val en: String?,
    @SerializedName("ja_jp")
    val jaJp: String?,
    @SerializedName("en_jp")
    val enJp: String?,
)

fun TitlesDto.toDomain(): Titles = Titles(en, jaJp, enJp)