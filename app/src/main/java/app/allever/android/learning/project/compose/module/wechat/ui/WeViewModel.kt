package app.allever.android.learning.project.compose.module.wechat.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import app.allever.android.learning.project.compose.R
import app.allever.android.learning.project.compose.module.wechat.data.Chat
import app.allever.android.learning.project.compose.module.wechat.data.Msg
import app.allever.android.learning.project.compose.module.wechat.data.User

class WeViewModel : ViewModel() {

    var chats by mutableStateOf(
        listOf(
            Chat(
                friend = User("gaolaoshi", "高老师", R.drawable.avatar_1),
                mutableStateListOf(
                    Msg(
                        from = User("gaolaoshi", "高老师", R.drawable.avatar_1),
                        text = "你好啵",
                        "14:20"
                    ),
                    Msg(from = User.Me, text = "你也很好哦", "14:20"),
                    Msg(
                        from = User("gaolaoshi", "高老师", R.drawable.avatar_1),
                        text = "吃饭了吗",
                        "14:21"
                    )
                )
            ),
            Chat(
                friend = User("lanyangyang", "喜洋洋", R.drawable.avatar_2),
                mutableStateListOf(
                    Msg(
                        from = User("lanyangyang", "喜洋洋", R.drawable.avatar_2),
                        text = "你好美女",
                        "18:20"
                    ),
                    Msg(from = User.Me, text = "帅哥你好", "18:20"),
                    Msg(
                        from = User("lanyangyang", "喜洋洋", R.drawable.avatar_2),
                        text = "在干嘛呢",
                        "18:21"
                    )
                )
            )
        )
    )

    init {
        chats[0].msgList.last().read = false
    }

    //当值改变会刷新
    var selectedTab by mutableStateOf(0)


}