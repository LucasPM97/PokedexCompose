package com.lucas.pokedexcompose.data.remote.responses

data class PokemonInfo(
    val forms: List<Form>,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val types: List<Type>,
    val weight: Int
)