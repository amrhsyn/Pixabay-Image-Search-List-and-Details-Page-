package me.ahch.pixabaysearch

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.InternalCoroutinesApi
import me.ahch.image_search_presentation.SearchScreen
import me.ahch.pixabaysearch.navigation.Argument.HITS_ARGUMENT
import me.ahch.pixabaysearch.navigation.Route
import me.ahch.pixabaysearch.ui.theme.PixabaySearchTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@InternalCoroutinesApi
@Composable
fun PixabaySearchApp() {

    PixabaySearchTheme {

        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
        ) {
            NavHost(
                navController = navController,
                startDestination = Route.SEARCH_SCREEN
            ) {
                composable(
                    route = Route.SEARCH_SCREEN
                ) {
                    SearchScreen(
                        scaffoldState = scaffoldState,
                        viewModel = hiltViewModel(),
                        navigateToDetailsScreen = {}
                    )

                }
                composable(
                    route = Route.DETAILS_SCREEN + "/{$HITS_ARGUMENT}",
                    arguments = listOf(
                        navArgument(HITS_ARGUMENT) {
                            type = NavType.StringType
                        }
                    )
                ) {
                }
            }
        }
    }
}

