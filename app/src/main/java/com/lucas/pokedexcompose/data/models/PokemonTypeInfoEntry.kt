package com.lucas.pokedexcompose.data.models

import com.lucas.pokedexcompose.data.remote.responses.DamageRelations

data class PokemonTypeInfoEntry(
    val damageRelations: DamageRelations,
    val name: String,
    val pokemons: List<PokemonListEntry>
)
