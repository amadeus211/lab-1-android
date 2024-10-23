package com.example.lab1_android

import CounterViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab1_android.ui.theme.Lab1androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1androidTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: CounterViewModel = viewModel()) {
    val count = viewModel.count.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = stringResource(id = R.string.my_own_text),
            fontSize = 24.sp
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){ Text(
            text = count.toString(),
            fontSize = 54.sp
        )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4AA926),
                    contentColor = Color.White
                ),
                onClick = { viewModel.increment() },
                modifier = Modifier
                    .width(240.dp)
                    .height(88.dp)
            ) {
                Text("Додати",
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF900101),
                    contentColor = Color.White
                ),
                onClick = { viewModel.decrement() },
                modifier = Modifier
                    .width(240.dp)
                    .height(88.dp)
            ) {
                Text("Відняти",  fontSize = 22.sp)
            } }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab1androidTheme {
        MainScreen()
    }
}
