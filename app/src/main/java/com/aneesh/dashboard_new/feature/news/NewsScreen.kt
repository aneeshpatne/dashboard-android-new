package com.aneesh.dashboard_new.feature.news

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
@Composable
fun NewsRoute(
    viewModel: NewsViewModel = viewModel()
){
    val newsState by viewModel.newsItems.collectAsStateWithLifecycle()
    NewsScreen(newsItems = newsState)
}

@Composable
fun NewsScreen(
    newsItems: NewsItems
){
    LazyColumn(){
       items(newsItems.items) {
           Text(text = it.title)
       }
    }
}
