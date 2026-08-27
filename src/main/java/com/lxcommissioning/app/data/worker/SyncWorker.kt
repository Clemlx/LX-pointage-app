package com.lxcommissioning.app.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.lxcommissioning.app.data.local.*
import com.lxcommissioning.app.data.remote.ApiService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val apiService: ApiService,
    private val chantierDao: ChantierDao,
    private val pointageDao: PointageDao,
    private val noteDao: NoteDao
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        Timber.d("Starting background sync...")
        return try {
            // Logic for syncing pointages, notes, photos
            // Fetch habilitations
            val habs = apiService.getHabilitations()
            if (habs.isSuccessful) {
                // Update local user certs
            }
            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "Sync failed")
            Result.retry()
        }
    }
}
