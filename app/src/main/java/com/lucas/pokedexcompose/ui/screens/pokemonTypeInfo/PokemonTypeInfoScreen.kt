package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.data.models.PokemonTypeInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.DamageRelation
import com.lucas.pokedexcompose.data.remote.responses.DamageRelations
import com.lucas.pokedexcompose.ui.navigateToPokemonInfoScreen
import com.lucas.pokedexcompose.ui.navigateToPokemonTypeInfoScreen
import com.lucas.pokedexcompose.ui.composables.PokeCardBox
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.composables.PokemonGridList
import com.lucas.pokedexcompose.ui.composables.PokemonTypeBox
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonTypeInfoScreen(
    navController: NavController,
    viewModel: PokemonTypeInfoViewModel
) {
    val state by viewModel.uiState.collectAsState()
    PokeScreen(
        isLoading = state.loading,
        navController = navController
    ) {

        ScreenBody(state, navController)
    }
}

@Composable
fun ScreenBody(
    state: PokemonTypeInfoUiState,
    navController: NavController? = null
) {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp)
            .padding(top = 10.dp)
    ) {
        PokeCardBox {
            Column {
                Spacer(modifier = Modifier.height(30.dp))
                PokemonTypeBox(
                    typeName = state.pokemonTypeName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontSize = 18.sp
                )
                state.pokemonTypeInfo?.let {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        DamageRelations(it.damageRelations) {
                            navController?.navigateToPokemonTypeInfoScreen(
                                it
                            )
                        }
                    }
                }
            }
        }
        state.pokemonTypeInfo?.let {
            Spacer(modifier = Modifier.height(5.dp))
            PokemonGridList(
                pokemonList = it.pokemons,
                itemOnClick = { pokemon ->
                    navController?.navigateToPokemonInfoScreen(
                        pokemon.pokemonName,
                        pokemon.number
                    )
                }
            )
        }
    }
}

val MockStateSucceeded = PokemonTypeInfoUiState(
    pokemonTypeName = "Fire",
    pokemonTypeInfo = PokemonTypeInfoEntry(
        damageRelations = DamageRelations(
            doubleDamageFrom = listOf(
                DamageRelation(
                    "water"
                ),
                DamageRelation(
                    "psychic"
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
                "Charmander",
                7
            ),
            PokemonListEntry(
                "Charizard",
                9
            )
        )
    )
)

@Composable
@Preview
fun PreviewPokemonTypeInfoScreenSucceeded() {
    PokedexComposeTheme {
        PokeScreen {
            ScreenBody(
                state = MockStateSucceeded
            )
        }
    }
}