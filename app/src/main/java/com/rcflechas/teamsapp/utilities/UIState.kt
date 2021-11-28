package com.rcflechas.teamsapp.utilities

sealed class UIState<out T>  {
    class OnLoading(val loading: Boolean): UIState<Nothing>()
    class OnSuccess<T> (val data: T): UIState<T>()
    class OnError(val error: String): UIState<Nothing>()
}