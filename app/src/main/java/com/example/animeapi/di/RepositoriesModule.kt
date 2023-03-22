package com.example.animeapi.di

import com.example.animeapi.data.repositories.anime.AnimeRepositoryImpl
import com.example.animeapi.data.repositories.manga.MangaRepositoryImpl
import com.example.animeapi.domain.repositories.anime.AnimeRepository
import com.example.animeapi.domain.repositories.manga.MangaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindAnimeRepository(animeRepositoryImpl: AnimeRepositoryImpl): AnimeRepository

    @Binds
    fun bindMangaRepository(mangaRepositoryImpl: MangaRepositoryImpl): MangaRepository
}