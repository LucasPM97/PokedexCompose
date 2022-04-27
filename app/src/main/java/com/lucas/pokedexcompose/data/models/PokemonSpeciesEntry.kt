package com.lucas.pokedexcompose.data.models

data class PokemonSpeciesEntry(
    val description: String,
    val evolvesFromName: String?,
    val evolvesFromNumber: Int?,
    val habitatName: String?,
    val captureRate: Int,
    val hasGenderDifferences: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean
)