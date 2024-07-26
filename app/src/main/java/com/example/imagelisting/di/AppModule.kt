package com.example.imagelisting.di

import com.example.imagelisting.data.remote.ApiService
import com.example.imagelisting.data.repository.ItemRepositoryImpl
import com.example.imagelisting.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
        .baseUrl("https://www.omdbapi.com")
            .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideItemRepository(apiService: ApiService): ItemRepository {
        return ItemRepositoryImpl(apiService)
    }

}