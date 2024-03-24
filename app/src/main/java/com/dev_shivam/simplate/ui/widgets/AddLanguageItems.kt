package com.dev_shivam.simplate.ui.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

@Composable
fun AddLanguageItem(language: Language) {

    var isSelected = rememberSaveable {
        mutableStateOf(language in StateManager.selectedLanguages )
    }
    val backColor by animateColorAsState(
        targetValue =
        if (isSelected.value) lightSurfacePrimary.copy(
            alpha = 0.8f
        ) else lightSurfacePrimary.copy(
            alpha = 0.3f
        )
    )


    Surface(
        color = backColor,
        modifier = Modifier
            .padding(5.dp)
            .padding(horizontal = 22.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable {
                if (isSelected.value)
                    StateManager.selectedLanguages.remove(language)
                else
                    StateManager.selectedLanguages.add(language)

                isSelected.value = !isSelected.value
            }
    ) {
        Row(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${language.code}: ${language.name}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            if (isSelected.value) {
                Image(
                    painter = painterResource(id = R.drawable.tick_in_circle_black),
                    contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
            }

        }
    }
}



@Composable
fun AddLanguageItemList(){
    var languageList = StateManager.AddLanguagesListState
    if (!languageList.isEmpty()){
        LazyColumn {
            items(count = languageList.size, itemContent = {
                AddLanguageItem(language = languageList[it] )
            } )
        }
    }else{
        Text(text = "Loading...", Modifier.fillMaxWidth(), textAlign = TextAlign.Center, style = MaterialTheme.typography.titleMedium)
    }
}