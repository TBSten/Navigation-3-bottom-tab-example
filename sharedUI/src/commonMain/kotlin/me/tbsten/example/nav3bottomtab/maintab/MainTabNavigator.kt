package me.tbsten.example.nav3bottomtab.maintab

interface MainTabNavigator {
    val currentTab: MainTab?
    fun switchTab(tab: MainTab)
}
