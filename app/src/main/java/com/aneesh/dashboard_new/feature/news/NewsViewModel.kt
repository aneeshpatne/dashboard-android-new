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
    val id: String,
    val title: String,
    val description: String,
    val sources: List<Sources>,
    val ogUrl: String,
    val genre: String,
)

data class NewsItems(
    val items: List<NewsItem>
)

class NewsViewModel : ViewModel() {
    private val _newsItems = MutableStateFlow(
        NewsItems(
            items = listOf(
                NewsItem(
                    id = "41c01af2-081d-45f8-b662-3601552dec47",
                    title = "BMC to issue QR code certificates for vendors",
                    description = "BMC will issue QR code certificates to authorised hawkers to curb illegal vending.",
                    sources = listOf(
                        Sources(
                            url = "https://www.mid-day.com/mumbai/mumbai-news/article/bmc-budget-2026-mumbai-municipal-corporation-introduces-qr-code-based-certification-for-authorised-hawkers-23618320",
                            domain = "mid-day",
                            ogImage = "https://images.mid-day.com/images/images/2026/feb/Hawkers-1772034312952_d.png",
                        ),
                    ),
                    ogUrl = "https://images.mid-day.com/images/images/2026/feb/Hawkers-1772034312952_d.png",
                    genre = "Mumbai",
                ),
            )
        )
    )

    val newsItems: StateFlow<NewsItems> = _newsItems.asStateFlow()

}
