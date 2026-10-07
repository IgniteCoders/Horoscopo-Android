package com.example.horoscopo.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


class SessionManager(context: Context) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("horoscope_session", Context.MODE_PRIVATE)

    fun setFavorite(id: String) {
        sharedPreferences.edit {
            putString("FAVORITE_HOROSCOPE", id)
        }
    }

    fun getFavorite(): String {
        return sharedPreferences.getString("FAVORITE_HOROSCOPE", "")!!
    }

    fun isFavorite(id: String): Boolean {
        return id == getFavorite()
    }
}