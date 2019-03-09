package com.ys.albertbaseproject.storage

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Base64
import javax.inject.Inject

class SharedPreferenceStorageImpl @Inject constructor(context: Context) : SharedPreferenceStorage {
    private var sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getSharedPreferences(): SharedPreferences {
        return this.sharedPreferences
    }

    fun getEditor(): SharedPreferences.Editor {
        return this.sharedPreferences.edit()
    }

    override fun remove(key: String) {
        val editor = getEditor()
        editor.remove(key)
        editor.apply()
        editor.commit()
    }

    override fun put(key: String, value: String) {
        val editor = getEditor()
        editor.putString(key, value)
        editor.apply()
        editor.commit()
    }

    override fun put(key: String, value: Boolean) {
        val editor = getEditor()
        editor.putBoolean(key, value)
        editor.apply()
        editor.commit()
    }

    override fun put(key: String, value: Int) {
        val editor = getEditor()
        editor.putInt(key, value)
        editor.apply()
        editor.commit()
    }

    override fun put(key: String, value: Long) {
        val editor = getEditor()
        editor.putLong(key, value)
        editor.apply()
        editor.commit()
    }

    override fun put(key: String, value: Float) {
        val editor = getEditor()
        editor.putFloat(key, value)
        editor.apply()
        editor.commit()
    }

    override fun put(key: String, values: Set<String>) {
        val editor = getEditor()
        editor.putStringSet(key, values)
        editor.apply()
        editor.commit()
    }

    override fun getString(key: String): String {
        return getSharedPreferences().getString(key, null)
    }

    override fun getBoolean(key: String): Boolean {
        return getSharedPreferences().getBoolean(key, false)
    }

    override fun getInt(key: String): Int {
        return getSharedPreferences().getInt(key, 0)
    }

    override fun getLong(key: String): Long {
        return getSharedPreferences().getLong(key, 0L)
    }

    override fun getFloat(key: String): Float {
        return getSharedPreferences().getFloat(key, 0f)
    }

    override fun getStringSet(key: String): Set<String> {
        return getSharedPreferences().getStringSet(key, null)
    }

    override fun save(alias: String, data: ByteArray) {
        val base64Encoded = Base64.encodeToString(data, Base64.DEFAULT)
        this.put(alias, base64Encoded)
    }

    override fun load(alias: String): ByteArray {
        val data = this.getString(alias)
        return Base64.decode(data, Base64.DEFAULT)
    }

    override fun deleteKey(alias: String) {
        this.remove(alias)
    }

    override fun removeAll() {
        val editor = getEditor()
        editor.clear()
        editor.apply()
        editor.commit()
    }
}