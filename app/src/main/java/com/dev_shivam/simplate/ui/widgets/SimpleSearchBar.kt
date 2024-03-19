package com.dev_shivam.simplate.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun SimpleSearchBar(
    onTextChange: (String)-> Unit
) {

    var currentText by rememberSaveable {
        mutableStateOf("")
    }

    OutlinedTextField(
        placeholder = {
            Text(
                text = "Search for Language",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black.copy(alpha = 0.5f)
            )
        },
        textStyle = MaterialTheme.typography.titleLarge.copy(
            color = Color.Black,
            textAlign = TextAlign.Center
        ),
        shape = MaterialTheme.shapes.large,
        value = currentText,
        onValueChange = {
            currentText = it
            onTextChange(currentText)
        },
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 27.dp)
            .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.large)
    )
}