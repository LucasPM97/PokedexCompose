package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.remote.responses.DamageRelation
import com.lucas.pokedexcompose.data.remote.responses.DamageRelations
import com.lucas.pokedexcompose.ui.composables.CollapsableColumn
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun DamageRelations(
    damageRelations: DamageRelations,
    onPokemonTypePress: (String) -> Unit = {}
) {
    DamageRelationCollapseColumn(
        text = stringResource(R.string.damage_relation_strong_against),
        damageRelations = damageRelations.doubleDamageTo,
        onPokemonTypePress = onPokemonTypePress
    )
    Spacer(modifier = Modifier.height(20.dp))
    DamageRelationCollapseColumn(
        text = stringResource(R.string.damage_relation_weak_against),
        damageRelations = damageRelations.doubleDamageFrom,
        onPokemonTypePress = onPokemonTypePress
    )
}

@Composable
fun DamageRelationCollapseColumn(
    text: String,
    damageRelations: List<DamageRelation>,
    onPokemonTypePress: (String) -> Unit = {}
) {
    CollapsableColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        alwaysDisplayRowContent = {
            Text(text)
        }
    ) {

        DamageRelationGrid(
            damageRelation = damageRelations,
            itemOnPress = onPokemonTypePress
        )
    }
}


@Composable
@Preview
fun PreviewDamageRelations() {
    PokedexComposeTheme {
        Column() {
            DamageRelations(
                DamageRelations(
                    doubleDamageFrom = listOf(
                        DamageRelation(
                            name = "fire"
                        ),
                    ),
                    doubleDamageTo = listOf(
                        DamageRelation(
                            name = "grass"
                        ),
                        DamageRelation(
                            name = "water"
                        )
                    )
                )
            )
        }
    }
}