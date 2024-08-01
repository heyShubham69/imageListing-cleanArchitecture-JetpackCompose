package com.example.imagelisting.data.repository

import com.example.imagelisting.data.ItemDetail
import com.example.imagelisting.data.SearchItem
import com.example.imagelisting.data.remote.ApiService
import com.example.imagelisting.domain.model.Item
import com.example.imagelisting.domain.model.ItemDetailModel
import com.example.imagelisting.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemRepository {
    override suspend fun getDynamicItems(item: String): List<Item> {
        val response = apiService.getDynamicItems(item)
        return if (response.isSuccessful){
            response.body()?.Search ?.map { it.toDomain() } ?: emptyList()
        }else{
            emptyList()
        }    }

    override suspend fun getMovieDetails(imdbId: String): ItemDetailModel? {
        val response = apiService.getMovieDetails( imdbId)
        return if (response.isSuccessful) {
            response.body()?.toDomain()
        } else {
            null
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
    private fun ItemDetail.toDomain():ItemDetailModel{
        return ItemDetailModel(
            imdbID = imdbID,
            Title = Title,
            Type = Type,
            Poster = Poster,
            Year = Year,
        )
    }
}