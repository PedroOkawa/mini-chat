package com.okawa.minichat.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class DataHandler<T> constructor(
        private val appExecutors: AppExecutors
) {

    init {
        requestData()
    }

    abstract fun requestFromNetwork(): Boolean

    abstract fun requestToExecute(): Call<T>

    abstract fun onError()

    abstract fun onSuccess(t: T)

    private fun requestData() {
        appExecutors.getDiskIO().execute {
            if(requestFromNetwork()) {
                requestToExecute().enqueue(object : Callback<T> {
                    override fun onFailure(call: Call<T>?, t: Throwable?) {
                        onError()
                    }

                    override fun onResponse(call: Call<T>?, response: Response<T>?) {
                        response ?: return onError()
                        response.body() ?: return onError()

                        appExecutors.getDiskIO().execute {
                            onSuccess(response.body()!!)
                        }
                    }
                })
            }
        }
    }

}