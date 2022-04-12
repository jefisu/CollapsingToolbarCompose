package com.jefisu.collapsingtoolbarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.onebone.toolbar.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberCollapsingToolbarScaffoldState()
            MainScreen(
                state = state,
                scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalToolbarApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    state: CollapsingToolbarScaffoldState,
    scrollStrategy: ScrollStrategy
) {
    CollapsingToolbarScaffold(
        modifier = modifier,
        state = state,
        scrollStrategy = scrollStrategy,
        toolbar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(MaterialTheme.colors.primary)
                    .pin()
            )
            Text(
                text = "Alphabet",
                color = MaterialTheme.colors.surface,
                fontSize = 28.sp,
                modifier = Modifier
                    .road(Alignment.CenterStart, Alignment.BottomEnd)
                    .padding(
                        start = 60.dp,
                        top = 11.5.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colors.surface,
                modifier = Modifier
                    .size(60.dp)
                    .padding(16.dp)
                    .pin()
            )
        }
    ) {
        val letters = ('a'..'z').toList()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            items(letters) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Letter ${it.uppercase()}",
                        fontSize = 28.sp,
                        color = MaterialTheme.colors.surface
                    )
                }
            }
        }
    }
}