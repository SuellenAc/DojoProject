package br.com.dojo.project.model

sealed class AppResult<out D, out E> {
    data class Success<D>(val value: D) : AppResult<D, Nothing>()
    data class Error<E>(val value: E) : AppResult<Nothing, E>()
}