package com.lxcommissioning.app.location

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices
import com.lxcommissioning.app.data.models.GeofenceZone
import com.lxcommissioning.app.receiver.GeofenceBroadcastReceiver
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeofenceManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val geofencingClient = LocationServices.getGeofencingClient(context)

    private val geofencePendingIntent: PendingIntent by lazy {
        val intent = Intent(context, GeofenceBroadcastReceiver::class.java)
        PendingIntent.getBroadcast(
            context, 
            0, 
            intent, 
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )
    }

    @SuppressLint("MissingPermission")
    fun registerGeofences(siteId: String, zones: List<GeofenceZone>) {
        if (zones.isEmpty()) return

        val geofenceList = zones.map { zone ->
            Geofence.Builder()
                .setRequestId("${siteId}_${zone.id}")
                .setCircularRegion(zone.latitude, zone.longitude, zone.radius)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_EXIT)
                .build()
        }

        val request = GeofencingRequest.Builder()
            .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
            .addGeofences(geofenceList)
            .build()

        geofencingClient.addGeofences(request, geofencePendingIntent).run {
            addOnSuccessListener { Timber.d("Geofences registered for site \$siteId") }
            addOnFailureListener { e -> Timber.e(e, "Failed to register geofences") }
        }
    }

    fun removeGeofences(siteId: String, zoneIds: List<String>) {
        val ids = zoneIds.map { "${siteId}_$it" }
        geofencingClient.removeGeofences(ids).addOnSuccessListener {
            Timber.d("Geofences removed for site \$siteId")
        }
    }
}
