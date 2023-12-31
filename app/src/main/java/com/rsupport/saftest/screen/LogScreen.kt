package com.rsupport.saftest.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rsupport.saftest.util.Util

@Composable
fun LogScreen(navHostController: NavHostController, log: State<String>) {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "전송 파일 정보", modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .verticalScroll(state)
                .padding(10.dp)
        ) {
            Text(text = log.value, modifier = Modifier, fontSize = 10.sp)
        }
    }
    BackHandler {
        Util.logCollector.value = ""
        navHostController.popBackStack()
    }
}

@Composable
@Preview
fun LogScreenPreview() {
    val log = remember { mutableStateOf("Sample log text\nLine 1\nLine 2\nLine 3") }
    val navHostController = rememberNavController()

    LogScreen(navHostController = navHostController, log = log)
}