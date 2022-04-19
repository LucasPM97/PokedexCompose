package com.lucas.pokedexcompose.data.remote.responses

import com.google.gson.annotations.SerializedName

data class PokemonTypeInfo(
    @SerializedName("damage_relations") val damageRelations: DamageRelations,
    val id: Int,
    val name: String,
    val pokemon: List<PokemonTypePokemonItem>
)