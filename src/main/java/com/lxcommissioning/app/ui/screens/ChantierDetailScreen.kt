package com.lxcommissioning.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lxcommissioning.app.ui.viewmodels.ChantierViewModel
import com.lxcommissioning.app.data.models.Chantier
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChantierDetailScreen(
    chantierId: String,
    viewModel: ChantierViewModel,
    onBack: () -> Unit
) {
    val chantier by viewModel.getChantier(chantierId).collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Infos", "Temps", "Géo", "Photos", "Notes", "Habs")

    chantier?.let { c ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(c.name) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Modifier */ }) { Icon(Icons.Default.Edit, contentDescription = null) }
                        IconButton(onClick = { /* Export PDF */ }) { Icon(Icons.Default.PictureAsPdf, contentDescription = null) }
                    }
                )
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                ScrollableTabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = { Text(title) }
                        )
                    }
                }

                when (selectedTab) {
                    0 -> InfoTab(c)
                    1 -> TempsTab(c, viewModel)
                    2 -> GeoTab(c, viewModel)
                    3 -> PhotosTab(c, viewModel)
                    4 -> NotesTab(c, viewModel)
                    5 -> HabsTab(c, viewModel)
                }
            }
        }
    }
}

@Composable
fun InfoTab(chantier: Chantier) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE)
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Client: ${chantier.client}", style = MaterialTheme.typography.titleMedium)
        Text("Adresse: ${chantier.address}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Description: ${chantier.description}")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Créé le: ${dateFormat.format(chantier.createdAt)}")
    }
}

@Composable
fun TempsTab(chantier: Chantier, viewModel: ChantierViewModel) {
    Text("Tableau des pointages...", modifier = Modifier.padding(16.dp))
}

@Composable
fun GeoTab(chantier: Chantier, viewModel: ChantierViewModel) {
    Text("Carte des zones GPS...", modifier = Modifier.padding(16.dp))
}

@Composable
fun PhotosTab(chantier: Chantier, viewModel: ChantierViewModel) {
    Text("Galerie photos...", modifier = Modifier.padding(16.dp))
}

@Composable
fun NotesTab(chantier: Chantier, viewModel: ChantierViewModel) {
    Text("Timeline des notes...", modifier = Modifier.padding(16.dp))
}

@Composable
fun HabsTab(chantier: Chantier, viewModel: ChantierViewModel) {
    Text("Liste des habilitations...", modifier = Modifier.padding(16.dp))
}
