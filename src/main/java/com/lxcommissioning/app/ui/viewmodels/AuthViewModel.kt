package com.lxcommissioning.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lxcommissioning.app.data.repository.AuthRepository
import com.lxcommissioning.app.data.remote.ApiService
import com.lxcommissioning.app.data.remote.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val apiService: ApiService,
    private val userDao: com.lxcommissioning.app.data.local.UserDao
) : ViewModel() {

    init {
        seedUser()
    }

    private fun seedUser() {
        viewModelScope.launch {
            userDao.insertUser(com.lxcommissioning.app.data.models.User(
                name = "Admin LX",
                email = "admin@lx.fr",
                certifications = listOf(
                    com.lxcommissioning.app.data.models.UserCertification(
                        name = "HAE (Habilitation Électrique)",
                        expirationTimestamp = System.currentTimeMillis() + 1000000000L,
                        status = com.lxcommissioning.app.data.models.CertStatus.VALID
                    ),
                    com.lxcommissioning.app.data.models.UserCertification(
                        name = "SST (Sauvetage Secourisme)",
                        expirationTimestamp = System.currentTimeMillis() - 86400000L, // Expiré hier
                        status = com.lxcommissioning.app.data.models.CertStatus.EXPIRED
                    )
                )
            ))
        }
    }

    private val _isLoggedIn = MutableStateFlow(authRepository.getAuthToken() != null)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun login(email: String, password: String) {
        val trimmedEmail = email.trim()
        val trimmedPassword = password.trim()
        
        viewModelScope.launch {
            // BYPASS POUR DÉVELOPPEMENT / TEST
            if (trimmedEmail == "admin@lx.fr" && trimmedPassword == "admin") {
                authRepository.saveAuthToken("fake_token_for_dev")
                authRepository.saveLogin(trimmedEmail)
                _isLoggedIn.value = true
                return@launch
            }

            try {
                val response = apiService.login(LoginRequest(trimmedEmail, trimmedPassword))
                if (response.isSuccessful && response.body() != null) {
                    val loginResponse = response.body()!!
                    authRepository.saveAuthToken(loginResponse.token)
                    authRepository.saveLogin(trimmedEmail)
                    _isLoggedIn.value = true
                } else {
                    _error.value = "Identifiants incorrects"
                }
            } catch (e: Exception) {
                _error.value = "Erreur réseau : ${e.message}"
            }
        }
    }

    fun logout() {
        authRepository.clearAuth()
        _isLoggedIn.value = false
    }

    fun clearError() {
        _error.value = null
    }
}
