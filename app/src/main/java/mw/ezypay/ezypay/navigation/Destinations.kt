package mw.ezypay.ezypay.navigation

sealed class Destinations(val route: String) {
    object Login : Destinations("login")
    object Register : Destinations("register")
    object Home : Destinations("home")
    object Dashboard : Destinations("dashboard")
    object TransactionHistory : Destinations("transaction_history")
    object PaymentMethods : Destinations("payment_methods")
    object Profile : Destinations("profile")
}