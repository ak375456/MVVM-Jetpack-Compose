package com.example.realviewmodel.store.data.mapper

import com.example.realviewmodel.store.domain.model.ApiError
import com.example.realviewmodel.store.domain.model.NetworkError
import okio.IOException
import retrofit2.HttpException

fun Throwable.toNetworkError() :NetworkError {
    val error = when(this){
        is IOException-> ApiError.NetworkError
        is HttpException->ApiError.UnKnownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )

}