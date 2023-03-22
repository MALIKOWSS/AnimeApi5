package com.example.data.repositories.anime

import com.example.data.dtos.anime.toDomain
import com.example.data.remote.apiservices.anime.AnimeApiService
import com.example.domain.models.DataItem
import com.example.domain.repositories.anime.AnimeRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val animeApiService: AnimeApiService,
) : AnimeRepository {

    override fun fetchAnime() = flow<Either<String, List<DataItem>>> {
        emit(Either.Right(animeApiService.fetchAnime().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error Occurred!!"))
    }
}