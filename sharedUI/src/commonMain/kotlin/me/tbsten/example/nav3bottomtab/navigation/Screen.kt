package me.tbsten.example.nav3bottomtab.navigation

import kotlinx.serialization.Serializable
import me.tbsten.example.nav3bottomtab.maintab.MainTab

@Serializable
sealed interface Screen

@Serializable
data object Home : Screen

@Serializable
data object ChatList : Screen

@Serializable
data object MyPage : Screen

@Serializable
data object Settings : Screen

/**
 * [MainTab] と [Screen] の対応関係をここに集約する。
 * タブ追加時は [mainTabOrNull] と [MainTab.screen] を同時に更新すること。
 */

val Screen.mainTabOrNull: MainTab?
    get() = when (this) {
        Home -> MainTab.Home
        ChatList -> MainTab.ChatList
        MyPage -> MainTab.MyPage
        else -> null
    }

val MainTab.screen: Screen
    get() = when (this) {
        MainTab.Home -> Home
        MainTab.ChatList -> ChatList
        MainTab.MyPage -> MyPage
    }
