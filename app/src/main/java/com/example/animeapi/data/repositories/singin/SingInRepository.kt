package com.example.animeapi.data.repositories.singin

import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.remote.apiservices.singin.SignInApiService
import javax.inject.Inject

class SingInRepository @Inject constructor(
    private val apiService: SignInApiService
): BaseRepository() {

    fun fetchSingIn(authModel: AuthModel) = doRequest {
        apiService.fetchSingIn(authModel)
    }
}