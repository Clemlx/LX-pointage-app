package com.lxcommissioning.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lxcommissioning.app.data.models.*

@Database(
    entities = [
        User::class, 
        Chantier::class, 
        GeofenceZone::class, 
        Pointage::class, 
        Photo::class, 
        Note::class
    ],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun chantierDao(): ChantierDao
    abstract fun pointageDao(): PointageDao
    abstract fun photoDao(): PhotoDao
    abstract fun noteDao(): NoteDao
}
