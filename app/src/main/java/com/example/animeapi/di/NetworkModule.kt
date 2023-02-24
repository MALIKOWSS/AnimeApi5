package com.example.animeapi.di

import com.example.animeapi.data.remote.RetrofitClient
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

    @Singleton
    @Provides
    fun provideSingInApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideSingInApiService()
}