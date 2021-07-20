package com.example.khind_project.repos

import android.content.Context
import android.content.SharedPreferences

class SharePrefRepository(val context: Context) {
    val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = pref.edit()

    private fun String.put(long: Float) {
        editor.putFloat(this, long)
        editor.apply()
    }

    private fun String.put(string: String) {
        editor.putString(this, string)
        editor.apply()
    }

    private fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.apply()
    }

    private fun String.getFloat() = pref.getFloat(this, 0.0F)

    private fun String.getString() = pref.getString(this, "")!!


    private fun String.getBoolean() = pref.getBoolean(this, false)


    fun putUsername(uname: String) {
        USERNAME.put(uname)
    }

    fun putPassword(pass: String) {
        PASSWORD.put(pass)
    }

    fun putAlarm(alarm: String) {
        ALARM.put(alarm)
    }

    fun putLongitude(longitude: Float) {
        LONGITUDE.put(longitude)
    }

    fun putLatitude(latitude: Float) {
        LATITUDE.put(latitude)
    }

    fun getUsername() = USERNAME.getString()
    fun getPassword() = PASSWORD.getString()
    fun getAlarm() = ALARM.getString()
    fun getLongitude() = LONGITUDE.getFloat()
    fun getLatitude() = LATITUDE.getFloat()

    fun isLoggedIn(status: Boolean) {
        LOGGED_IN.put(status)
    }

    fun checkLoggedIn() = LOGGED_IN.getBoolean()

    fun putToken(Token: String, RefreshToken: String) {
        TOKEN.put(Token)
        REFRESH_TOKEN.put(RefreshToken)
    }

    fun getToken() = TOKEN.getString()
    fun getRefeshToken() = REFRESH_TOKEN.getString()

    fun putSensorId(id: String) {
        SENSOR_ID.put(id)
    }

    fun getSensorId() = SENSOR_ID.getString()

    fun checkDataRequestStatus() = SENSOR_DATA_REQUEST_STATUS.getBoolean()


    fun clear() {
        editor.clear()
        editor.apply()
    }

}
