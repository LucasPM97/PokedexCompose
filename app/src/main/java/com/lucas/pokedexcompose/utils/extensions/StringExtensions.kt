package com.lucas.pokedexcompose.utils.extensions

fun String.removeEndLineEntries(): String {
    return this.replace("\\n".toRegex(), " ")
        .replace("\\r".toRegex(), " ")
        .replace("\\f".toRegex(), " ")
}

fun String.getPokemonNumberFromUrl(): Int {
    val number = if (this.endsWith("/")) {
        this.dropLast(1).takeLastWhile { it.isDigit() }
    } else {
        this.takeLastWhile { it.isDigit() }
    }

    return number.toInt()
}