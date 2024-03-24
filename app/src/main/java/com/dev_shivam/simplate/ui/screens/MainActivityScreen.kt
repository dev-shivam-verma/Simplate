package com.dev_shivam.simplate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev_shivam.simplate.R
import com.dev_shivam.simplate.activities.AddLanguageActivity
import com.dev_shivam.simplate.ui.StateManager
import com.dev_shivam.simplate.ui.theme.simplatePrimary
import com.dev_shivam.simplate.ui.widgets.MyTextField
import com.dev_shivam.simplate.ui.widgets.OneSelectedLanguageList


@Composable
fun MainActivityScreen(onAddLanguage: () -> Unit,onTranslate: ()->Unit) {

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.top_app_bar),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(ScrollState(1))
            ) {


                Spacer(modifier = Modifier.height(71.dp))

                //Text input field
                MyTextField()

                Spacer(modifier = Modifier.height(14.dp))

                //From
                Box(
                    contentAlignment = Alignment.TopStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 27.dp)
                ) {
                    Text(
                        text = "From",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))


                //From language selection
                Box(modifier = Modifier.padding(horizontal = 27.dp)) {
                    OneSelectedLanguageList(
                        selectedLanguage = StateManager.currentFromLanguageIndexState
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))


                //To
                Box(
                    contentAlignment = Alignment.TopStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 27.dp)
                ) {
                    Text(
                        text = "To",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))


                //TO language selection
                Box(modifier = Modifier.padding(horizontal = 27.dp)) {
                    OneSelectedLanguageList(
                        selectedLanguage = StateManager.currentToLanguageIndexState
                    )
                }


                Spacer(modifier = Modifier.height(20.dp))

                if (StateManager.isTranslationStarted.value){
                    StateManager.translatedText.value?.let { Text(text = it) }
                    Spacer(modifier = Modifier.height(20.dp))
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    TextButton(onClick = {
                        // Start addLanguage Activity
                        onAddLanguage()
                    }) {
                        Text(
                            text = "Add Language",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }


                    TextButton(
                        onClick = onTranslate,
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(MaterialTheme.shapes.extraSmall)
                            .background(simplatePrimary)

                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.magic_stick_),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "Translate",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }


                }

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}