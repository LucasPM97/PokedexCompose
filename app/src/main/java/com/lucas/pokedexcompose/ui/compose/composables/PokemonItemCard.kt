package com.lucas.pokedexcompose.ui.compose.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.remote.responses.PokemonItem
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonBackground
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonStroke

@Composable
fun PokemonItemCard(
    pokemonItem: PokemonItem,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(10)

    Column(
        modifier = modifier
            .background(
                PokedexPokemonBackground,
                shape
            )
            .border(
                BorderStroke(5.dp, PokedexPokemonStroke),
                shape
            )
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PokemonImage(
            Modifier
                .size(120.dp)
        )
        Text(
            text = pokemonItem.name
        )
    }
}

@Composable
fun PokemonImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center

    ) {
        val pokemonPainter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png")
                .crossfade(true)
                .build()
        )

        if (pokemonPainter.state is AsyncImagePainter.State.Loading ||
            pokemonPainter.state is AsyncImagePainter.State.Error
        ) {
            Image(
                painter = painterResource(id = R.drawable.gray_pokeball),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
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
fun PreviewPokemonItemCard() {
    PokedexComposeTheme {
        PokemonItemCard(
            pokemonItem = PokemonItem(
                name = "Pokemon",
            ),
            modifier = Modifier
                .size(120.dp)

        )
    }
}