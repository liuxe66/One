package com.example.one.data.remote

/**
 * desc  : 处理成功或者失败的情况
 */

sealed class OneResult<out T> {
    data class Success<out T>(val value: T) : OneResult<T>()

    data class Failure(val throwable: Throwable?) : OneResult<Nothing>()
}

inline fun <reified T> OneResult<T>.doSuccess(success: (T) -> Unit) {
    if (this is OneResult.Success) {
        success(value)
    }
}

inline fun <reified T> OneResult<T>.doFailure(failure: (Throwable?) -> Unit) {
    if (this is OneResult.Failure) {
        failure(throwable)
    }
}
