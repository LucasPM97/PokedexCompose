package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.pokedexcompose.data.remote.responses.DamageRelation
import com.lucas.pokedexcompose.ui.composables.PokemonTypeBox
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.extensions.WindowSize
import com.lucas.pokedexcompose.utils.extensions.windowSize
import kotlin.math.roundToInt

const val GRID_CELL_HEIGHT = 30
const val GRID_CELL_SPACE = 5

@Composable
fun DamageRelationGrid(
    damageRelation: List<DamageRelation>,
    itemOnPress: (String) -> Unit = {}
) {
    BoxWithConstraints() {
        val gridListHeight = gridListHeight(damageRelation.size, windowSize())

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            Modifier
                .fillMaxWidth()
                .height(gridListHeight.dp),
            horizontalArrangement = Arrangement.spacedBy(GRID_CELL_SPACE.dp),
            verticalArrangement = Arrangement.spacedBy(GRID_CELL_SPACE.dp),
        ) {
            items(damageRelation.size) { index ->
                val pokemonTypeName = damageRelation[index].name
                PokemonTypeBox(
                    pokemonTypeName,
                    modifier = Modifier
                        .height(GRID_CELL_HEIGHT.dp)
                        .clickable {
                            itemOnPress(pokemonTypeName)
                        },
                    fontSize = 14.sp
                )
            }
        }
    }

}

private fun gridListHeight(listSize: Int, windowSize: WindowSize): Int {
    val gridHeightWithSpace = GRID_CELL_HEIGHT + GRID_CELL_SPACE

    val expectedColumns = expectedColumns(windowSize)

    val rowsNum: Int = ((listSize.toFloat() / expectedColumns) + 0.5).roundToInt()

    return rowsNum * gridHeightWithSpace
}

private fun expectedColumns(windowSize: WindowSize): Int = when(windowSize){
    WindowSize.COMPACT -> 2
    WindowSize.MEDIUM -> 4
    WindowSize.EXPANDED -> 5
}

@Composable
@Preview
fun PreviewDamageRelationGridTwoItems() {
    PokedexComposeTheme {
        DamageRelationGrid(
            damageRelation = listOf(
                DamageRelation(
                    "grass"
                ),
                DamageRelation(
                    "ice"
                ),
            )
        )
    }
}

@Composable
@Preview
fun PreviewDamageRelationGridThreeItems() {
    PokedexComposeTheme {
        DamageRelationGrid(
            damageRelation = listOf(
                DamageRelation(
                    "grass"
                ),
                DamageRelation(
                    "ice"
                ),
                DamageRelation(
                    "steel"
                )
            )
        )
    }
}