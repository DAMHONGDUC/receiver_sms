package com.rmyhal.containertransform

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.TransformContainer
import com.receiver.sms.presentation.screens.home.AddContentScreen

@Stable
data class HotTake(
    val title: String?,
    val take: String,
)

val hotTakes = listOf(
    HotTake(
        title = null,
        take = "Artificial Intelligence isn't just a threat to jobs; it's a catalyst for redefining the workforce. Instead of fearing automation, we should focus on reskilling and upskilling workers to thrive in a future augmented by AI.",
    ),
    HotTake(
        title = "Security?",
        take = "Prioritizing user security over convenience should be non-negotiable in Android app development. While features like single sign-on and biometric authentication enhance user experience, they should not compromise security standards. Developers must strike a balance between user convenience and robust security measures to safeguard user data and trust."
    ),
    HotTake(
        title = "Compose or Collapse",
        take = "Jetpack Compose isn't just a toolkit; it's the litmus test for Android's future relevance. Embrace Compose's radical departure from XML layouts or risk irrelevance in a rapidly evolving mobile ecosystem.",
    )
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        HotContent()

        TransformContainer(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            closeBuilder = { voidCallback ->
                Fab(
                    onClick = {
                        voidCallback()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(56.dp)
                )
            },
            openBuilder = { voidCallback ->
                AddContentScreen(
                    modifier = Modifier.fillMaxSize(),
                    onBack = { voidCallback() }
                )
            }
        )
    }
}

@Composable
private fun HotContent() {
    Column {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
private fun SearchBar(modifier: Modifier = Modifier) {
    OutlinedTextField(
        modifier = modifier,
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
            )
        },
        placeholder = {
            Text(
                text = "Search your hot takes"
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(50)
    )
}

@Composable
private fun Fab(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = 76.dp,
                minHeight = 76.dp,
            )
            .clickable(
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = rememberVectorPainter(Icons.Filled.Add),
            contentDescription = null,
        )
    }
}

sealed interface UiState {
    data class Loaded(val list: List<HotTake>) : UiState
    data object Loading : UiState
}


