package com.lxcommissioning.app.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class AuthRepository(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptedSharedPreferences: SharedPreferences =
        EncryptedSharedPreferences.create(
            context,
            "secret_shared_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    fun saveAuthToken(token: String) {
        encryptedSharedPreferences.edit().putString("auth_token", token).apply()
    }

    fun getAuthToken(): String? {
        return encryptedSharedPreferences.getString("auth_token", null)
    }

    fun saveLogin(email: String) {
        encryptedSharedPreferences.edit().putString("last_login", email).apply()
    }

    fun getLogin(): String? {
        return encryptedSharedPreferences.getString("last_login", null)
    }

    fun clearAuth() {
        encryptedSharedPreferences.edit().clear().apply()
    }
}
