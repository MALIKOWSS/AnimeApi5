package com.example.domain.usecases.anime

import com.example.domain.models.DataItem
import com.example.domain.repositories.anime.AnimeRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAnimeUseCase @Inject constructor(
    private val repository: AnimeRepository,
) {

    operator fun invoke(): Flow<Either<String, List<DataItem>>> = repository.fetchAnime()
}