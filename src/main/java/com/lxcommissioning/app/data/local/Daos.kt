package com.lxcommissioning.app.data.local

import androidx.room.*
import com.lxcommissioning.app.data.models.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM User LIMIT 1")
    fun getUser(): Flow<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
}

@Dao
interface ChantierDao {
    @Query("SELECT * FROM Chantier ORDER BY updatedAt DESC")
    fun getAllChantiers(): Flow<List<Chantier>>

    @Query("SELECT * FROM Chantier WHERE id = :id")
    suspend fun getChantierById(id: String): Chantier?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChantier(chantier: Chantier)

    @Delete
    suspend fun deleteChantier(chantier: Chantier)

    @Query("SELECT * FROM GeofenceZone WHERE siteId = :siteId")
    fun getZonesForSite(siteId: String): Flow<List<GeofenceZone>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGeofenceZone(zone: GeofenceZone)
}

@Dao
interface PointageDao {
    @Query("SELECT * FROM Pointage ORDER BY startTime DESC")
    fun getAllPointages(): Flow<List<Pointage>>

    @Query("SELECT * FROM Pointage WHERE siteId = :siteId ORDER BY startTime DESC")
    fun getPointagesForSite(siteId: String): Flow<List<Pointage>>

    @Query("SELECT * FROM Pointage WHERE endTime IS NULL LIMIT 1")
    fun getActivePointage(): Flow<Pointage?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPointage(pointage: Pointage)
}

@Dao
interface PhotoDao {
    @Query("SELECT * FROM Photo WHERE siteId = :siteId ORDER BY timestamp DESC")
    fun getPhotosForSite(siteId: String): Flow<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: Photo)
}

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note WHERE siteId = :siteId ORDER BY timestamp DESC")
    fun getNotesForSite(siteId: String): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}
