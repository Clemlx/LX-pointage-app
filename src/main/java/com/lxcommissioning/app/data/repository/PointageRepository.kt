package com.lxcommissioning.app.data.repository

import com.lxcommissioning.app.data.local.PointageDao
import com.lxcommissioning.app.data.models.Pointage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PointageRepository @Inject constructor(
    private val pointageDao: PointageDao
) {
    fun getAllPointages(): Flow<List<Pointage>> = pointageDao.getAllPointages()

    fun getPointagesForSite(siteId: String): Flow<List<Pointage>> =
        pointageDao.getPointagesForSite(siteId)

    fun getActivePointage(): Flow<Pointage?> = pointageDao.getActivePointage()

    suspend fun insertPointage(pointage: Pointage) {
        pointageDao.insertPointage(pointage)
    }
}
