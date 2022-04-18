package com.lucas.pokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucas.pokedexcompose.ui.pokemonList.PokemonListScreen
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonListScreenName

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
    }
}