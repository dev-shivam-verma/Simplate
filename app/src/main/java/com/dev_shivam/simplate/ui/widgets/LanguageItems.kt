package com.dev_shivam.simplate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_shivam.simplate.R
import com.dev_shivam.simplate.ui.theme.SimplateColorScheme


@Composable
fun LanguageItem(ifSelected: Boolean, language: String, onClick: () -> Unit) {
    val backColor =
        if (ifSelected) SimplateColorScheme.color.secondaryContainer else SimplateColorScheme.color.tertiaryContainer
    val fontColor =
        if (ifSelected) SimplateColorScheme.color.onSecondaryContainer else SimplateColorScheme.color.onTertiaryContainer

    Surface(
        color = backColor,
        modifier = Modifier
            .padding(horizontal = 3.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 7.dp)
                .padding(bottom = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = language, color = fontColor, style = MaterialTheme.typography.titleMedium)

            if (ifSelected) {
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.tick_in_circle),
                    contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun OneSelectedLanguageList() {
    var selectedLanguage: Int? by remember {
        mutableStateOf(null)
    }

    val languageList = listOf(
        "af: Afrikaans",
        "sq: Albanian",
        "am: Amharic",
        "ar: Arabic",
        "hy: Armenian",
        "az: Azerbaijani",
        "eu: Basque",
        "be: Belarusian"
    )


    LazyRow(
        modifier = Modifier
            .padding(vertical = 5.dp)
    ) {
        items(languageList.size) {
            LanguageItem(ifSelected = selectedLanguage == it, language = languageList[it]) {
                selectedLanguage = it
            }
        }
    }
}