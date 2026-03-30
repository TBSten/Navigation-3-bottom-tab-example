package me.tbsten.example.nav3bottomtab.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.scene.SinglePaneSceneStrategy
import androidx.navigation3.ui.NavDisplay
import me.tbsten.example.nav3bottomtab.maintab.LocalMainTabNavigator
import me.tbsten.example.nav3bottomtab.maintab.MainTab
import me.tbsten.example.nav3bottomtab.maintab.MainTabSceneStrategy

@Composable
fun AppNavigation(
    appNavigator: AppNavigator,
) {
    CompositionLocalProvider(LocalMainTabNavigator provides appNavigator) {
    NavDisplay(
        backStack = appNavigator.backstack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        sceneStrategy = remember {
            MainTabSceneStrategy<Screen>()
                .then(DialogSceneStrategy())
                .then(SinglePaneSceneStrategy())
        },
        entryProvider = entryProvider {
            entry<Home>(
                metadata = MainTabSceneStrategy.mainTab(MainTab.Home),
            ) {
                PlaceholderScreen("Home")
            }

            entry<ChatList>(
                metadata = MainTabSceneStrategy.mainTab(MainTab.ChatList),
            ) {
                PlaceholderScreen("Chat List")
            }

            entry<MyPage>(
                metadata = MainTabSceneStrategy.mainTab(MainTab.MyPage),
            ) {
                PlaceholderScreen("My Page")
            }

            entry<Settings> {
                PlaceholderScreen("Settings")
            }
        },
    )
    }
}

@Composable
private fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(title)
    }
}
