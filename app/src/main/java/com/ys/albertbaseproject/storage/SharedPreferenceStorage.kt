package com.ys.albertbaseproject.storage

interface SharedPreferenceStorage: Storage {
    fun remove(key: String)

    fun put(key: String, value: String)

    fun put(key: String, value: Boolean)

    fun put(key: String, value: Int)

    fun put(key: String, value: Long)

    fun put(key: String, value: Float)

    fun put(key: String, values: Set<String>)

    fun getString(key: String): String

    fun getBoolean(key: String): Boolean

    fun getInt(key: String): Int

    fun getLong(key: String): Long

    fun getFloat(key: String): Float

    fun getStringSet(key: String): Set<String>

    fun removeAll()
}