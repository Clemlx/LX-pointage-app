package com.lxcommissioning.app.util

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception, val message: String = exception.message ?: "Unknown error") : Result<Nothing>()
    object Loading : Result<Nothing>()
}

fun <T> Result<T>.getOrNull(): T? = when (this) {
    is Result.Success -> data
    else -> null
}

fun <T> Result<T>.getErrorOrNull(): Exception? = when (this) {
    is Result.Error -> exception
    else -> null
}
