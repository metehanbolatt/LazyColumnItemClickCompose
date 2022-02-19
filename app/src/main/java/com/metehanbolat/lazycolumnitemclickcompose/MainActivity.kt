package com.metehanbolat.lazycolumnitemclickcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.lazycolumnitemclickcompose.ui.theme.LazyColumnItemClickComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnItemClickComposeTheme {

            }
        }
    }
}
