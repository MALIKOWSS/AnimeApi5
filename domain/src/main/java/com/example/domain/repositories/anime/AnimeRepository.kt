package com.example.domain.repositories.anime

import com.example.domain.models.DataItem
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun fetchAnime(): Flow<Either<String, List<DataItem>>>
}