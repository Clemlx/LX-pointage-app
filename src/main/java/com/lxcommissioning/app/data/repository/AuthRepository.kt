package com.lxcommissioning.app.data.repository

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val KEY_AUTH_TOKEN = "auth_token"
        private const val KEY_USER_LOGIN = "user_login"
    }

    fun saveAuthToken(token: String) {
        sharedPreferences.edit().putString(KEY_AUTH_TOKEN, token).apply()
    }

    fun getAuthToken(): String? {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null)
    }

    fun saveLogin(login: String) {
        sharedPreferences.edit().putString(KEY_USER_LOGIN, login).apply()
    }

    fun getLogin(): String? {
        return sharedPreferences.getString(KEY_USER_LOGIN, null)
    }

    fun clearAuth() {
        sharedPreferences.edit().clear().apply()
    }
}
