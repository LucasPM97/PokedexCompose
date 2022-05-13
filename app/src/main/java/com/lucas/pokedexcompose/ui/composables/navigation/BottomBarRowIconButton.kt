package com.lucas.pokedexcompose.ui.composables.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeMute
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun BottomBarRowIconButton(
    icon: ImageVector,
    text: String? = null,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .clickable {
                onClick()
            }
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color.White
        )
        text?.let {
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp

            )
        }
    }
}

@Composable
@Preview
fun PreviewBottomBarRowIconButton() {
    PokedexComposeTheme {
        BottomBarRowIconButton(
            icon = Icons.Filled.VolumeMute
        )
    }
}

@Composable
@Preview
fun PreviewBottomBarRowIconButtonWithText() {
    PokedexComposeTheme {
        BottomBarRowIconButton(
            icon = Icons.Filled.VolumeMute,
            text = "Mute"
        )
    }
}