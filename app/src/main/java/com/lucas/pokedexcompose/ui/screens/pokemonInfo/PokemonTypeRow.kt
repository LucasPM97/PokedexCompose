package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.composables.PokemonTypeBox
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonTypeRow(
    types: List<TypeInfo>,
    itemOnClick: (String) -> Unit = {}
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        types.forEachIndexed { index, type ->

            PokemonTypeBox(
                type.name,
                modifier = Modifier
                    .clickable {
                        itemOnClick(type.name)
                    }
                    .padding(10.dp)
            )

            if (types.size > 1 && index != types.lastIndex) {
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewPokemonTypeRow() {
    PokedexComposeTheme {
        PokemonTypeRow(
            types = listOf(
                TypeInfo(
                    name = "fire",
                    ""
                ),
                TypeInfo(
                    name = "flying",
                    ""
                ),
            )
        )
    }
}