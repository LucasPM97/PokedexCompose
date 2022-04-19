package com.lucas.pokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lucas.pokedexcompose.ui.PokemonInfoViewModelFactory
import com.lucas.pokedexcompose.ui.PokemonTypeInfoViewModelFactory
import com.lucas.pokedexcompose.ui.screens.pokemonInfo.PokemonInfoScreen
import com.lucas.pokedexcompose.ui.screens.pokemonList.PokemonListScreen
import com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo.PokemonTypeInfoScreen
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.Constans
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonInfoScreenName
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonListScreenName
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonInfoArguments
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonTypeInfoScreenName
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonTypeInfoArguments

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PokemonListScreenName
    ) {
        composable(PokemonListScreenName) {
            PokemonListScreen(navController = navController)
        }
        composable("$PokemonInfoScreenName/" +
                "{${PokemonInfoArguments.PokemonName}}/" +
                "{${PokemonInfoArguments.PokemonNumber}}",
            arguments = listOf(
                navArgument(PokemonInfoArguments.PokemonName) {
                    type = NavType.StringType
                },
                navArgument(PokemonInfoArguments.PokemonNumber) {
                    type = NavType.IntType
                }
            )) {

            val pokemonNumber = remember {
                it.arguments?.getInt(PokemonInfoArguments.PokemonNumber)
            }

            val pokemonName = remember {
                it.arguments?.getString(PokemonInfoArguments.PokemonName)
            }

            PokemonInfoScreen(
                navController = navController,
                viewModel = viewModel(
                    factory = PokemonInfoViewModelFactory(
                        pokemonNumber = pokemonNumber ?: 1,
                        pokemonName = pokemonName ?: "Dummy"
                    )
                )
            )
        }
        composable("$PokemonTypeInfoScreenName/{${PokemonTypeInfoArguments.PokemonTypeName}}",
            arguments = listOf(
                navArgument(PokemonTypeInfoArguments.PokemonTypeName) {
                    type = NavType.StringType
                }
            )) {

            val pokemonTypeName = remember {
                it.arguments?.getString(PokemonTypeInfoArguments.PokemonTypeName)
            }

            PokemonTypeInfoScreen(
                navController = navController,
                viewModel = viewModel(
                    factory = PokemonTypeInfoViewModelFactory(
                        pokemonTypeName = pokemonTypeName ?: "Dummy"
                    )
                )
            )
        }
    }
}