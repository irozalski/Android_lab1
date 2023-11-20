package com.example.labp1.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable

fun NavigationGraph(

     navController : NavHostController


){

    NavHost(navController = navController,
            startDestination = Routes.MAIN_SCREEN){
        composable(
            route = Routes.MAIN_SCREEN){
                MenuScreen(
                    navController = navController
                )
            }

        composable(
            route = Routes.FIRST_SENSOR_SCREEN){
                FirstSensorScreen()
            }

        composable(
            route = Routes.SECOND_SENSOR_SCREEN){
                SecondSensorScreen()
            }
        }
    }
