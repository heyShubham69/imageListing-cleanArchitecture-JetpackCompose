package com.example.imagelisting.data.repository

import com.example.imagelisting.data.SearchItem
import com.example.imagelisting.data.itemData
import com.example.imagelisting.data.remote.ApiService
import com.example.imagelisting.di.AppModule
import com.example.imagelisting.domain.model.Item
import com.example.imagelisting.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemRepository {
    override suspend fun getItems(): List<Item> {
        val response = apiService.getItems()
        return if (response.isSuccessful){
            response.body()?.Search ?.map { it.toDomain() } ?: emptyList()
        }else{
            emptyList()
        }
    }

    override suspend fun getDynamicItems(item: String): List<Item> {
        val response = apiService.getDynamicItems(item)
        return if (response.isSuccessful){
            response.body()?.Search ?.map { it.toDomain() } ?: emptyList()
        }else{
            emptyList()
        }    }

    // Map SearchItem to Search
    private fun SearchItem.toDomain(): Item {
        return Item(
            imdbID = imdbID,
            Title = Title,
            Type = Type,
            Poster = Poster,
            Year = Year
        )

    }
}