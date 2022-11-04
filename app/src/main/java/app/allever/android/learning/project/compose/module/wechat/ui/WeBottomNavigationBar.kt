package app.allever.android.learning.project.compose.module.wechat.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.learning.project.compose.R

@Composable
fun BottomBar(selected: Int, click: (position: Int) -> Unit) {
    //横向布局
    Row(Modifier.background(Color.White)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chatroom_checked else R.drawable.ic_chatroom_unchecked,
            if (selected == 0) Color.Green else Color.Black,
            "聊天",
            Modifier
                .weight(1f)
                .clickable {
                    click(0)
                }
        )
        TabItem(
            if (selected == 1) R.drawable.ic_chatroom_checked else R.drawable.ic_chatroom_unchecked,
            if (selected == 1) Color.Green else Color.Black,
            "通讯录",
            Modifier
                .weight(1f)
                .clickable {
                    click(1)
                }
        )
        TabItem(
            if (selected == 2) R.drawable.ic_chatroom_checked else R.drawable.ic_chatroom_unchecked,
            if (selected == 2) Color.Green else Color.Black,
            "发现",
            Modifier
                .weight(1f)
                .clickable {
                    click(2)
                }
        )
        TabItem(
            if (selected == 3) R.drawable.ic_chatroom_checked else R.drawable.ic_chatroom_unchecked,
            if (selected == 3) Color.Green else Color.Black,
            "我的",
            Modifier
                .weight(1f)
                .clickable {
                    click(3)
                }
        )
    }
}

@Composable
fun TabItem(@DrawableRes iconId: Int, color: Color, title: String, modifier: Modifier): Modifier {
    //horizontalAlignment = Alignment.CenterHorizontally 横向居中
    Column(modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painterResource(iconId),
            contentDescription = title,
            Modifier.size(24.dp),
//            tint = color
        )
        Text(
            title, fontSize = 11.sp,
//            color = color
        )
    }
    return modifier
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomBar() {
    Text("Hello", color = MaterialTheme.colors.primary)
//    Icon(painterResource(R.drawable.ic_chatroom_checked), contentDescription = "")
}
