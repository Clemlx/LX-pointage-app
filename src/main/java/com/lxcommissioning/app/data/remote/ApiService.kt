package com.lxcommissioning.app.data.remote

import com.lxcommissioning.app.data.models.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("sync/pointages")
    suspend fun syncPointages(@Body logs: List<Pointage>): Response<Unit>
    
    @POST("sync/notes")
    suspend fun syncNotes(@Body notes: List<Note>): Response<Unit>

    @Multipart
    @POST("sync/photos")
    suspend fun uploadPhoto(
        @Part photo: MultipartBody.Part,
        @Part("metadata") metadata: PhotoMetadata
    ): Response<PhotoUploadResponse>

    @GET("user/habilitations")
    suspend fun getHabilitations(): Response<List<UserCertification>>
}

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String, val user: User)
data class PhotoMetadata(val siteId: String, val lat: Double, val lon: Double, val timestamp: Long)
data class PhotoUploadResponse(val remoteUrl: String)
