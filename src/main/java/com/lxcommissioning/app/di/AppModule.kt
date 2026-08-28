package com.lxcommissioning.app.di

import android.content.Context
import androidx.room.Room
import com.lxcommissioning.app.data.local.AppDatabase
import com.lxcommissioning.app.data.repository.AuthRepository
import com.lxcommissioning.app.data.repository.ChantierRepository
import com.lxcommissioning.app.data.repository.PointageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import com.lxcommissioning.app.data.repository.PhotoRepository
import com.lxcommissioning.app.data.repository.NoteRepository
import com.lxcommissioning.app.data.remote.ApiService

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "lx_commissioning.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideAuthRepository(@ApplicationContext context: Context): AuthRepository {
        return AuthRepository(context)
    }

    @Singleton
    @Provides
    fun provideChantierRepository(database: AppDatabase): ChantierRepository {
        return ChantierRepository(database.chantierDao())
    }

    @Singleton
    @Provides
    fun providePointageRepository(database: AppDatabase, apiService: ApiService): PointageRepository {
        return PointageRepository(database.pointageDao(), apiService)
    }

    @Singleton
    @Provides
    fun providePhotoRepository(database: AppDatabase): PhotoRepository {
        return PhotoRepository(database.photoDao())
    }

    @Singleton
    @Provides
    fun provideNoteRepository(database: AppDatabase): NoteRepository {
        return NoteRepository(database.noteDao())
    }
}
