package com.company.projectName.android

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.unit.dp
import com.company.projectName.android.State.*
import com.company.projectName.android.view.Data
import com.company.projectName.android.view.Initial
import com.company.projectName.android.view.Invalidatable
import com.company.projectName.android.view.Progress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun App() {
    MaterialTheme {
        Scaffold(topAppBar = { MyAppBar() }) {
            Root()
        }
    }
}

@Composable
fun MyAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "My app"
            )
        },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Composable
fun Root() {
    val currentState = state<State> { InitialState }

    fun onClick() {
        CoroutineScope(Dispatchers.IO).launch {
            val oldState = currentState.value
            currentState.value = ProgressState(oldState)

            delay(4000) // todo: for test

            val dataArg = "data data data data"
            currentState.value = InvalidatableState(DataState(dataArg), ::onClick)
        }
    }

    RenderState(currentState.value)
}

@Composable
fun RenderState(state: State) {
    when (state) {
        InitialState -> Initial()
        is DataState -> Data(state.data)
        is ProgressState -> Progress { RenderState(state.oldState) }
        is InvalidatableState -> Invalidatable({ RenderState(state.oldState) }, state.onClick)
    }
}

sealed class State {
    object InitialState : State()
    class DataState(val data: String) : State()
    class ProgressState(val oldState: State) : State()
    class InvalidatableState(val oldState: State, val onClick: () -> Unit) : State()
}
