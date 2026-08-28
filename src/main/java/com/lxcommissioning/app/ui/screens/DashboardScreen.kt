package com.lxcommissioning.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lxcommissioning.app.ui.viewmodels.ChantierViewModel
import com.lxcommissioning.app.ui.viewmodels.PointageViewModel

@Composable
fun DashboardScreen(
    chantierViewModel: ChantierViewModel = hiltViewModel(),
    pointageViewModel: PointageViewModel = hiltViewModel()
) {
    val chantiers by chantierViewModel.allChantiers.collectAsState()
    val isTracking by pointageViewModel.isTracking.collectAsState()
    val elapsedSeconds by pointageViewModel.elapsedSeconds.collectAsState()
    val currentSiteId by pointageViewModel.currentSiteId.collectAsState()

    val activeChantier = chantiers.firstOrNull { it.id == currentSiteId }

    Column(modifier = Modifier.fillMaxSize()) {
        Surface(
            color = MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Chantier actif", style = MaterialTheme.typography.labelSmall)
                Text(
                    activeChantier?.name ?: "Aucun pointage",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (isTracking) {
                Text(
                    text = pointageViewModel.formatTime(elapsedSeconds),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
            }

            if (!isTracking) {
                Text("Sélectionne un chantier:", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(modifier = Modifier.fillMaxWidth(0.8f)) {
                    items(chantiers.size) { index ->
                        val chantier = chantiers[index]
                        Button(
                            onClick = { pointageViewModel.startTracking(chantier.id) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Text(chantier.name)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    if (isTracking) {
                        pointageViewModel.stopTracking()
                    } else if (activeChantier != null) {
                        pointageViewModel.startTracking(activeChantier.id)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isTracking) Color.Red 
                                     else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    if (isTracking) "⏹ Arrêter pointage" else "▶ Démarrer pointage",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}
