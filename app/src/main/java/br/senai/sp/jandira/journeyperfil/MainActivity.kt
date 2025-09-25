package br.senai.sp.jandira.journeyperfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.journeyperfil.screens.DrawerMenu
import br.senai.sp.jandira.journeyperfil.screens.ProfileScreen
import kotlinx.coroutines.launch
import br.senai.sp.jandira.jouneyperfil.ui.theme.JouneyperfilTheme
import br.senai.sp.jandira.journeyperfil.screens.AppThemeColors.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            JouneyperfilTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    var isDarkTheme by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenu(
                onOptionSelected = { route ->
                    navController.navigate(route)
                    scope.launch { drawerState.close() }
                },
                isDarkTheme = isDarkTheme,
                onThemeToggle = { isDarkTheme = !isDarkTheme }
            )
        },
        gesturesEnabled = drawerState.isOpen
    ) {
        NavHost(navController = navController, startDestination = "home_screen") {

            composable("home_screen") {
                HomeScreen(
                    navController = navController,
                    drawerState = drawerState,
                    scope = scope,
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = { isDarkTheme = !isDarkTheme }
                )
            }

            composable("profile_screen") {
                ProfileScreen(
                    navController = navController,
                    isDarkTheme = isDarkTheme
                )
            }

            composable("create_group_screen") {
                Text(text = "Tela de Criação de Grupo")
            }
        }
    }}