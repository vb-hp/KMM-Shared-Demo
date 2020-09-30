package com.sample.kmm.demo.preference

import android.preference.PreferenceManager
import com.sample.kmm.demo.context.appContext

actual class AppSettings {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext)

    actual fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    actual fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        sharedPreferences.getBoolean(key, defaultValue)

    actual fun putLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    actual fun getLong(key: String): Long {
        return sharedPreferences.getLong(key, 0L)
    }

    actual fun hasKey(key: String): Boolean =
        sharedPreferences.contains(key)
}

actual fun settings(): AppSettings = AppSettings()