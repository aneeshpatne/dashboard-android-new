package com.aneesh.dashboard_new.feature.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        LazyRow {
            items(newsItem.sources){
                SourceItem(it)
            }
        }
        Column {
            Text(text = newsItem.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                lineHeight = 28.sp,
                color = MaterialTheme.colorScheme.onSurface
                )
            Text(text = newsItem.description,
                style = MaterialTheme.typography.bodyLarge,
                lineHeight = 24.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun SourceItem(sources: Sources){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(2.dp)
    ){
        AsyncImage(
            model = "https://t0.gstatic.com/faviconV2?client=SOCIAL&type=FAVICON&fallback_opts=TYPE,SIZE,URL&url=${sources.url}&size=32",
            contentDescription = sources.domain,
            modifier = Modifier.size(16.dp)
        )
        Text(text = sources.domain)
    }
}
