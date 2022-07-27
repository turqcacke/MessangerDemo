package com.demo.messanger.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.demo.messanger.data.entity.Content
import com.demo.messanger.domain.entity.Message
import com.demo.messanger.presentation.ui.theme.LightSoftGreen
import com.demo.messanger.R
import com.google.android.exoplayer2.ExoPlayer

enum class Position {
    FIRST,
    MID,
    END
}

@Composable
fun MessageList(
    modifier: Modifier,
    messagesList: List<Message>,
    bubbleBackgroundColor: Color = LightSoftGreen,
    altBubbleBackgroundColor: Color = Color.White,
    textColor: Color = Color.Black,
    verticalMessagesPadding: Dp = 5.dp,
) {
    val listState = rememberLazyListState()
    val scrollState = rememberScrollState()

    LazyColumn(
        modifier = modifier,
        state = listState
    ) {
        items(messagesList.size) {
            val message = messagesList[it]
            val left = !message.me
            val color = if (message.me) bubbleBackgroundColor else altBubbleBackgroundColor
            val pos =
                if (
                    0 < it
                    && it < messagesList.lastIndex
                    && messagesList[it + 1].me == message.me
                    && messagesList[it - 1].me == message.me
                ) Position.MID
                else if (it < messagesList.lastIndex && messagesList[it + 1].me == message.me) Position.FIRST
                else Position.END
            val arrangement = if (left) Arrangement.Start else Arrangement.End
            val text = when (message.content) {
                is Content.TextContent -> message.content.text
                is Content.VideoContent -> message.content.text
            }

            val rowModifier = Modifier
                .fillMaxSize()
                .padding(
                    0.dp,
                    if (it == 0) verticalMessagesPadding * 2 else 0.dp,
                    0.dp,
                    verticalMessagesPadding
                )
            Row(
                modifier = rowModifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = arrangement
            ) {
                when (pos) {
                    Position.END -> {
                        TriangularEndMessageBubble(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = text,
                            left = left,
                            color = color,
                            textColor = textColor
                        )
                        rowModifier.padding(verticalMessagesPadding, 0.dp, 0.dp, 0.dp)
                    }
                    Position.MID -> {
                        RoundedEndMessageBubble(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = text,
                            left = left,
                            color = color,
                            textColor = textColor

                        )
                    }
                    Position.FIRST -> {
                        RoundedEndMessageBubble(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = text,
                            left = left,
                            first = true,
                            color = color,
                            textColor = textColor
                        )
                    }
                }
            }

        }
    }
}