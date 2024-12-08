package com.example.myapplication.utils

import javax.annotation.concurrent.Immutable

/*
data class UiState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val reason: String? = null
) {
    companion object {
        fun <T> idle(): UiState<T> = UiState()
        fun <T> loading(): UiState<T> = UiState(isLoading = true)
        fun <T> success(data: T?): UiState<T?> = UiState(data = data)
        fun <T> empty(): UiState<T> = UiState()
        fun <T> failure(reason: String): UiState<T> = UiState(reason = reason)
    }
}*/

@Immutable
sealed class UiState<out T> {
    data object Idle : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T?) : UiState<T>()
    data object Empty : UiState<Nothing>()
    data class Error(val message: String?) : UiState<Nothing>()

}
