package app.allever.android.learning.project.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.learning.project.compose.data.FunctionItem
import app.allever.android.learning.project.compose.module.wechat.ui.WechatComposeActivity
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    val viewMode: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                //功能列表
                FunctionList(viewMode.functionItemList) {
                    WechatComposeActivity.start(this)
                }
            }
        }
    }
}

@Composable
fun FunctionList(list: List<FunctionItem>, callback: (position: Int) -> Unit) {
    LazyColumn() {
        itemsIndexed(list) { index, item ->
            Column(
                Modifier
                    .fillMaxSize()
                    .clickable {
                        callback(index)
                        Log.d("", "FunctionList: ${item.title}")
                    }
                    .padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Text(item.title, fontSize = 17.sp)
                Text(item.desc, fontSize = 14.sp, color = Color.Gray)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunctionList() {
    val list = mutableListOf<FunctionItem>()
    list.add(FunctionItem("tITLE", "desc"))
    LazyColumn() {
        itemsIndexed(list) { index, item ->
            Column(
                Modifier
                    .fillMaxSize()
            ) {
                Text(item.title, fontSize = 14.sp)
                Text(item.desc, fontSize = 11.sp)
            }

        }
    }
}

