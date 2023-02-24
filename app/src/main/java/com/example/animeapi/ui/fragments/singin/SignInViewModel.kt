package com.example.animeapi.ui.fragments.singin

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.repositories.singin.SingInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: SingInRepository
): BaseViewModel() {

    fun fetchSingIn(authModel: AuthModel) = repository.fetchSingIn(authModel)
}
