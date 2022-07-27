package com.demo.messanger

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.demo.messanger.data.entity.Content
import com.demo.messanger.domain.entity.Message
import com.demo.messanger.presentation.components.*
import com.demo.messanger.presentation.ui.theme.MessengerDemoTheme
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

val list = listOf(
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = false,
        content = Content.TextContent("Test")
    ),
    Message(
        me = false,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),
    Message(
        me = false,
        content = Content.TextContent("Test")
    ),
    Message(
        me = false,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    ),Message(
        me = false,
        content = Content.TextContent("Test")
    ),
    Message(
        me = false,
        content = Content.TextContent("Test")
    ),
    Message(
        me = true,
        content = Content.TextContent("Test")
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MessengerDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                    ) {
                        TopBar(
                            modifier = Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .wrapContentHeight()
                        )

                        MessageList(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                            messagesList = list
                        )

                        BottomBar(
                            modifier = Modifier
                                .background(Color.White)
                                .wrapContentHeight()
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MessengerDemoTheme {
    }
}