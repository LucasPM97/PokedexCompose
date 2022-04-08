package com.lucas.pokedexcompose.data.remote.responses

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val result: List<PokemonItem>
)