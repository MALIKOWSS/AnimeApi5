package com.example.data.repositories.manga

import com.example.data.dtos.anime.toDomain
import com.example.data.remote.apiservices.manga.MangaApiService
import com.example.domain.models.DataItem
import com.example.domain.repositories.manga.MangaRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    private val mangaApiService: MangaApiService
) : MangaRepository {

    override fun fetchManga() = flow<Either<String, List<DataItem>>> {
        emit(Either.Right(mangaApiService.fetchManga().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error Occurred!!"))
    }
}