package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.ui.composables.navigation.BottomBar
import com.lucas.pokedexcompose.ui.theme.PokedexBackground
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokeScreen(
    isLoading: Boolean = false,
    navController: NavController? = null,
    bottomBarContent: @Composable RowScope.() -> Unit = {
        Spacer(modifier = Modifier.width(1.dp))
    },
    content: @Composable BoxScope.() -> Unit,
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController) {
                bottomBarContent()
            }
        }
    ) {
        Surface(
            color = PokedexBackground,
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (isLoading) {
                LoadingOverlay()
                return@Surface
            }

            Box(Modifier.padding(it)) {
                content()
            }
        }
    }
}

@Composable
private fun LoadingOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xE6A8A77A)
            )
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Loading")
        }
    }
}

@Composable
@Preview
fun PreviewPokeScreen() {
    PokedexComposeTheme {
        PokeScreen {

        }
    }
}

@Composable
@Preview
fun PreviewPokeScreenLoading() {
    PokedexComposeTheme {
        PokeScreen(
            isLoading = true
        ) {

        }
    }
}