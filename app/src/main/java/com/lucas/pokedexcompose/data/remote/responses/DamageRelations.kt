package com.lucas.pokedexcompose.data.remote.responses

import com.google.gson.annotations.SerializedName

data class DamageRelations(
    @SerializedName("double_damage_from") val doubleDamageFrom: List<DamageRelation>,
    @SerializedName("double_damage_to") val doubleDamageTo: List<DamageRelation>
)