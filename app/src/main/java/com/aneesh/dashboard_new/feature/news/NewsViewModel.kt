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
    val id : String,
    val title : String,
    val description: String,
    val sources : List<Sources>,
    val ogUrl: String,
)
class NewsViewModel : ViewModel(){
    private val _newsItems = MutableStateFlow(
        listOf(
            NewsItem(
                id = "60189acd-fcf7-4c18-a23c-cd6a7295a7ad",
                title = "SC exchange on ED probe of Mamata",
                description = "In Supreme Court hearing over IPAC searches, ASG said ED was terrorised; case posted to March 18.",
                sources = listOf(
                    Sources(
                        url = "https://www.livelaw.in/top-stories/ed-has-been-weaponised-no-ed-was-terrorised-exchange-in-supreme-court-plea-against-mamata-banerjee-523599",
                        domain = "livelaw",
                        ogImage = "https://www.livelaw.in/h-upload/2026/01/15/646967-mamata-banerjee-sc-ed.jpg",
                    ),
                ),
                ogUrl = "https://www.livelaw.in/h-upload/2026/01/15/646967-mamata-banerjee-sc-ed.jpg",
            ),
        )
    );
    val newsItems : StateFlow<List<NewsItem>> = _newsItems.asStateFlow();

}
