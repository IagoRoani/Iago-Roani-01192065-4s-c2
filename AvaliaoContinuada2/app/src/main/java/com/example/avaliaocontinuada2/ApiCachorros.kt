package com.example.avaliaocontinuada2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCachorros {

    @GET("filmes/{id}")
    fun get(@Path("id") id:Int): Call<Cachorro>

}