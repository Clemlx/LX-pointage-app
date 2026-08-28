package com.lxcommissioning.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lxcommissioning.app.data.models.Chantier
import com.lxcommissioning.app.ui.viewmodels.ChantierViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChantierDetailScreen(
    chantierId: String,
    onBackClick: () -> Unit,
    viewModel: ChantierViewModel = hiltViewModel()
) {
    val chantier by viewModel.getChantier(chantierId).collectAsState(null)
    val notes by viewModel.getNotes(chantierId).collectAsState(emptyList())
    var noteText by remember { mutableStateOf("") }

    if (chantier == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }
    
    val currentChantier = chantier!!

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentChantier.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Text("Adresse: ${currentChantier.address}", style = MaterialTheme.typography.bodyLarge)
                Text("Client: ${currentChantier.client}", style = MaterialTheme.typography.bodyLarge)
                Text("Status: ${currentChantier.status}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text("Ajouter une note:", style = MaterialTheme.typography.titleMedium)
                TextField(
                    value = noteText,
                    onValueChange = { noteText = it },
                    label = { Text("Note") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Button(
                    onClick = {
                        if (noteText.isNotBlank()) {
                            viewModel.addNote(currentChantier.id, noteText, "Technicien LX")
                            noteText = ""
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ajouter")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text("Notes (${notes.size}):", style = MaterialTheme.typography.titleMedium)
            }

            items(notes) { note ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(note.content, style = MaterialTheme.typography.bodyMedium)
                        Text(
                            note.author ?: "Unknown",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}
