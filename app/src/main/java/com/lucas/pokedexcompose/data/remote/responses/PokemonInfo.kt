package com.lucas.pokedexcompose.data.remote.responses

data class PokemonInfo(
    val height: Int,
    val forms: List<Form>,
    val name: String,
    val sprites: Sprites,
    val types: List<Type>,
    val weight: Int
)