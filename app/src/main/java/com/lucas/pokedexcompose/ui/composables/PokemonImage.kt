package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonImage(
    pokemonId: Int,
    imageSize: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(imageSize.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center,

    ) {
        val pokemonPainter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png")
                .crossfade(true)
                .build()
        )

        if (pokemonPainter.state is AsyncImagePainter.State.Loading ||
            pokemonPainter.state is AsyncImagePainter.State.Error
        ) {
            Image(
                painter = painterResource(id = R.drawable.gray_pokeball),
                contentDescription = "",
                modifier = Modifier.size(
                    (imageSize / 3).dp
                )
            )
            Spacer(
                modifier = Modifier.height(
                    (imageSize / (imageSize / 10)).dp
                )
            )
        }
        Image(
            painter = pokemonPainter,
            modifier = Modifier.fillMaxSize(),
            contentDescription = ""
        )
    }
}

@Composable
@Preview
fun PreviewPokemonImage() {
    PokedexComposeTheme {
        PokemonImage(
            pokemonId = 4,
            imageSize = 40
        )
    }
}