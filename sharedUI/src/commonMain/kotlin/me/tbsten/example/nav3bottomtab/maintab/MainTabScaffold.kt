package me.tbsten.example.nav3bottomtab.maintab

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import navigation_3_bottom_tab_example.sharedui.generated.resources.Res
import navigation_3_bottom_tab_example.sharedui.generated.resources.ic_chat_bubble
import navigation_3_bottom_tab_example.sharedui.generated.resources.ic_home
import navigation_3_bottom_tab_example.sharedui.generated.resources.ic_person
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun MainTabScaffold(
    currentTab: MainTab,
    onTabSelected: (MainTab) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = {
            MainTabNavigationBar(
                currentTab = currentTab,
                onTabSelected = onTabSelected,
            )
        },
        content = content,
    )
}

@Composable
private fun MainTabNavigationBar(
    currentTab: MainTab,
    onTabSelected: (MainTab) -> Unit,
) {
    NavigationBar {
        MainTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = currentTab == tab,
                onClick = { onTabSelected(tab) },
                icon = {
                    Icon(
                        imageVector = vectorResource(tab.iconRes),
                        contentDescription = tab.label,
                    )
                },
                label = { Text(tab.label) },
            )
        }
    }
}

private val MainTab.iconRes: DrawableResource
    get() = when (this) {
        MainTab.Home -> Res.drawable.ic_home
        MainTab.ChatList -> Res.drawable.ic_chat_bubble
        MainTab.MyPage -> Res.drawable.ic_person
    }

private val MainTab.label: String
    get() = when (this) {
        MainTab.Home -> "Home"
        MainTab.ChatList -> "Chat"
        MainTab.MyPage -> "My Page"
    }
