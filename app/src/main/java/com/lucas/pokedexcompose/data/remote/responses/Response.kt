package com.lucas.pokedexcompose.data.remote.responses

sealed class Response<T>(val data: T?, val message: String? = null) {

    class Success<T>(data: T) : Response<T>(data)
    class Error<T>(message: String?, data: T? = null) : Response<T>(data, message)
}