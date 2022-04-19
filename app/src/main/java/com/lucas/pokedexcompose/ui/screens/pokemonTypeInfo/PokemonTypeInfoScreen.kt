package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.data.models.PokemonTypeInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.*
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonTypeInfoScreen(
    navController: NavController,
    viewModel: PokemonTypeInfoViewModel
) {
    PokeScreen {
        val state by viewModel.uiState.collectAsState()

        ScreenBody(state)
    }
}

@Composable
fun ScreenBody(state: PokemonTypeInfoUiState) {

}


@Composable
@Preview
fun PreviewPokemonTypeInfoScreen() {
    PokedexComposeTheme {
        PokeScreen {
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