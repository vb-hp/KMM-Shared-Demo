/*
 * Copyright (c) Koninklijke Philips N.V., 2020.
 * All rights reserved.
 */
package com.sample.kmm.demo.preference

expect class AppSettings {
    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
    fun putLong(key: String, value: Long)
    fun getLong(key: String): Long
    fun hasKey(key: String): Boolean
}

expect fun settings(): AppSettings