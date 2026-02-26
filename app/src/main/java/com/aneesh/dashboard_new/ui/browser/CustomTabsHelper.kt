package com.aneesh.dashboard_new.ui.browser

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent

fun buildCustomTabsIntent(
    toolbarColor: Int,
    showTitle: Boolean = true
): CustomTabsIntent {
    return CustomTabsIntent.Builder()
        .setShowTitle(showTitle)
        .setDefaultColorSchemeParams(
            CustomTabColorSchemeParams.Builder()
                .setToolbarColor(toolbarColor)
                .build()
        )
        .build()
}

fun openUrlInCustomTab(
    context: Context,
    url: String,
    toolbarColor: Int,
    showTitle: Boolean = true
) {
    buildCustomTabsIntent(
        toolbarColor = toolbarColor,
        showTitle = showTitle
    ).launchUrl(context, Uri.parse(url))
}
