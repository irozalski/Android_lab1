package com.example.labp1.ui.theme

//import android.graphics.Color
import android.service.autofill.OnClickAction
import androidx.compose.material.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.labp1.R

@Composable
fun TopBar(top_text:String){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
        ) {
        Text(
            text = top_text,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium

        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.sensor1),
            contentDescription = "Logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar("Bmi preview")
}

@Composable
fun TextComponent(textValue:String, textSize : TextUnit, colorValue: Color = Color.Black){
    Text(
            text = textValue,
            color = colorValue,
            fontSize = textSize,
            fontWeight = FontWeight.Light

        )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue ="test123" , textSize = 24.sp)
}

// Nie używane
@Composable
fun TextInputComponent(
    placeholderText: String,
    onTextChanged: (value:String) -> Unit
    ){
    var currentValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            if (it != "") {
                currentValue = it
                onTextChanged(it)
            }
            else{
                currentValue = ""
            }

        },
        placeholder = {
            Text(text = placeholderText, fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp)
        )
}



@Composable

fun SensorCard(image:Int, isSelected : Boolean, sensorSelected : (sensorName:String) -> Unit){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = 4.dp
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (isSelected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )

        ) {
            Image(

                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        val sensorName = if (image == R.drawable.sensor1) "sensor1" else "sensor2"
                        sensorSelected(sensorName)

                    },
                painter = painterResource(id = image),
                contentDescription = "Sensor"
            )
        }
    }
}

@Composable
fun ButtonComponent(
    goToDetailsScreen : () -> Unit,
    navController: NavController
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {navController.navigate(route = Routes.WELCOME_SCREEN)}){
        TextComponent(textValue = "Go to sensor", textSize = 18.sp)
    }
}



//@Preview
//@Composable
//fun SensorCardPreview(){
//    SensorCard(image = R.drawable.logo, isSelected = true)
//}
//@Preview(showBackground = true)
//@Composable
//fun TextInputComponentPreview(){
//    TextInputComponent("Test")
//}