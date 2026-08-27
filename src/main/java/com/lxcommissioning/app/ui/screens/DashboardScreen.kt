package com.lxcommissioning.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lxcommissioning.app.ui.viewmodels.ChantierViewModel
import com.lxcommissioning.app.data.models.Chantier

@Composable
fun DashboardScreen(viewModel: ChantierViewModel) {
    val chantiers by viewModel.allChantiers.collectAsState()
    var isTracking by remember { mutableStateOf(false) } // À lier au PointageViewModel plus tard
    
    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        Surface(
            color = MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Chantier actif", style = MaterialTheme.typography.labelSmall)
                Text(
                    chantiers.firstOrNull()?.name ?: "Aucun chantier actif",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { isTracking = !isTracking },
                modifier = Modifier.fillMaxWidth().height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isTracking) Color.Red else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    if (isTracking) "⏹ Arrêter pointage" else "▶ Démarrer pointage",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
            if (isTracking) {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Temps en cours : 01:24:05", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
