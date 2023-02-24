package com.example.animeapi.ui.fragments.manga

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.repositories.manga.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val mangaRepository: MangaRepository) :
    BaseViewModel() {

    fun fetchManga() = mangaRepository.fetchManga().cachedIn(viewModelScope)
}
