package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/d4cb44c1-82fa-4100-95a3-e2524f16bfad")
    suspend fun doLogin(): Response<LoginResponse>
}
