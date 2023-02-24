    package com.example.animeapi.data.remote.apiservices.anime

import com.example.animeapi.data.models.anime.DataItem
import com.example.animeapi.data.models.anime.MangaResponse
import com.example.animeapi.data.models.anime.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): MangaResponse<DataItem>

    @GET("edge/anime/{id}")
    suspend fun fetchAnimeById(
        @Path("id") id: Int
    ): AnimeDetail
}
