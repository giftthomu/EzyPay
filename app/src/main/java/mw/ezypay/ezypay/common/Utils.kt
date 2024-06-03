package mw.ezypay.ezypay.common

import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun formatDate(date: Date, format: String = "yyyy-MM-dd HH:mm:ss"): String {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.format(date)
    }

    fun parseDate(dateString: String, format: String = "yyyy-MM-dd HH:mm:ss"): Date? {
        return try {
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            sdf.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun getCurrentTimestamp(): Long {
        return System.currentTimeMillis() / 1000L
    }

    fun generateUniqueId(): String {
        return UUID.randomUUID().toString()
    }
}