package com.example.animeapi.domain.usecases.anime

import com.example.animeapi.domain.models.DataItem
import com.example.animeapi.domain.repositories.anime.AnimeRepository
import com.example.animeapi.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAnimeUseCase @Inject constructor(
    private val repository: AnimeRepository,
) {

    operator fun invoke(): Flow<Either<String, List<DataItem>>> = repository.fetchAnime()
}