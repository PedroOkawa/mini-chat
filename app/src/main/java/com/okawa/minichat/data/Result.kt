package com.okawa.minichat.data

data class Result<T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?) = Result(Status.SUCCESS, data, null)

        fun <T> error(message: String?, data: T?) = Result(Status.ERROR, data, message)

        fun <T> loading(data: T?) = Result(Status.LOADING, data, null)

    }

}