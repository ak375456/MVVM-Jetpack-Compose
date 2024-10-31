package com.example.realviewmodel.store.presentation.products_screen

import com.example.realviewmodel.store.domain.model.ProductItem

data class ProductViewState(
    val isLoading:Boolean = false,
    val products: List<ProductItem> = emptyList(),
    val error:String? = null
)
