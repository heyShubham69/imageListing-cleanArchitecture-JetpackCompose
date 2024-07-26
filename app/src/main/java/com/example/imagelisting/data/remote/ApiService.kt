package com.example.imagelisting.data.remote

import com.example.imagelisting.data.itemData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    //https://www.omdbapi.com/?apikey=e8f8dcfe&s=titanic&page=1
    @GET("/?apikey=e8f8dcfe&s=titanic&page=1")
    suspend fun getItems(): Response<itemData>

    @GET("/?apikey=e8f8dcfe&s={movieName}&page=1")
    suspend fun getDynamicItems(
        @Path(value = "movieName") item: String
    ): Response<itemData>
}