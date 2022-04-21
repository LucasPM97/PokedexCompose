package com.lucas.pokedexcompose.ui.composables

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun CollapsableColumn(
    modifier: Modifier = Modifier,
    alwaysDisplayRowContent: @Composable RowScope.() -> Unit = {},
    collapsableContent: @Composable ColumnScope.() -> Unit = {}
) {

    var visible by remember {
        mutableStateOf(false)
    }

    Column {
        Row(
            modifier = Modifier
                .clickable {
                    visible = !visible
                }
                .composed { modifier },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            alwaysDisplayRowContent()
            Icon(
                imageVector = if (visible) Icons.Filled.ExpandLess
                else Icons.Filled.ExpandMore,
                contentDescription = if (visible) "collapse info"
                else "show collapsed info"
            )
        }

        val density = LocalDensity.current

        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            collapsableContent()
        }
    }
}