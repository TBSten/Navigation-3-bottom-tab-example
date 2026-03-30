package me.tbsten.example.nav3bottomtab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import me.tbsten.example.nav3bottomtab.navigation.AppNavigation
import me.tbsten.example.nav3bottomtab.navigation.AppNavigatorImpl
import me.tbsten.example.nav3bottomtab.theme.AppTheme

@Preview
@Composable
fun App(
    onThemeChanged: @Composable (isDark: Boolean) -> Unit = {},
) = AppTheme(onThemeChanged) {
    val appNavigator = remember { AppNavigatorImpl() }
    AppNavigation(appNavigator = appNavigator)
}
