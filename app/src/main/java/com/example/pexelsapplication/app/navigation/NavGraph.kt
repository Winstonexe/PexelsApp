package com.example.pexelsapplication.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pexelsapplication.app.presentation.BookmarksScreen
import com.example.pexelsapplication.app.presentation.details.DetailsScreen
import com.example.pexelsapplication.app.presentation.home.HomeScreen
import com.example.pexelsapplication.app.presentation.splash.AnimatedSplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController,
        startDestination = startDestination
    ) {
        composable(Screen.Splash.route) { AnimatedSplashScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Bookmarks.route) { BookmarksScreen(navController) }
        composable(Screen.Details.route) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DetailsScreen(navController = navController, id = arguments.getString("id"))
        }
    }
}
