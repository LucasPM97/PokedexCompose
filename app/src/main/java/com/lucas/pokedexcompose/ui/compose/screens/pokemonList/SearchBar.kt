package com.lucas.pokedexcompose.ui.compose.screens.pokemonList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonBackground
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonStroke

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    val shape = MaterialTheme.shapes.small

    Box(
        modifier = modifier
            .background(
                PokedexPokemonBackground,
                shape
            )
            .border(
                BorderStroke(5.dp, PokedexPokemonStroke),
                shape
            )
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {

        Input(
            text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            onFocusChanged = {
                isHintDisplayed = !it.isFocused
            }
        )

        if (isHintDisplayed) {
            Hint(
                text = hint
            )
        }
    }
}

@Composable
private fun Input(
    text: String,
    onValueChange: (String) -> Unit = {},
    onFocusChanged: (FocusState) -> Unit = {}
) {
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                onFocusChanged(it)
            }
    )
}

@Composable
private fun Hint(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        color = Color.LightGray
    )
}

@Composable
@Preview
fun PreviewSearchBar() {
    PokedexComposeTheme {
        SearchBar(
            hint = "Search"
        )
    }
}