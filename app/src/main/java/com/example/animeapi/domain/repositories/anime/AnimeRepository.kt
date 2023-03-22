package com.example.animeapi.domain.repositories.anime

import com.example.animeapi.domain.models.DataItem
import com.example.animeapi.domain.utils.Either
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun fetchAnime(): Flow<Either<String, List<DataItem>>>
}