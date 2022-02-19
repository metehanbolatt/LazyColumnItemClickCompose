package com.metehanbolat.lazycolumnitemclickcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.metehanbolat.lazycolumnitemclickcompose.ui.theme.LazyColumnItemClickComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnItemClickComposeTheme {
                NavigationScreen()
            }
        }
    }
}

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            DynamicList(navController = navController)
        }
        composable("details/{countryName}", arguments = listOf(
            navArgument("countryName") {
                type = NavType.StringType
            }
        )) {
            val countryName = it.arguments?.getString("countryName")
            countryName?.let {
                DetailsCountry(countryName = countryName)
            }
        }
    }
}

@Composable
fun DynamicList(navController: NavController) {
    val countryList = remember { mutableStateListOf("Türkiye", "İtalya", "Almanya", "Japonya") }

    LazyColumn {
        items(count = countryList.count()) {
            val country = countryList[it]

            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.clickable {
                        Log.d("List", "$country row selected!")
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = country,
                            modifier = Modifier.padding(5.dp)
                        )

                        OutlinedButton(onClick = {
                            navController.navigate("details/$country")
                        }) {
                            Text(text = "Detail")
                        }
                    }
                }
            }
        }
    }
}