package com.example.data.dtos.anime.detail

import com.example.data.dtos.anime.DataItemDto
import com.example.data.dtos.anime.toDomain
import com.example.domain.models.AnimeDetail
import com.google.gson.annotations.SerializedName

data class AnimeDetailDto(
    @SerializedName("data")
    val data: DataItemDto
)

fun AnimeDetailDto.toDomain(): AnimeDetail = AnimeDetail(
    data.toDomain()
)