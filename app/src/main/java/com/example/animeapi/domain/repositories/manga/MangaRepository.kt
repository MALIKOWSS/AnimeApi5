package com.example.animeapi.domain.repositories.manga

import com.example.animeapi.domain.models.DataItem
import com.example.animeapi.domain.utils.Either
import kotlinx.coroutines.flow.Flow

interface MangaRepository {

    fun fetchManga(): Flow<Either<String, List<DataItem>>>
}