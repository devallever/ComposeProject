package app.allever.android.learning.project.compose

import androidx.lifecycle.ViewModel
import app.allever.android.learning.project.compose.data.FunctionItem

class MainViewModel : ViewModel() {

    val functionItemList = mutableListOf<FunctionItem>()

    init {
        initFunctionListData()
    }

    private fun initFunctionListData() {
        functionItemList.add(FunctionItem("微信", "微信主界面"))
        functionItemList.add(FunctionItem("天聊", "天聊Compose"))
    }
}