package com.company.projectName.android.view

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.Button

@Composable
fun Invalidatable(context: () -> Unit, oldState: @Composable() () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Button(
            text = {
                Text(text = "Invalidate")
            },
            onClick = {
                context()
            }
        )
        oldState()
    }
}