package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.remote.responses.DamageRelations

@Composable
fun DamageRelations(
    damageRelations: DamageRelations,
    onPokemonTypePress: (String) -> Unit = {}
) {
    DamageRelationGrid(
        text = stringResource(R.string.damage_relation_strong_against),
        damageRelation = damageRelations.doubleDamageTo,
        itemOnPress = onPokemonTypePress
    )
    Spacer(modifier = Modifier.height(20.dp))
    DamageRelationGrid(
        text = stringResource(R.string.damage_relation_weak_against),
        damageRelation = damageRelations.doubleDamageFrom,
        itemOnPress = onPokemonTypePress
    )
}