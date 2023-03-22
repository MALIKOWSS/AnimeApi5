package com.example.animeapi.data.remote.apiservices.anime

import com.example.animeapi.data.dtos.anime.DataItemDto
import com.example.animeapi.data.dtos.anime.MangaResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
    ): MangaResponseDto<DataItemDto>
}
