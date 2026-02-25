package com.aneesh.dashboard_new.feature.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
        modifier = Modifier.padding(16.dp),
        contentPadding = contentPadding
    ){
       items(newsItems.items) {
           NewsItemCard(it)
       }
    }
}

@Composable
fun NewsItemCard(newsItem: NewsItem){
    Column {
        AsyncImage(
            model = newsItem.ogUrl,
            contentDescription = newsItem.title,
            modifier = Modifier.fillMaxWidth().height(180.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = newsItem.title)
            Text(text = newsItem.description)
        }
    }
}
