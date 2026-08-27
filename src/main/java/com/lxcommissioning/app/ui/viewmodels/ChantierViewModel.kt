package com.lxcommissioning.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lxcommissioning.app.data.models.*
import com.lxcommissioning.app.data.repository.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChantierViewModel @Inject constructor(
    private val repository: ChantierRepository,
    private val noteRepository: NoteRepository,
    private val photoRepository: PhotoRepository
) : ViewModel() {

    init {
        seedDummyData()
    }

    private fun seedDummyData() {
        viewModelScope.launch {
            val existing = repository.getAllChantiers().first()
            if (existing.isEmpty()) {
                val dummyChantiers = listOf(
                    Chantier(
                        id = "site_1",
                        name = "Centrale Hydro - Grand'Maison",
                        address = "Vaujany, Isère",
                        client = "EDF Hydro",
                        description = "Révision annuelle des groupes 1 et 2. Vérification des automates.",
                        status = "En cours",
                        budgetHours = 120.0
                    ),
                    Chantier(
                        id = "site_2",
                        name = "Poste HT - Lyon Sud",
                        address = "Vénissieux, Rhône",
                        client = "RTE",
                        description = "Remplacement des sectionneurs 225kV. Mise en service cellule 3.",
                        status = "En cours",
                        budgetHours = 450.0
                    ),
                    Chantier(
                        id = "site_3",
                        name = "Siège Social LX",
                        address = "Grenoble, Isère",
                        client = "LX Commissioning",
                        description = "Maintenance préventive TGBT et onduleurs.",
                        status = "Terminé",
                        budgetHours = 24.0
                    )
                )
                dummyChantiers.forEach { repository.insertChantier(it) }
                
                // Ajouter une note pour le test
                noteRepository.insertNote(Note(
                    siteId = "site_1",
                    content = "Prise d'eau vérifiée. RAS sur le niveau d'huile.",
                    author = "Technicien LX"
                ))
            }
        }
    }

    val allChantiers = repository.getAllChantiers().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
    )

    fun getChantier(id: String) = flow {
        emit(repository.getChantierById(id))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun getNotes(siteId: String) = noteRepository.getNotesForSite(siteId).stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
    )

    fun getPhotos(siteId: String) = photoRepository.getPhotosForSite(siteId).stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
    )

    fun addNote(siteId: String, content: String, author: String) {
        viewModelScope.launch {
            noteRepository.insertNote(Note(siteId = siteId, content = content, author = author))
        }
    }

    fun saveChantier(chantier: Chantier) {
        viewModelScope.launch {
            repository.insertChantier(chantier)
        }
    }

    fun saveGeofence(zone: GeofenceZone) {
        viewModelScope.launch {
            repository.insertGeofenceZone(zone)
        }
    }
}
