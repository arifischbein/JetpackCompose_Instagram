package com.example.jetpackcomposeinstagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    /**
     * Esto es porque todavia no hay inyeccion de dependencias.
     * Luego debe ser proveido directamente en el service
     */
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
