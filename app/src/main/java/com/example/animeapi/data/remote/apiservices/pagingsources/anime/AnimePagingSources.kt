package com.example.animeapi.data.remote.apiservices.pagingsources.anime

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animeapi.data.models.anime.DataItem
import com.example.animeapi.data.remote.apiservices.anime.AnimeApiService
import retrofit2.HttpException
import java.io.IOException

class AnimePagingSources(private val animeApiService: AnimeApiService) :
    PagingSource<Int, DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        try {
            val page = params.key ?: 1
            val response = animeApiService.fetchAnime(params.loadSize, page)
            val nextPageNumber =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            return LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}