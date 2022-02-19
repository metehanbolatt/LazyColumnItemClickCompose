package com.metehanbolat.lazycolumnitemclickcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.metehanbolat.lazycolumnitemclickcompose.ui.theme.LazyColumnItemClickComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnItemClickComposeTheme {
                DynamicList()
            }
        }
    }
}

@Composable
fun DynamicList() {
    val countryList = remember { mutableStateListOf("Türkiye", "İtalya", "Almanya", "Japonya") }

    LazyColumn {
        items(count = countryList.count()) {
            val country = countryList[it]

            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = country,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            }
        }
    }
}