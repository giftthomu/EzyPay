package mw.ezypay.ezypay.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mw.ezypay.ezypay.screens.HomeScreen
import mw.ezypay.ezypay.screens.aunthetication.LoginScreen
import mw.ezypay.ezypay.screens.aunthetication.RegisterScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Destinations.Login.route) { LoginScreen(navController) }
        composable(Destinations.Register.route) { RegisterScreen(navController) }
        composable(Destinations.Home.route) { HomeScreen(navController) }

        /* composable(Destinations.Dashboard.route) { DashboardScreen(navController) }
         composable(Destinations.TransactionHistory.route) { TransactionHistoryScreen(navController) }
         composable(Destinations.PaymentMethods.route) { PaymentMethodsScreen(navController) }
         composable(Destinations.Profile.route) { ProfileScreen(navController) } */
    }
}