package com.sashi.codechallenge.base

/**
 * Created by Sashi Manandhar on 14/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

sealed class BaseDataState<T> {
    data class Success<T>(val data: T) : BaseDataState<T>()
    data class Error<T>(val message: String, val throwable: Throwable? = null) : BaseDataState<T>()
    object Loading : BaseDataState<Nothing>()
}