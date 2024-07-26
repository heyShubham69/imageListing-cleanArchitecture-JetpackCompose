package com.example.imagelisting.domain.repository

import com.example.imagelisting.domain.model.Item

interface ItemRepository {
    suspend fun getItems():List<Item>
    suspend fun getDynamicItems(item: String):List<Item>
}