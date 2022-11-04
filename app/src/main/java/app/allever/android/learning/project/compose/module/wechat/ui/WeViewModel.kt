package app.allever.android.learning.project.compose.module.wechat.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WeViewModel : ViewModel(){

    //当值改变会刷新
    var selectedTab by mutableStateOf(0)

}