package com.dev_shivam.simplate.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_shivam.simplate.R
import com.dev_shivam.simplate.ui.widgets.AddLanguageItemList
import com.dev_shivam.simplate.ui.widgets.SimpleSearchBar


@Composable
fun AddLanguagesScreen() {

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            SimpleSearchBar { textChanged ->
                //to perform Search
            }

            Spacer(modifier = Modifier.height(10.dp))

            AddLanguageItemList()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun preview() {
    AddLanguagesScreen()
}