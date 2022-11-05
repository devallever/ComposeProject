package app.allever.android.learning.project.compose.module.tianliao.module.main.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.learning.project.compose.R


@Composable
fun MainBottomBar(select: Int, onItemClick: (Int) -> Unit) {
    Row(
        Modifier
            .height(48.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BottomTabItem(
            "聊群",
            if (select == 0) R.drawable.ic_chatroom_checked else R.drawable.ic_chatroom_unchecked,
            Modifier
                .weight(1f)
                .clickable {
                    onItemClick(0)
                }
        )
        BottomTabItem(
            "聊圈",
            if (select == 1) R.drawable.ic_moment_checked else R.drawable.ic_moment_unchecked,
            Modifier
                .weight(1f)
                .clickable {
                    onItemClick(1)
                }
        )
        BottomTabItem(
            "聊信",
            if (select == 2) R.drawable.ic_message_checked else R.drawable.ic_message_unchecked,
            Modifier
                .weight(1f)
                .clickable {
                    onItemClick(2)
                }
        )
        BottomTabItem(
            "我的",
            if (select == 3) R.drawable.ic_mine_check else R.drawable.ic_mine_uncheck,
            Modifier
                .weight(1f)
                .clickable {
                    onItemClick(3)
                }
        )
    }
}


@Composable
fun BottomTabItem(title: String, @DrawableRes icon: Int, modifier: Modifier): Modifier {
    Column(
        modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painterResource(icon), contentDescription = title, Modifier.size(20.dp))
        Text(title, fontSize = 9.sp)
    }

    return modifier
}
