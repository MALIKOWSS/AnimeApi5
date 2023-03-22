package com.example.domain.usecases.manga

import com.example.domain.models.DataItem
import com.example.domain.repositories.manga.MangaRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMangaUseCase @Inject constructor(
    private val repository: MangaRepository,
) {

    operator fun invoke(): Flow<Either<String, List<DataItem>>> =
        repository.fetchManga()
}