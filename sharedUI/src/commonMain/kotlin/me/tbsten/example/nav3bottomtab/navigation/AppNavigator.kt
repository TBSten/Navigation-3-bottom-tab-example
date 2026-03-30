package me.tbsten.example.nav3bottomtab.navigation

import androidx.compose.runtime.mutableStateListOf
import me.tbsten.example.nav3bottomtab.maintab.MainTab
import me.tbsten.example.nav3bottomtab.maintab.MainTabNavigator

interface AppNavigator : MainTabNavigator {
    val backstack: List<Screen>
    fun onBack()
}

class AppNavigatorImpl : AppNavigator {
    override val backstack = mutableStateListOf<Screen>(Home)

    override val currentTab: MainTab?
        get() = backstack.lastOrNull()?.mainTabOrNull

    override fun switchTab(tab: MainTab) {
        val screen = tab.screen
        val lastTabIndex = backstack.indexOfLast { it.mainTabOrNull != null }
        if (lastTabIndex >= 0) {
            backstack[lastTabIndex] = screen
        } else {
            backstack.add(screen)
        }
    }

    override fun onBack() {
        if (backstack.size >= 2) backstack.removeLastOrNull()
    }
}
