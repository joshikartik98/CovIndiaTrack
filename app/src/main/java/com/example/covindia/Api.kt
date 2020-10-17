package com.example.covindia

import com.example.covindia.pojo.StateWiseResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET()
    fun getMovies() : Call<StateWiseResponse>

    companion object {
        var BASE_URL = "https://api.covid19india.org/data.json"
        fun create() : Api {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}