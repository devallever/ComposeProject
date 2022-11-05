package app.allever.android.learning.project.compose.module.wechat.ui.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.allever.android.learning.project.compose.R

@Composable
fun WeTopBar(title: String) {
    Box(
        Modifier
            .background(Color.White)
            .height(48.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.Center),
            textAlign = TextAlign.Center
        )

        Image(
            painterResource(R.drawable.avatar_1), "",
            modifier = Modifier
                .size(48.dp)
                .padding(horizontal = 14.dp)
                .align(Alignment.CenterEnd)
        )
    }

}