package com.company.projectName.android

//@Composable
//fun App() {
//    MaterialTheme {
//        Scaffold(topAppBar = { MyAppBar() }) {
//            Root()
//        }
//    }
//}
//
//@Composable
//fun Root() {
//    val currentState = state<State> { InitialState }
//
//    Render(currentState.value) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val oldState = currentState.value
//            currentState.value = ProgressState(oldState)
//
//            delay(4000) // todo: for test
//
//            val dataArg = "data data data data"
//            currentState.value = InvalidatableState(DataState(dataArg))
//        }
//    }
//}
//
//@Composable
//fun Render(state: State, onClick: () -> Unit) {
//    when (state) {
//        InitialState -> Initial()
//        is DataState -> Data(state.data)
//        is ProgressState -> Progress { Render(state.oldState, onClick) }
//        is InvalidatableState -> Invalidatable({ Render(state.oldState, onClick) }, onClick)
//    }
//}
//
//sealed class State {
//    object InitialState : State()
//    class DataState(val data: String) : State()
//    class ProgressState(val oldState: State) : State()
//    class InvalidatableState(val oldState: State) : State()
//}
