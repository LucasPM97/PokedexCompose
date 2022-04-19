package com.lucas.pokedexcompose.data.models

import com.lucas.pokedexcompose.data.remote.responses.TypeInfo

data class PokemonInfoEntry(
    val height: Float,
    val name: String,
    val order: Int,
    val types: List<TypeInfo>,
    val weight: Float
)