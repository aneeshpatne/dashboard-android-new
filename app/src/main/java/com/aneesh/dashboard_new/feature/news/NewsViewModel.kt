package com.aneesh.dashboard_new.feature.news

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class Sources(
    val url : String,
    val domain : String,
    val ogImage: String,
)
data class NewsItem(
    val id : Int,
    val title : String,
    val description: String,
    val sources : List<Sources>,
)
data class NewsItems(
    val items: List<NewsItems>
)
class NewsViewModel : ViewModel(){
    private val _news = MutableStateFlow(
        NewsItem(
            id = 101,
            title = "City Launches New Electric Bus Fleet to Cut Emissions",
            description = "The first phase introduces 60 electric buses across high-traffic routes, with charging depots added in three districts. Officials estimate annual emissions will drop by 18% once the full rollout is complete.",
            sources = listOf(
                Sources(
                    url = "https://www.reuters.com/world/city-expands-electric-bus-program",
                    domain = "Reuters",
                    ogImage = "https://images.reuters.com/electric-bus-fleet.jpg",
                ),
                Sources(
                    url = "https://www.bbc.com/news/science-environment-transport-policy",
                    domain = "BBC News",
                    ogImage = "https://ichef.bbci.co.uk/news/1024/transport-policy.jpg",
                ),
                Sources(
                    url = "https://www.theverge.com/transportation/2026/clean-transit-update",
                    domain = "The Verge",
                    ogImage = "https://cdn.vox-cdn.com/thumbor/clean-transit-update.jpg",
                ),
            ),
        ),
    );
    val news : StateFlow<NewsItem> = _news.asStateFlow();

}
