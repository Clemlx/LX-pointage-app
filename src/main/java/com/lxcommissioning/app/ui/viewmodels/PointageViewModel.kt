package com.lxcommissioning.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lxcommissioning.app.data.models.Pointage
import com.lxcommissioning.app.data.repository.PointageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PointageViewModel @Inject constructor(
    private val pointageRepository: PointageRepository
) : ViewModel() {

    private val _isTracking = MutableStateFlow(false)
    val isTracking = _isTracking.asStateFlow()

    private val _elapsedSeconds = MutableStateFlow(0L)
    val elapsedSeconds = _elapsedSeconds.asStateFlow()

    private val _currentSiteId = MutableStateFlow<String?>(null)
    val currentSiteId = _currentSiteId.asStateFlow()

    private val _currentPointage = MutableStateFlow<Pointage?>(null)
    val currentPointage = _currentPointage.asStateFlow()

    fun startTracking(siteId: String) {
        viewModelScope.launch {
            val pointage = Pointage(
                siteId = siteId,
                startTime = System.currentTimeMillis(),
                isManual = false
            )
            pointageRepository.insertPointage(pointage)
            _currentPointage.value = pointage
            _currentSiteId.value = siteId
            _isTracking.value = true
            _elapsedSeconds.value = 0L
            startTimer()
        }
    }

    fun stopTracking() {
        viewModelScope.launch {
            _isTracking.value = false
            val pointage = _currentPointage.value?.copy(
                endTime = System.currentTimeMillis(),
                durationMinutes = _elapsedSeconds.value / 60
            )
            if (pointage != null) {
                pointageRepository.insertPointage(pointage)
            }
            _currentPointage.value = null
            _currentSiteId.value = null
            _elapsedSeconds.value = 0L
        }
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (_isTracking.value) {
                delay(1000)
                _elapsedSeconds.value += 1
            }
        }
    }

    fun formatTime(seconds: Long): String {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}
