package com.sample.kmm.demo.preference

import platform.Foundation.NSUserDefaults

actual class AppSettings {
    private val delegate: NSUserDefaults = NSUserDefaults.standardUserDefaults()

    actual fun putBoolean(key: String, value: Boolean) {
        delegate.setBool(value, key)
    }

    actual fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        if (hasKey(key)) delegate.boolForKey(key) else defaultValue

    actual fun hasKey(key: String): Boolean = delegate.objectForKey(key) != null

    actual fun putLong(key: String, value: Long) {
        delegate.setInteger(value, key)
    }

    actual fun getLong(key: String): Long =
        if (hasKey(key)) delegate.integerForKey(key) else 0L

}

actual fun settings(): AppSettings = AppSettings()