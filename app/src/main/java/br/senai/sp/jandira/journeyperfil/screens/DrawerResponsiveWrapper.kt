package br.senai.sp.jandira.journeyperfil.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.journeyperfil.screens.AppThemeColors.HomeScreen

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun DrawerResponsiveWrapper(
    navController: NavController,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    BoxWithConstraints {
        if (maxWidth > 600.dp) {
            // Tablet → Drawer fixo
            PermanentNavigationDrawer (
                drawerContent = {
                    DrawerMenu(
                        onOptionSelected = { /* ações */ },
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = onThemeToggle
                    )
                }
            ) {
                HomeScreen(
                    navController = navController,
                    drawerState = drawerState,
                    scope = scope,
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = onThemeToggle
                )
            }
        } else {
            ModalNavigationDrawer(
                drawerContent = {
                    DrawerMenu(
                        onOptionSelected = {  },
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = onThemeToggle
                    )
                },
                drawerState = drawerState
            ) {
                HomeScreen(
                    navController = navController,
                    drawerState = drawerState,
                    scope = scope,
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = onThemeToggle
                )
            }
        }
    }
}
