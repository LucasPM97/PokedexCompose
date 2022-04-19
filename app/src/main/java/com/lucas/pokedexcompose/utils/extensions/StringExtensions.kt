package com.lucas.pokedexcompose.utils.extensions

fun String.removeEndLineEntries(): String {
    val fEntry = "\n".replace("n", "f")
    return this.replace("\n", "")
        .replace("\r", "")
        .replace(fEntry, "")
}