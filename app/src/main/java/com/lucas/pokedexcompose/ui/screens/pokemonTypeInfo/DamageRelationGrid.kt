package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.pokedexcompose.data.remote.responses.DamageRelation
import com.lucas.pokedexcompose.ui.composables.PokemonTypeBox
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DamageRelationGrid(
    text: String,
    damageRelation: List<DamageRelation>,
    itemOnPress: (String) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text)
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            items(damageRelation.size) { index ->
                val pokemonTypeName = damageRelation[index].name
                PokemonTypeBox(
                    pokemonTypeName,
                    modifier = Modifier
                        .clickable {
                            itemOnPress(pokemonTypeName)
                        }
                        .padding(10.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewDamageRelationGrid() {
    PokedexComposeTheme {
        DamageRelationGrid(
            text = "Title",
            damageRelation = listOf(
                DamageRelation(
                    "grass"
                ),
                DamageRelation(
                    "ice"
                ),
                DamageRelation(
                    "steel"
                )
            )
        )
    }
}