package com.lxcommissioning.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lxcommissioning.app.ui.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(authViewModel: AuthViewModel, onLogout: () -> Unit) {
    var serverUrl by remember { mutableStateOf("https://api.lxcommissioning.com") }
    var syncFreq by remember { mutableStateOf("1h") }
    var offlineRetention by remember { mutableStateOf(30f) }
    var photoQuality by remember { mutableStateOf("Standard") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Paramètres") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("SERVEUR", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            OutlinedTextField(
                value = serverUrl,
                onValueChange = { serverUrl = it },
                label = { Text("URL Serveur SQL") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(onClick = { /* Test connection */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Tester la connexion")
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
            
            Text("SYNCHRONISATION", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            Text("Fréquence : $syncFreq")
            // Slider ou Dropdown ici
            
            Spacer(modifier = Modifier.height(16.dp))
            Text("Rétention offline : ${offlineRetention.toInt()} jours")
            Slider(
                value = offlineRetention,
                onValueChange = { offlineRetention = it },
                valueRange = 7f..90f
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
            
            Text("PHOTOS", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            Row(modifier = Modifier.fillMaxWidth()) {
                listOf("Basse", "Standard", "Haute").forEach { quality ->
                    Row(modifier = Modifier.weight(1f)) {
                        RadioButton(selected = photoQuality == quality, onClick = { photoQuality = quality })
                        Text(quality, modifier = Modifier.padding(top = 12.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))
            
            Button(
                onClick = { 
                    authViewModel.logout()
                    onLogout()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Déconnexion")
            }
        }
    }
}
