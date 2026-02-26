package com.aneesh.dashboard_new

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aneesh.dashboard_new.feature.news.NewsRoute
import com.aneesh.dashboard_new.ui.theme.Dashboard_newTheme

private enum class MainTab(val label: String) {
    News("News"),
    Sensors("Sensors"),
    Cctv("CCTV"),
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dashboard_newTheme(dynamicColor = false) {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val selectedTab = rememberSaveable { mutableIntStateOf(MainTab.News.ordinal) }

    Scaffold(
        bottomBar = {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                )
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 6.dp
                ) {
                    MainTab.entries.forEach { tab ->
                        NavigationBarItem(
                            selected = selectedTab.intValue == tab.ordinal,
                            onClick = { selectedTab.intValue = tab.ordinal },
                            icon = {},
                            label = { Text(tab.label) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = MaterialTheme.colorScheme.onSurface,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f),
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (MainTab.entries[selectedTab.intValue]) {
                MainTab.News -> NewsRoute()
                MainTab.Sensors -> EmptyTabScreen(title = "Sensors")
                MainTab.Cctv -> EmptyTabScreen(title = "CCTV")
            }
        }
    }
}

@Composable
private fun EmptyTabScreen(title: String) {
    Text(text = "$title screen")
}

