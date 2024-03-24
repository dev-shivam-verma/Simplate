package com.dev_shivam.simplate.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_shivam.simplate.R
import com.dev_shivam.simplate.ui.theme.simplatePrimary
import com.dev_shivam.simplate.ui.widgets.AddLanguageItemList
import com.dev_shivam.simplate.ui.widgets.SimpleSearchBar


@Composable
fun AddLanguagesScreen(onAddSelectedLanguages: () -> Unit,onBackPressed: ()->Unit) {


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.Start) {

            Spacer(modifier = Modifier.height(35.dp))

            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {onBackPressed()}
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = onAddSelectedLanguages,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(simplatePrimary)) {
                Text(text = "Add selected languages", color = Color.White)
            }

            Spacer(modifier = Modifier.height(10.dp))

            AddLanguageItemList()
        }
    }
}


