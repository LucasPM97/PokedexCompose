package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.models.HabitatTypes
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun HabitatIcon(habitat: HabitatTypes?, size: Int) {
    val boxSize = size + (size / 8)

    Image(
        painter = getHabitatImage(habitat),
        contentDescription = "$habitat",
        modifier = Modifier.size(boxSize.dp)
    )
}

@Composable
private fun getHabitatImage(habitat: HabitatTypes?): Painter = when (habitat) {
    HabitatTypes.Cave -> painterResource(id = R.drawable.cave)
    HabitatTypes.Forest -> painterResource(id = R.drawable.forest)
    HabitatTypes.Grassland -> painterResource(id = R.drawable.grassland)
    HabitatTypes.Mountain -> painterResource(id = R.drawable.mountain)
    HabitatTypes.RoughTerrain -> painterResource(id = R.drawable.rough_terrain)
    HabitatTypes.Sea -> painterResource(id = R.drawable.sea)
    HabitatTypes.Urban -> painterResource(id = R.drawable.urban)
    HabitatTypes.WatersEdge -> painterResource(id = R.drawable.waters_edge)
    HabitatTypes.Rare, null -> painterResource(id = R.drawable.unknown)
}

@Composable
@Preview
fun PreviewMountainHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Mountain,
            50
        )
    }
}

@Composable
@Preview
fun PreviewGrassHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Grassland,
            50
        )
    }
}

@Composable
@Preview
fun PreviewForestHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Forest,
            50
        )
    }
}

@Composable
@Preview
fun PreviewSeaHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Sea,
            50
        )
    }
}

@Composable
@Preview
fun PreviewUrbanHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Urban,
            50
        )
    }
}

@Composable
@Preview
fun PreviewRoughTerrainHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.RoughTerrain,
            50
        )
    }
}

@Composable
@Preview
fun PreviewCaveHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Cave,
            50
        )
    }
}

@Composable
@Preview
fun PreviewWatersEdgeHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.WatersEdge,
            50
        )
    }
}

@Composable
@Preview
fun PreviewRareEdgeHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcon(
            habitat = HabitatTypes.Rare,
            50
        )
    }
}