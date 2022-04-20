package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.pokedexcompose.ui.theme.PokedexBackground
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokeScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        color = PokedexBackground,
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isLoading) {
            LoadingOverlay()
        } else {
            Box(modifier) {
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