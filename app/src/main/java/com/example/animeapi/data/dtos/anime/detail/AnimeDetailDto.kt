package com.example.animeapi.data.dtos.anime.detail

import com.example.animeapi.data.dtos.anime.DataItemDto
import com.example.animeapi.data.dtos.anime.toDomain
import com.example.animeapi.domain.models.AnimeDetail
import com.google.gson.annotations.SerializedName

data class AnimeDetailDto(
    @SerializedName("data")
    val data:DataItemDto
)

fun AnimeDetailDto.toDomain(): AnimeDetail= AnimeDetail(
    data.toDomain()
)