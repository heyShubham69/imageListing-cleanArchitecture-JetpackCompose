package com.example.imagelisting.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagelisting.domain.model.Item
import com.example.imagelisting.domain.model.ItemDetailModel
import com.example.imagelisting.domain.usecase.GetDynamicItemsUseCase
import com.example.imagelisting.domain.usecase.GetItemsUseCase
import com.example.imagelisting.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val getDynamicItemsUseCase: GetDynamicItemsUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
):ViewModel() {
    private  val _items = MutableLiveData<List<Item>>(emptyList())
    val items: LiveData<List<Item>> = _items


    private val _selectedItem = MutableLiveData<ItemDetailModel?>()
    val selectedItem: LiveData<ItemDetailModel?> = _selectedItem


    private val _searchItem = MutableStateFlow<String?>("")
    val searchItem = _searchItem

    init {
        viewModelScope.launch {
            getItems()
        }
    }
    private suspend fun getItems() {
        _items.value = getItemsUseCase()
    }

    fun fetchMovieDetails(imdbId: String) {
        viewModelScope.launch {
            _selectedItem.value = getMovieDetailsUseCase(imdbId)
        }
    }
    suspend fun getDynamicItems(item: String) {
        viewModelScope.launch {
            _items.value = getDynamicItemsUseCase(item)
        }
    }

}