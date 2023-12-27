package com.example.getmobilenumber

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.getmobilenumber.ui.theme.GetMobileNumberTheme

class MainActivity : ComponentActivity() {

    var fetchedMobileNumber by mutableStateOf("")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val phoneNumber = telephonyManager.line1Number ?: "Not available"
        fetchedMobileNumber = phoneNumber
        setContent {
            GetMobileNumberTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreenContent()
                }
            }
        }


        ///   APPLICATION LOGIC PART






    }





    }


@Preview
@Composable
fun MyScreenContent() {

    val backgroundColor = colorResource(id = R.color.myBackgroundColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        MyCard("8524")
    }
}
// ...

@Composable
fun MyCard(fetchedMobileNumber: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyInputField(fetchedMobileNumber)
            Spacer(modifier = Modifier.height(16.dp))
            MyButton()
        }
    }
}


// ...


@Composable
fun MyButton() {


    Button(
        onClick = {
            // Handle button click
            // You can perform actions like validation, sending OTP, etc. here
            // For now, let's just close the keyboard

        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text("Fetch my mobile number .")
    }
}



@Composable
fun MyInputField(userEnteredMobileNo :String) {
    var mobileNo by remember { mutableStateOf(userEnteredMobileNo) }



    OutlinedTextField(
        value = userEnteredMobileNo,
//        onValueChange = {
//            userEnteredMobileNo = it
//        },
        label = {
            Text("Mobile Number")
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        //visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    run {
        MyScreenContent()
    }
}
