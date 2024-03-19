package com.dev_shivam.simplate.ui.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.dev_shivam.simplate.ui.theme.SimplateColorScheme

@Composable
fun MyTextField(textState: MutableState<String>){

    BasicTextField(
        cursorBrush = SolidColor(Color.Black),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = Color.Black
        ),
        value = textState.value,
        onValueChange = {textState.value = it},
        modifier = Modifier
            .height(207.dp)
            .padding(horizontal = 27.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.medium
            )
            .padding(5.dp)
    )
}