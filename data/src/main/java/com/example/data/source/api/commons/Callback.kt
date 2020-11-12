package com.example.data.source.api.commons

import io.reactivex.rxjava3.core.CompletableEmitter
import io.reactivex.rxjava3.core.SingleEmitter
import retrofit2.Call

import retrofit2.Response
import java.net.HttpURLConnection

interface Callback<T>: retrofit2.Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val responseBody = response.body()

        if (response.isSuccessful) {
            if (responseBody != null) {
                onResponseSuccess(call, responseBody)
            } else {
                onResponseError(call, HttpURLConnection.HTTP_INTERNAL_ERROR)
            }
        } else {
            onResponseError(call, response.code())
        }
    }

    fun onResponseSuccess(call: Call<T>, data: T)

    fun onResponseError(call: Call<T>, errorCode: Int)

}

class SingleCallback<T>(private val emitter: SingleEmitter<T>) :
    Callback<T> {

    override fun onResponseSuccess(call: Call<T>, data: T) {
        emitter.onSuccess(data)
    }

    override fun onResponseError(call: Call<T>, errorCode: Int) {
        if (!emitter.isDisposed) {
            emitter.onError(Exception("Error code $errorCode"))
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (!emitter.isDisposed) {
            emitter.onError(t)
        }
    }
}

class CompletableCallback(private val emitter: CompletableEmitter) :
    Callback<Any> {

    override fun onResponseSuccess(call: Call<Any>, data: Any) {
        emitter.onComplete()
    }

    override fun onResponseError(call: Call<Any>, errorCode: Int) {
        if (!emitter.isDisposed) {
            emitter.onError(Exception("Error code $errorCode"))
        }
    }

    override fun onFailure(call: Call<Any>, t: Throwable) {
        if (!emitter.isDisposed) {
            emitter.onError(t)
        }
    }
}

