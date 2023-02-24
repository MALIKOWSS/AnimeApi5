package com.example.animeapi.data.repositories.manga

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.remote.apiservices.manga.MangaApiService
import com.example.animeapi.data.remote.apiservices.pagingsources.manga.MangaPagingSources
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSources(mangaApiService)
    }.liveData

    fun fetchMangaById(id: Int) = doRequest {
        mangaApiService.fetchMangaById(id = id)
    }
}