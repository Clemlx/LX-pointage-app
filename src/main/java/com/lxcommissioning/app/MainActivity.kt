package com.lxcommissioning.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.lxcommissioning.app.ui.screens.*
import com.lxcommissioning.app.ui.theme.LXTheme
import com.lxcommissioning.app.ui.viewmodels.AuthViewModel
import com.lxcommissioning.app.ui.viewmodels.ChantierViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LXTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()
    val chantierViewModel: ChantierViewModel = hiltViewModel()
    
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    if (!isLoggedIn) {
        LoginScreen(authViewModel, onLoginSuccess = { /* State handles it */ })
    } else {
        Scaffold(
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Dashboard, contentDescription = null) },
                        label = { Text("Pointage") },
                        selected = currentRoute == "dashboard",
                        onClick = { navController.navigate("dashboard") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.List, contentDescription = null) },
                        label = { Text("Chantiers") },
                        selected = currentRoute == "chantiers",
                        onClick = { navController.navigate("chantiers") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.History, contentDescription = null) },
                        label = { Text("Historique") },
                        selected = currentRoute == "history",
                        onClick = { navController.navigate("history") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                        label = { Text("Réglages") },
                        selected = currentRoute == "settings",
                        onClick = { navController.navigate("settings") }
                    )
                }
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = "dashboard",
                modifier = Modifier.padding(padding)
            ) {
                composable("dashboard") { DashboardScreen(chantierViewModel) }
                composable("chantiers") {
                    ChantierListScreen(
                        viewModel = chantierViewModel,
                        onChantierClick = { chantier ->
                            navController.navigate("detail/${chantier.id}")
                        },
                        onAddClick = { /* Navigate to add */ }
                    )
                }
                composable(
                    "detail/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id") ?: ""
                    ChantierDetailScreen(chantierId = id, onBackClick = { navController.popBackStack() }, viewModel = chantierViewModel)
                }
                composable("history") { /* HistoriqueScreen */ }
                composable("settings") { SettingsScreen(authViewModel, onLogout = {}) }
            }
        }
    }
}
