package com.lxcommissioning.app.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lxcommissioning.app.data.models.UserCertification
import com.lxcommissioning.app.data.models.SyncStatus
import com.lxcommissioning.app.data.models.CertStatus

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromCertificationList(value: List<UserCertification>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toCertificationList(value: String): List<UserCertification>? {
        val listType = object : TypeToken<List<UserCertification>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String>? {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromSyncStatus(status: SyncStatus): String = status.name

    @TypeConverter
    fun toSyncStatus(value: String): SyncStatus = SyncStatus.valueOf(value)

    @TypeConverter
    fun fromCertStatus(status: CertStatus): String = status.name

    @TypeConverter
    fun toCertStatus(value: String): CertStatus = CertStatus.valueOf(value)
}
