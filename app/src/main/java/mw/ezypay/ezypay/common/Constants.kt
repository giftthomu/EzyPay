package mw.ezypay.ezypay.common

object ApiConstants {
    const val BASE_URL = "*"
    const val LOGIN_ENDPOINT = "auth/login"
    const val REGISTER_ENDPOINT = "auth/register"
    const val USER_PROFILE_ENDPOINT = "user/profile"
    const val TRANSACTIONS_ENDPOINT = "transactions"
    const val PAYMENT_METHODS_ENDPOINT = "payment/methods"
    const val API_KEY = "*"
}


object PrefsConstants {
    const val PREFS_NAME = "*"
    const val PREFS_USER_TOKEN = "*"
    const val PREFS_USER_ID = "*"
    const val PREFS_IS_LOGGED_IN = "*"
}


object IntentConstants {
    const val EXTRA_USER_ID = "extra_user_id"
    const val EXTRA_TRANSACTION_ID = "extra_transaction_id"
    const val EXTRA_PAYMENT_METHOD_ID = "extra_payment_method_id"
}

object ErrorMessages {
    const val NETWORK_ERROR = "Network error. Please try again."
    const val AUTHENTICATION_ERROR = "Authentication failed. Please check your credentials."
    const val UNKNOWN_ERROR = "An unknown error occurred. Please try again later."
}

object AppConfig {
    const val DEBUG_MODE = true
    const val DEFAULT_TIMEOUT = 30L // seconds
    const val SUPPORT_EMAIL = "*"
}

object UiConstants {
    const val DEFAULT_PADDING = 16 // dp
    const val DEFAULT_MARGIN = 16 // dp
    const val BUTTON_HEIGHT = 48 // dp
}

object NotificationConstants {
    const val CHANNEL_ID_GENERAL = "general_notifications"
    const val CHANNEL_NAME_GENERAL = "General Notifications"
    const val CHANNEL_ID_TRANSACTIONS = "transaction_notifications"
    const val CHANNEL_NAME_TRANSACTIONS = "Transaction Notifications"
}