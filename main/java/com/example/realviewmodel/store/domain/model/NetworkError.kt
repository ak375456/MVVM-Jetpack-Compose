package com.example.realviewmodel.store.domain.model

data class NetworkError (
    val error: ApiError,
    val t:Throwable? = null
)

enum class ApiError(val message:String) {
    NetworkError("Network Error"),
    UnKnownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}