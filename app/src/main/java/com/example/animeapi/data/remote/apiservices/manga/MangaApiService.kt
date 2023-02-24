package com.example.animeapi.data.remote.apiservices.manga

import com.example.animeapi.data.models.anime.DataItem
import com.example.animeapi.data.models.anime.MangaResponse
import com.example.animeapi.data.models.anime.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): MangaResponse<DataItem>

    @GET("edge/manga/{id}")
    suspend fun fetchMangaById(
        @Path("id") id: Int
    ): AnimeDetail
}