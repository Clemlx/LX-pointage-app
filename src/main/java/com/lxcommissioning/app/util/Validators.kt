package com.lxcommissioning.app.util

object Validators {
    fun isValidEmail(email: String): Boolean {
        return email.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)$"))
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun isValidChantierName(name: String): Boolean {
        return name.isNotBlank() && name.length >= 3
    }

    fun isValidNote(note: String): Boolean {
        return note.isNotBlank() && note.length >= 5
    }
}
