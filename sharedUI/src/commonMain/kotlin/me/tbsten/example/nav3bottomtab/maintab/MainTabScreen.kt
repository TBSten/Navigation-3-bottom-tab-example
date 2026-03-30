package me.tbsten.example.nav3bottomtab.maintab

import androidx.compose.runtime.Composable

@Composable
fun MainTabScreen(
    currentTab: MainTab,
    content: @Composable () -> Unit,
) {
    val navigator = LocalMainTabNavigator.current
    MainTabScaffold(
        currentTab = currentTab,
        onTabSelected = { navigator.switchTab(it) },
    ) {
        content()
    }
}
