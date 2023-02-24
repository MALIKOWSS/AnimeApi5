package com.example.animeapi.data.repositories.anime

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.remote.apiservices.anime.AnimeApiService
import com.example.animeapi.data.remote.apiservices.pagingsources.anime.AnimePagingSources
import javax.inject.Inject

class AnimeRepository  @Inject constructor(
    private val animeApiService: AnimeApiService,
) : BaseRepository() {

    fun fetchAnime()  = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSources(animeApiService)
    }.liveData

    fun fetchAnimeById(id: Int) = doRequest {
        animeApiService.fetchAnimeById(id = id)
    }
}