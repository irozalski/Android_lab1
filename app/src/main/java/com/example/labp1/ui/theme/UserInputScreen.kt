package com.example.labp1.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.labp1.R

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String,String>) -> Unit,
){
    Surface(
        modifier = Modifier.fillMaxSize()
        ) {
            Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
            )
            {
                TopBar("BMI CALCULATOR")

                Spacer(modifier = Modifier.size(40.dp))

                TextComponent(
                textValue = "Wprowadź swój wzrost i wage aby obliczyć BMI",
                textSize = 24.sp
                )

                Spacer(modifier = Modifier.size(60.dp))
                Row(modifier = Modifier.fillMaxWidth()) {

                    Spacer(modifier = Modifier.width(45.dp))

                    TextComponent(
                            textValue = "Sensor1",
                            textSize = 24.sp
                    )

                    Spacer(modifier = Modifier.width(90.dp))

                    TextComponent(
                            textValue = "Sensor2",
                            textSize = 24.sp
                    )

                }

                Row(modifier = Modifier.fillMaxWidth()) {

                    SensorCard(image = R.drawable.sensor1, sensorSelected = {
                        userInputViewModel.onEvent(UserDataUiEvents.UserSensorEntered(it))
                    }, isSelected = userInputViewModel.uiState.value.sensorSelected == "sensor1")

                    SensorCard(image = R.drawable.sensor2, sensorSelected = {
                        userInputViewModel.onEvent(UserDataUiEvents.UserSensorEntered(it))
                    }, isSelected = userInputViewModel.uiState.value.sensorSelected == "sensor2")
                }

                ButtonComponent(navController = rememberNavController(),
                    goToDetailsScreen = {
                        Pair(
                            userInputViewModel.uiState.value.sensorSelected,
                            userInputViewModel.uiState.value.sensorSelected
                        )
                    }
                    
                )



//                TextComponent(
//                textValue = "Wzrost",
//                textSize = 24.sp
//                )
//
//                TextInputComponent(
//                placeholderText = "Podaj swój wzrost",
//                onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.UserHeightEntered(it.toFloat()))
//                })
//
//                Spacer(modifier = Modifier.size(60.dp))
//
//                TextComponent(
//                textValue = "Waga",
//                textSize = 24.sp
//                )
//
//                TextInputComponent(
//                placeholderText = "Podaj swoją wage",
//                onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.UserWeightEntered(it.toFloat()))
//                })
            }
        }
    }



//@Preview
//@Composable
//fun UserInputScreenPreview(){
//    UserInputScreen(UserInputViewModel())
//}