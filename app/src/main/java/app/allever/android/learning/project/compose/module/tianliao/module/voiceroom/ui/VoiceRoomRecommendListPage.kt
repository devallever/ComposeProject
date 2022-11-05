package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import app.allever.android.lib.core.ext.toast

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VoiceRoomRecommendListPage(lifecycleOwner: LifecycleOwner) {

    val list = listOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        itemsIndexed(list) { index, item ->
            Box(
                Modifier
                    .background(color = Color.Gray)
                    .height(160.dp)
                    .clickable {
                        toast(index.toString())
                    }

            ) {
                Text(text = "hello", Modifier.fillMaxSize())
            }
        }
    }

}