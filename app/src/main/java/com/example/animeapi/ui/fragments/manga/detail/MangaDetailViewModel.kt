package com.example.animeapi.ui.fragments.manga.detail

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.repositories.manga.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val mangaRepository: MangaRepository): BaseViewModel() {

    fun fetchMangaById(id: Int) = mangaRepository.fetchMangaById(id)
}