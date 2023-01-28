package com.eritlab.jexmon.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>() : Resource<T>()
    class Success<T>(data: T? = null) : Resource<T>(data = data)
    class Error<T>(message: String? = null) : Resource<T>(message = message)
}