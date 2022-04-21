package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.remote.responses.DamageRelation
import com.lucas.pokedexcompose.data.remote.responses.DamageRelations
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
    var visible by remember {
        mutableStateOf(false)
    }

    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                visible = !visible
            }
            .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            Icon(
                if (visible) Icons.Filled.ExpandLess
                else Icons.Filled.ExpandMore,
                contentDescription = "Localized description"
            )
        }

        val density = LocalDensity.current

        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            DamageRelationGrid(
                damageRelation = damageRelations,
                itemOnPress = onPokemonTypePress
            )
        }
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