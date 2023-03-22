package com.example.data.remote.apiservices.anime

import com.example.data.dtos.anime.DataItemDto
import com.example.data.dtos.anime.MangaResponseDto
import retrofit2.http.GET

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
    ): MangaResponseDto<DataItemDto>
}
