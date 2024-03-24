package com.dev_shivam.simplate.ui.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_shivam.simplate.R
import com.dev_shivam.simplate.data.Language
import com.dev_shivam.simplate.ui.StateManager
import com.dev_shivam.simplate.ui.theme.lightSurfacePrimary
import com.dev_shivam.simplate.ui.theme.simplatePrimary


@Composable
fun LanguageItem(ifSelected: Boolean, language: String, onClick: () -> Unit) {
    val backColor by
    animateColorAsState(
        targetValue = if (ifSelected) simplatePrimary else lightSurfacePrimary.copy(
            alpha = 0.16f
        ), animationSpec = tween(800)
    )

    val fontColor by
    animateColorAsState(
        targetValue = if (ifSelected) Color.White else Color.Black,
        animationSpec = tween(800)
    )

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
                .padding(bottom = 3.dp)
//                .animateContentSize(animationSpec = tween(200))
                .animateContentSize(animationSpec = spring(0.25f, Spring.StiffnessMediumLow)),
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

@Composable
fun OneSelectedLanguageList(selectedLanguage: MutableState<Int?>) {

    val languageListState = StateManager.currentLanguageListState

    if (!languageListState.isEmpty()) {
        LazyRow(
            modifier = Modifier
                .padding(vertical = 5.dp)
        ) {
            items(languageListState.size) {
                LanguageItem(
                    ifSelected = selectedLanguage.value == it,
                    language = languageListState[it].code + ": " + languageListState[it].name
                ) {
                    selectedLanguage.value = it
                }
            }
        }
    } else {
        Text(text = "/No language added yet/",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black.copy(
                alpha = 0.67f
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth())
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewList() {
    val myState: MutableState<Int?> = remember {
        mutableStateOf(null)
    }
    OneSelectedLanguageList(selectedLanguage = myState)
}