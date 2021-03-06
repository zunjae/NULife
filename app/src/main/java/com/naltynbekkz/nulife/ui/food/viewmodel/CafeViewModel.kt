package com.naltynbekkz.nulife.ui.food.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.naltynbekkz.nulife.di.ViewModelAssistedFactory
import com.naltynbekkz.nulife.repository.CafesRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class CafeViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val cafesRepository: CafesRepository
) : ViewModel() {

    val cafeId: String = savedStateHandle["cafe_id"]!!

    @AssistedInject.Factory
    interface Factory : ViewModelAssistedFactory<CafeViewModel>

    val cafe = cafesRepository.getCafe(cafeId)


    fun getFeatured(mealId: String) = cafesRepository.getFeatured(cafeId, mealId)
}