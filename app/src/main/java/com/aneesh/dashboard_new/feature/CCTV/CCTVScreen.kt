package com.aneesh.dashboard_new.feature.CCTV

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.aneesh.dashboard_new.ui.browser.openUrlInCustomTab

@Composable
fun OpenBrowserButton() {
    val context = LocalContext.current
    val toolbarColor = MaterialTheme.colorScheme.surface.toArgb()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                openUrlInCustomTab(
                    context = context,
                    url = "http://192.168.0.99:8889/esp_cam1_overlay/",
                    toolbarColor = toolbarColor
                )
            }
        ) {
            Text("Open CCTV")
        }
    }
}
