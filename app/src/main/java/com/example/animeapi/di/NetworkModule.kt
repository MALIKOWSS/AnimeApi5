package com.example.animeapi.di

import com.example.animeapi.data.remote.RetrofitClient
import com.example.animeapi.data.remote.apiservices.anime.AnimeApiService
import com.example.animeapi.data.repositories.anime.AnimeRepositoryImpl
import com.example.animeapi.data.repositories.manga.MangaRepositoryImpl
import com.example.animeapi.domain.repositories.anime.AnimeRepository
import com.example.animeapi.domain.repositories.manga.MangaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService() = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideMangaApiService()
}