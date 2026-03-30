package me.tbsten.example.nav3bottomtab.maintab

import androidx.compose.runtime.compositionLocalOf

val LocalMainTabNavigator = compositionLocalOf<MainTabNavigator> {
    error("No MainTabNavigator provided")
}
