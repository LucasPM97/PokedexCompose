package com.lucas.pokedexcompose.utils.extensions

fun String.removeEndLineEntries(): String {
    return this.replace("\\n".toRegex(), " ")
        .replace("\\r".toRegex(), " ")
        .replace("\\f".toRegex(), " ")
}