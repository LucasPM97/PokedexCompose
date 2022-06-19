package com.lucas.pokedexcompose.utils.extensions

fun Int.threeDigitsString(): String {
    return if (this >= 100) {
        this.toString()
    } else if (this >= 10) {
        "0$this"
    } else {
        "00$this"
    }
}