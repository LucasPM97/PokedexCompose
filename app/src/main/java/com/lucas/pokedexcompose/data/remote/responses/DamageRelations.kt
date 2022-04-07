package com.lucas.pokedexcompose.data.remote.responses

data class DamageRelations(
    val double_damage_from: List<DoubleDamageFrom>,
    val double_damage_to: List<DoubleDamageTo>
)