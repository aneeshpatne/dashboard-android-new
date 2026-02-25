package com.aneesh.dashboard_new.feature.news

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
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
    Scaffold { innerPadding ->
        NewsScreen(
            newsItems = newsState,
            contentPadding = innerPadding
        )
    }
}

@Composable
fun NewsScreen(
    newsItems: NewsItems,
    contentPadding: PaddingValues
){
    LazyColumn(
        contentPadding = contentPadding
    ){
       items(newsItems.items) {
           NewsItemCard(it)
       }
    }
}

@Composable
fun NewsItemCard(newsItem: NewsItem){
    Text(text = newsItem.title)
}
