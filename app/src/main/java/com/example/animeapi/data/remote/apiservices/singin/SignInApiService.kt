package com.example.animeapi.data.remote.apiservices.singin

import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun fetchSingIn(
        @Body authModel: AuthModel
    ): TokenModel
}
