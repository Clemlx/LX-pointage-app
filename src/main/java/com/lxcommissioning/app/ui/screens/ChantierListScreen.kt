package com.lxcommissioning.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lxcommissioning.app.ui.viewmodels.ChantierViewModel
import com.lxcommissioning.app.data.models.Chantier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChantierListScreen(
    viewModel: ChantierViewModel,
    onChantierClick: (Chantier) -> Unit,
    onAddClick: () -> Unit
) {
    val chantiers by viewModel.allChantiers.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mes Chantiers") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Nouveau chantier")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            items(chantiers) { chantier ->
                ChantierCard(chantier, onClick = { onChantierClick(chantier) })
            }
        }
    }
}

@Composable
fun ChantierCard(chantier: Chantier, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable(onClick = onClick)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(chantier.name, style = MaterialTheme.typography.titleMedium)
                Text(chantier.address, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("État: ${chantier.status}", color = MaterialTheme.colorScheme.primary)
            }
            Icon(Icons.Default.ChevronRight, contentDescription = null)
        }
    }
}
