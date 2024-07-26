package com.example.imagelisting.domain.usecase

import com.example.imagelisting.domain.model.Item
import com.example.imagelisting.domain.repository.ItemRepository
import javax.inject.Inject

class GetDynamicItemsUseCase  @Inject constructor(private val repository: ItemRepository)
{
    suspend operator fun invoke(item:String):List<Item> {
        return repository.getDynamicItems(item)
    }
}