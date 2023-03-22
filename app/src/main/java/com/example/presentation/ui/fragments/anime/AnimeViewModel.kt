package com.example.presentation.ui.fragments.anime

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.animeapi.domain.models.DataItem
import com.example.animeapi.domain.usecases.anime.FetchAnimeUseCase
import com.example.animeapi.domain.utils.Either
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
class AnimeViewModel @Inject constructor(
    private val fetchAnimeUseCase: FetchAnimeUseCase,
    private val saveStateHandle: SavedStateHandle,
    ) :
    BaseViewModel() {

    private val _countriesState =
        MutableStateFlow<UIState<List<DataItem>>>(UIState.Loading())
    val countriesState = _countriesState.asStateFlow()

    private val searchAnimeByFilter: StateFlow<String> = saveStateHandle.getStateFlow("text", "")

    init {
        fetchAnimeById()
    }

    private fun fetchAnimeById() {
        viewModelScope.launch {
            searchAnimeByFilter.flatMapLatest { filter ->
                fetchAnimeUseCase()
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