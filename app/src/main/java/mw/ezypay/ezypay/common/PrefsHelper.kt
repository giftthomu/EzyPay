package mw.ezypay.ezypay.common

import android.content.Context
import android.content.SharedPreferences

object PrefsHelper {

    private const val PREFS_NAME = "*"
    private const val KEY_USER_TOKEN = "user_token"
    private const val KEY_USER_ID = "user_id"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveUserToken(context: Context, token: String) {
        getPrefs(context).edit().putString(KEY_USER_TOKEN, token).apply()
    }

    fun getUserToken(context: Context): String? {
        return getPrefs(context).getString(KEY_USER_TOKEN, null)
    }

    fun saveUserId(context: Context, userId: String) {
        getPrefs(context).edit().putString(KEY_USER_ID, userId).apply()
    }

    fun getUserId(context: Context): String? {
        return getPrefs(context).getString(KEY_USER_ID, null)
    }

    fun setIsLoggedIn(context: Context, isLoggedIn: Boolean) {
        getPrefs(context).edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()
    }

    fun isLoggedIn(context: Context): Boolean {
        return getPrefs(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun clearPrefs(context: Context) {
        getPrefs(context).edit().clear().apply()
    }
}