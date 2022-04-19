package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.data.models.PokemonTypeInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.DamageRelation
import com.lucas.pokedexcompose.data.remote.responses.DamageRelations
import com.lucas.pokedexcompose.ui.composables.PokeCardBox
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.composables.PokemonTypeBox
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonTypeInfoScreen(
    navController: NavController,
    viewModel: PokemonTypeInfoViewModel
) {
    PokeScreen(
        modifier = Modifier.padding(10.dp)
    ) {
        val state by viewModel.uiState.collectAsState()

        ScreenBody(state)
    }
}

@Composable
fun ScreenBody(state: PokemonTypeInfoUiState) {
    PokeCardBox(
        modifier = Modifier.padding(20.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(30.dp))
            PokemonTypeBox(
                typeName = state.pokemonTypeName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            state.pokemonTypeInfo?.let {

                DamageRelationGrid(
                    "Strong against:",
                    it.damageRelations.doubleDamageTo
                )
                Spacer(modifier = Modifier.height(20.dp))
                DamageRelationGrid(
                    "Weak against:",
                    it.damageRelations.doubleDamageFrom
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}


@Composable
@Preview
fun PreviewPokemonTypeInfoScreen() {
    PokedexComposeTheme {
        PokeScreen(
            modifier = Modifier.padding(20.dp)
        ) {
            ScreenBody(
                state = PokemonTypeInfoUiState(
                    pokemonTypeName = "Fire",
                    pokemonTypeInfo = PokemonTypeInfoEntry(
                        damageRelations = DamageRelations(
                            doubleDamageFrom = listOf(
                                DamageRelation(
                                    "water"
                                )
                            ),
                            doubleDamageTo = listOf(
                                DamageRelation(
                                    "grass"
                                ),
                                DamageRelation(
                                    "ice"
                                )
                            )
                        ),
                        name = "Fire",
                        pokemons = listOf(
                            PokemonListEntry(
                                "Charizard",
                                7
                            )
                        )
                    )
                )
            )
        }
    }
}