package com.lxcommissioning.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

enum class SyncStatus {
    PENDING, SYNCED, ERROR
}

enum class CertStatus {
    VALID, WARNING, EXPIRED
}

@Entity
data class User(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val pin: String? = null,
    val certifications: List<UserCertification> = emptyList()
)

data class UserCertification(
    val name: String,
    val expirationTimestamp: Long,
    val status: CertStatus,
    val pdfUri: String? = null
)

@Entity
data class Chantier(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val address: String,
    val client: String,
    val description: String,
    val status: String, // En cours, Terminé, Archivé
    val budgetHours: Double,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val requiredCertifications: List<String> = emptyList()
)

@Entity
data class GeofenceZone(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val siteId: String,
    val name: String, // Site 1, Site 2, Site 3
    val latitude: Double,
    val longitude: Double,
    val radius: Float,
    val isActive: Boolean = true
)

@Entity
data class Pointage(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val siteId: String,
    val startTime: Long,
    val endTime: Long? = null,
    val durationMinutes: Long = 0,
    val syncStatus: SyncStatus = SyncStatus.PENDING,
    val isManual: Boolean = false
)

@Entity
data class Photo(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val siteId: String,
    val uri: String,
    val remoteUrl: String? = null,
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long,
    val note: String? = null,
    val syncStatus: SyncStatus = SyncStatus.PENDING,
    val originalRetentionUntil: Long? = null // 7 jours après capture
)

@Entity
data class Note(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val siteId: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val author: String,
    val syncStatus: SyncStatus = SyncStatus.PENDING
)
