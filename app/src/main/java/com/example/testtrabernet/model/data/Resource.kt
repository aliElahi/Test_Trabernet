package com.example.testtrabernet.model.data

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?, message: String? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> error(message: String?, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

    }

}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
