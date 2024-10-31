package com.example.realviewmodel.store.data.remote

import com.example.realviewmodel.store.domain.model.ProductItem
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts(): List<ProductItem>
}