package com.lxcommissioning.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent
import com.lxcommissioning.app.data.local.PointageDao
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class GeofenceBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var pointageDao: PointageDao

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        val geofencingEvent = GeofencingEvent.fromIntent(intent) ?: return

        if (geofencingEvent.hasError()) {
            Timber.e("Geofencing Error: %s", geofencingEvent.errorCode)
            return
        }

        val transition = geofencingEvent.geofenceTransition
        val triggeringGeofences = geofencingEvent.triggeringGeofences ?: return

        scope.launch {
            triggeringGeofences.forEach { geofence ->
                val requestId = geofence.requestId
                val siteId = requestId.substringBefore("_")
                
                when (transition) {
                    Geofence.GEOFENCE_TRANSITION_ENTER -> {
                        Timber.d("Entered zone: \$requestId")
                    }
                    Geofence.GEOFENCE_TRANSITION_EXIT -> {
                        Timber.d("Exited zone: \$requestId")
                        handleExit(siteId)
                    }
                }
            }
        }
    }

    private suspend fun handleExit(siteId: String) {
        val activeLog = pointageDao.getActivePointage().firstOrNull()
        if (activeLog != null && activeLog.siteId == siteId) {
            pointageDao.insertPointage(activeLog.copy(endTime = System.currentTimeMillis()))
            Timber.i("Auto-stopped tracking for site \$siteId")
        }
    }
}
