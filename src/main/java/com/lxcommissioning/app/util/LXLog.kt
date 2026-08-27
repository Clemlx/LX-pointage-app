package com.lxcommissioning.app.util

import timber.log.Timber

object LXLog {
    fun action(user: String, action: String, details: String) {
        Timber.i("ACTION | User: $user | Action: $action | Details: $details")
    }

    fun error(message: String, t: Throwable? = null) {
        Timber.e(t, message)
    }
}
