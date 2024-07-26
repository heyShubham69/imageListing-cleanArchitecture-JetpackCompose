package com.example.imagelisting.domain.usecase

import com.example.imagelisting.domain.model.ItemDetailModel
import com.example.imagelisting.domain.repository.ItemRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: ItemRepository) {
    suspend operator fun invoke(imdbId: String): ItemDetailModel? {
        return repository.getMovieDetails(imdbId)
    }
}
