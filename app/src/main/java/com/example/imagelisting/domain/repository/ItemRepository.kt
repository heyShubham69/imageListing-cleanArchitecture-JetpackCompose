package com.example.imagelisting.domain.repository

import com.example.imagelisting.data.ItemDetail
import com.example.imagelisting.domain.model.Item
import com.example.imagelisting.domain.model.ItemDetailModel

interface ItemRepository {
    suspend fun getDynamicItems(item: String):List<Item>

    suspend fun getMovieDetails(imdbId: String): ItemDetailModel?
}