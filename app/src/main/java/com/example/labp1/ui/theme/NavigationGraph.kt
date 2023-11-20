package com.example.labp1.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable

fun NavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){

val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN){
        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel, showWelcomeScreen =  {
                println(it.first)
                println(it.first)
                //navController.navigate(Routes.WELCOME_SCREEN)
            })
        }

        composable(Routes.WELCOME_SCREEN){
             WelcomeScreen()
        }
    }
}