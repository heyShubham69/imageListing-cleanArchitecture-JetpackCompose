package com.example.imagelisting.data.remote

import com.example.imagelisting.data.ItemDetail
import com.example.imagelisting.data.itemData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //https://www.omdbapi.com/?apikey=e8f8dcfe&s=titanic&page=1
    @GET("/?apikey=e8f8dcfe&s=titanic&page=1")
    suspend fun getItems(): Response<itemData>

    @GET("/?apikey=e8f8dcfe&page=1")
    suspend fun getDynamicItems(
        @Query("s") imdbId: String
    ): Response<itemData>

    @GET("/?apikey=e8f8dcfe")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String
    ): Response<ItemDetail>
}