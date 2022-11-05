package app.allever.android.learning.project.compose.module.tianliao.module.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TabLayout(data: List<String>, select: Int, onTabSelected: (Int) -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.White)
    ) {
        //顶部Tab
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight()
        ) {
            for (i in data.indices) {
                Tab(data[i], i, select == i, onTabSelected)
            }
        }
    }
}

@Composable
private fun Tab(text: String, index: Int, selected: Boolean, onTabSelected: (Int) -> Unit) {
    Column(
        Modifier
            .fillMaxHeight()
            .width(70.dp)
            .clickable {
                onTabSelected(index)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text,
            Modifier
                .padding(horizontal = 10.dp),
            fontSize = if (selected) 22.sp else 17.sp,
            color = Color.Black
        )
    }
}