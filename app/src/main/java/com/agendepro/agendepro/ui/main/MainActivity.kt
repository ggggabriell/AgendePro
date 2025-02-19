package com.agendepro.agendepro.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.agendepro.ui.ui.theme.AgendeProTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendeProTheme {
                val viewModel: MainViewModel = getViewModel()
                MainScreen(viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AgendeProTheme {
        MainScreen(viewModel())
    }
}