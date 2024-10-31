package com.example.realviewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.realviewmodel.store.presentation.products_screen.ProductsScreen
import com.example.realviewmodel.ui.theme.RealViewModelTheme
import com.example.realviewmodel.util.Event
import com.example.realviewmodel.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealViewModelTheme {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle) {
                    repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                        EventBus.events.collect{event->
                            if(event is Event.Toast){
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                ProductsScreen()
            }
        }
    }
}
