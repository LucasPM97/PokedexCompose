package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.models.HabitatTypes
import com.lucas.pokedexcompose.ui.theme.*

@Composable
fun HabitatIcon(habitat: HabitatTypes?, size: Int) = when (habitat) {
    HabitatTypes.Cave -> HabitatIcons.CaveHabitatIcon(size)
    HabitatTypes.Forest -> HabitatIcons.ForestHabitatIcon(size)
    HabitatTypes.Grassland -> HabitatIcons.GrassHabitatIcon(size)
    HabitatTypes.Mountain -> HabitatIcons.MountainHabitatIcon(size)
    HabitatTypes.RoughTerrain -> HabitatIcons.RoughTerrainHabitatIcon(size)
    HabitatTypes.Sea -> HabitatIcons.SeaHabitatIcon(size)
    HabitatTypes.Urban -> HabitatIcons.UrbanHabitatIcon(size)
    HabitatTypes.WatersEdge -> HabitatIcons.WatersEdgeHabitatIcon(size)
    HabitatTypes.Rare, null -> HabitatIcons.RareHabitatIcon(size)
}

object HabitatIcons {

    @Composable
    fun RareHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)

        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    Color.Gray,
                    RoundedCornerShape(50)
                )
        ) {

            val lineHeightSp = with(LocalDensity.current) {
                (size / 2).dp.toSp()
            }

            Text(
                text = "?",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Center),
                fontSize = lineHeightSp
            )
        }
    }

    @Composable
    fun MountainHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)

        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    Color.Gray,
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Terrain,
                contentDescription = "",
                tint = TypeDark,
                modifier = Modifier.size(size.dp)
            )
        }
    }

    @Composable
    fun GrassHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)
        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    Color(0xFFADD8E6),
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Grass,
                contentDescription = "",
                tint = Color(0xFF348C31),
                modifier = Modifier
                    .size(size.dp)
                    .padding(start = 3.dp)
            )
            Icon(
                imageVector = Icons.Filled.Grass,
                contentDescription = "",
                tint = TypeGrass,
                modifier = Modifier
                    .size(size.dp)
            )
        }
    }

    @Composable
    fun ForestHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)
        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    Color(0xFF288070),
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                )
        ) {
            val iconSize = size - size / 2.3f

            Icon(
                imageVector = Icons.Filled.Park,
                contentDescription = "",
                tint = Color(0xFF284040),
                modifier = Modifier
                    .size(iconSize.dp)
                    .align(Alignment.Center)
            )
            Icon(
                imageVector = Icons.Filled.Park,
                contentDescription = "",
                tint = Color(0xFF18982F),
                modifier = Modifier
                    .size(iconSize.dp)
                    .align(Alignment.CenterStart)
            )
            Icon(
                imageVector = Icons.Filled.Park,
                contentDescription = "",
                tint = Color(0xFF18982F),
                modifier = Modifier
                    .size(iconSize.dp)
                    .align(Alignment.CenterEnd)
            )
        }
    }

    @Composable
    fun SeaHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)
        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    Color(0xFF4F74C4),
                    RoundedCornerShape(50)
                )
        ) {
            val iconSize = (size / 4) * 3
            Icon(
                imageVector = Icons.Filled.Water,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(bottom = 1.dp)
                    .size(iconSize.dp)
                    .align(Alignment.Center)
            )
            Icon(
                imageVector = Icons.Filled.Water,
                contentDescription = "",
                tint = TypeWater,
                modifier = Modifier
                    .size(iconSize.dp)
                    .align(Alignment.Center)
            )
        }
    }

    @Composable
    fun UrbanHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)

        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    Color.Black,
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.LocationCity,
                contentDescription = "",
                tint = Color.LightGray,
                modifier = Modifier.size(size.dp)
            )
        }
    }

    @Composable
    fun RoughTerrainHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)

        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    TypeGround,
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cactus),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(size.dp)
            )
        }
    }

    @Composable
    fun CaveHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)

        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    TypeDark,
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cave),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier
                    .size(size.dp)
                    .padding(bottom = 5.dp)
            )
        }
    }

    @Composable
    fun WatersEdgeHabitatIcon(size: Int) {
        val boxSize = size + (size / 8)

        Box(
            Modifier
                .size(boxSize.dp)
                .background(
                    TypeGround,
                    RoundedCornerShape(50)
                )
                .padding(
                    horizontal = (size / 8).dp
                )
                .padding(
                    top = (size / 8).dp
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.palm),
                contentDescription = "",
                tint = Color(0xFF18982F),
                modifier = Modifier.size(size.dp)
            )
        }
    }
}

@Composable
@Preview
fun PreviewMountainHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.MountainHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewGrassHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.GrassHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewForestHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.ForestHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewSeaHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.SeaHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewUrbanHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.UrbanHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewRoughTerrainHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.RoughTerrainHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewCaveHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.CaveHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewWatersEdgeHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.WatersEdgeHabitatIcon(
            50
        )
    }
}

@Composable
@Preview
fun PreviewRareEdgeHabitatIcon() {
    PokedexComposeTheme {
        HabitatIcons.RareHabitatIcon(
            50
        )
    }
}