package com.lucas.pokedexcompose.data.remote.responses

data class PokemonTypeInfo(
    val damage_relations: DamageRelations,
    val id: Int,
    val name: String,
    val pokemon: List<PokemonTypePokemonItem>
)