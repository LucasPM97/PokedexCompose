package com.lucas.pokedexcompose.ui.pokemonInfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo

@Composable
fun PokemonTypeData(types: List<TypeInfo>) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        types.forEachIndexed { index, type ->
            Text(text = type.name)
            if (types.size > 1 && index != types.lastIndex) {
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}