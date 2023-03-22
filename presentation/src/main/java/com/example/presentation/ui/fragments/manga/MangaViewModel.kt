package com.example.presentation.ui.fragments.manga

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DataItem
import com.example.domain.usecases.manga.FetchMangaUseCase
import com.example.domain.utils.Either
import com.example.presentation.base.BaseViewModel
import com.example.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val fetchMangaUseCase: FetchMangaUseCase,
    private val saveStateHandle: SavedStateHandle,
) :
    BaseViewModel() {

    private val _countriesState =
        MutableStateFlow<UIState<List<DataItem>>>(UIState.Loading())
    val countriesState = _countriesState.asStateFlow()

    private val searchMangaByFilter: StateFlow<String> = saveStateHandle.getStateFlow("text", "")

    init {
        fetchAnimeById()
    }

    private fun fetchAnimeById() {
        viewModelScope.launch {
            searchMangaByFilter.flatMapLatest { filter ->
                fetchMangaUseCase()
            }.collect { it ->
                when (it) {
                    is Either.Left -> {
                        it.message?.let {
                            _countriesState.value = UIState.Error(it)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {
                            _countriesState.value = UIState.Success(it)
                        }
                    }
                }
            }
        }
    }
}