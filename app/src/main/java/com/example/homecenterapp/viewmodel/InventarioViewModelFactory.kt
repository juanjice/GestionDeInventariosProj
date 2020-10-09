package com.example.homecenterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homecenterapp.domain.ItemUseCase


class InventarioViewModelFactory(val itemUseCase: ItemUseCase):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ItemUseCase::class.java).newInstance(itemUseCase)
    }
}