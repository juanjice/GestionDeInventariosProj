package com.example.homecenterapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homecenterapp.data.repository.extension.toItems
import com.example.homecenterapp.domain.ItemUseCase
import com.example.homecenterapp.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ItemViewModel(
    private val itemUseCase: ItemUseCase
) : ViewModel(), CoroutineScope {

    private val listData = MutableLiveData<List<Item>>()

    override val coroutineContext: CoroutineContext
        get() = Job()

    fun setListData(items: List<Item>) {
        listData.postValue(items)
    }

    fun getItems() {
        itemUseCase.getInventarioListMock()?.let {
            setListData(it.toItems())
        }
        /*launch {
            try {
                val response = itemUseCase.getInventarioList()?.await()?.toItems()
                if (response != null) {
                    setListData(response)
                } else {
                    setListData(listOf())
                }
            } catch (e: Exception) {
                setListData(listOf())
            }
        }*/
    }

    fun getItemsLiveData(): LiveData<List<Item>> {
        return listData
    }

}