package com.example.labp1.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {
    
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserHeightEntered -> {
                uiState.value = uiState.value.copy(
                    heightEntered = event.height
                )
            }

            is UserDataUiEvents.UserWeightEntered -> {
                uiState.value = uiState.value.copy(
                    weightEntered = event.weight
                )
            }

            is UserDataUiEvents.UserSensorEntered -> {
                uiState.value = uiState.value.copy(
                    sensorSelected = event.sensorValue
                )
            }
            //else -> {}
        }
    }
}

data class UserInputScreenState(
    var heightEntered : Float = 0.0f,
    var weightEntered : Float = 0.0f,
    var sensorSelected : String = ""
)

sealed class UserDataUiEvents{
    data class UserHeightEntered(val height:Float) : UserDataUiEvents()
    data class UserWeightEntered(val weight:Float) : UserDataUiEvents()
    data class UserSensorEntered(val sensorValue:String) : UserDataUiEvents()
}

