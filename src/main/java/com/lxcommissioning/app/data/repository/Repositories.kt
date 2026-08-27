package com.lxcommissioning.app.data.repository

import com.lxcommissioning.app.data.local.*
import com.lxcommissioning.app.data.models.*
import com.lxcommissioning.app.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChantierRepository @Inject constructor(
    private val chantierDao: ChantierDao
) {
    fun getAllChantiers(): Flow<List<Chantier>> = chantierDao.getAllChantiers()
    suspend fun getChantierById(id: String) = chantierDao.getChantierById(id)
    suspend fun insertChantier(chantier: Chantier) = chantierDao.insertChantier(chantier)
    
    fun getZonesForSite(siteId: String) = chantierDao.getZonesForSite(siteId)
    suspend fun insertGeofenceZone(zone: GeofenceZone) = chantierDao.insertGeofenceZone(zone)
}

@Singleton
class PointageRepository @Inject constructor(
    private val pointageDao: PointageDao,
    private val apiService: ApiService
) {
    fun getActivePointage(): Flow<Pointage?> = pointageDao.getActivePointage()
    fun getPointagesForSite(siteId: String) = pointageDao.getPointagesForSite(siteId)
    suspend fun insertPointage(pointage: Pointage) = pointageDao.insertPointage(pointage)
}

@Singleton
class PhotoRepository @Inject constructor(
    private val photoDao: PhotoDao
) {
    fun getPhotosForSite(siteId: String) = photoDao.getPhotosForSite(siteId)
    suspend fun insertPhoto(photo: Photo) = photoDao.insertPhoto(photo)
}

@Singleton
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getNotesForSite(siteId: String) = noteDao.getNotesForSite(siteId)
    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}
