package app.allever.android.learning.project.compose.module.wechat.ui.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.learning.project.compose.module.wechat.data.Chat
import app.allever.android.lib.core.ext.toast

@Composable
fun ChatList(chats: List<Chat>) {
    Column(Modifier.fillMaxSize()) {
        WeTopBar("微信")
        //消息列表
        LazyColumn(Modifier.weight(1f)) {
            itemsIndexed(chats) { index, chat ->
                ChatListItem(chat)
                if (index != chats.lastIndex) {
                    Divider(startIndent = 68.dp, color = Color.Gray, thickness = 0.5f.dp)
                }
            }
        }
    }

}

@Composable
fun ChatListItem(chat: Chat) {
    val friend = chat.friend

    Row(Modifier.padding(4.dp).clickable {
        toast(chat.msgList.last().text)
    }) {
        //头像
        Image(
            painterResource(friend.avatar), friend.nickname,
            Modifier
                .padding(4.dp)
                .size(48.dp)
                .unread(!chat.msgList.last().read)
                .clip(
                    RoundedCornerShape(4.dp)
                )

        )
        //昵称&内容
        Column(
            Modifier
                .weight(1f)
                //垂直居中
                .align(Alignment.CenterVertically)
        ) {
            Text(friend.nickname, fontSize = 17.sp)
            Text(chat.msgList.last().text, fontSize = 14.sp)
        }

        //事件
        Text(
            chat.msgList.last().time,
            fontSize = 12.sp,
            modifier = Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp)
        )
    }
}

/**
 * 未读：//自定义绘制
 */
fun Modifier.unread(show: Boolean) = this.drawWithContent {
    //绘制原生内容
    drawContent()
    if (show) {
        //绘制小红点
        drawCircle(
            Color.Red,
            5.dp.toPx(),
            Offset(size.width - 1.dp.toPx(), 1.dp.toPx())
        )
    }

}
