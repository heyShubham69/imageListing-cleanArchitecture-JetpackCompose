package com.example.imagelisting.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagelisting.domain.model.Item
import com.example.imagelisting.domain.usecase.GetDynamicItemsUseCase
import com.example.imagelisting.domain.usecase.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val getDynamicItemsUseCase: GetDynamicItemsUseCase
):ViewModel() {
    private  val _items = MutableLiveData<List<Item>>(emptyList())
    val items: LiveData<List<Item>> = _items

     val selectedItem = MutableStateFlow<String?>("")

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
    private suspend fun getDynamicItems(item: String) {
//        _items.value = emptyList()
//        _items.value = getDynamicItemsUseCase(item)
    }

    suspend fun setSearchItem(item: String){
        _searchItem.value = item
        getDynamicItems(item)
    }


}