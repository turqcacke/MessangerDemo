package com.demo.messanger.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.demo.messanger.presentation.shape.LeftTriangleEdgeShape
import com.demo.messanger.presentation.shape.RightTriangleEdgeShape

@Composable
fun TriangularEndMessageBubble(
    modifier: Modifier = Modifier.wrapContentSize(),
    color: Color = Color.Cyan,
    textColor: Color = Color.Black,
    text: String? = "Test text",
    fontSize: TextUnit = 18.sp,
    cornerRadius: Dp = 10.dp,
    left: Boolean = false,
    videoElementProps: VideoElementProps? = null
) {
    val textPadding = with(LocalDensity.current) { fontSize.toDp() / 3.6f }
    val triangleScale = with(LocalDensity.current) { fontSize.toDp() / 2 }
    ConstraintLayout(modifier = modifier) {
        val (textBox, triangle) = createRefs()

        if (left) {
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = LeftTriangleEdgeShape(triangleScale.value.toInt())
                    )
                    .width(triangleScale)
                    .constrainAs(triangle) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(textBox.start)
                    }
            )
        }

        Column(
            modifier = Modifier
                .background(
                    color = color,
                    shape = if (!left) RoundedCornerShape(
                        cornerRadius,
                        cornerRadius,
                        0.dp,
                        cornerRadius
                    ) else RoundedCornerShape(cornerRadius, cornerRadius, cornerRadius, 0.dp)
                )
                .padding(textPadding)
                .constrainAs(textBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    if (!left) start.linkTo(parent.start) else end.linkTo(parent.end)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if(videoElementProps != null){
                with(videoElementProps){
                    VideoElement(
                        isPlaying = isPlaying,
                        thumbLink = videoLink,
                        exoPlayer = exoPlayer,
                    ){}
                }
            }

            if (text != null) {
                Text(text = text, fontSize = fontSize, color = textColor)
            }
        }

        if (!left) {
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RightTriangleEdgeShape(triangleScale.value.toInt())
                    )
                    .width(triangleScale)
                    .constrainAs(triangle) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(textBox.end)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun RoundedEndMessageBubble(
    modifier: Modifier = Modifier.wrapContentSize(),
    color: Color = Color.Cyan,
    textColor: Color = Color.Black,
    text: String? = "Test text",
    fontSize: TextUnit = 18.sp,
    cornerRadius: Dp = 10.dp,
    first: Boolean = false,
    left: Boolean = false,
    videoElementProps: VideoElementProps? = null
) {
    val textPadding = with(LocalDensity.current) { fontSize.toDp() / 3.6f }
    val padding = with(LocalDensity.current) { fontSize.toDp() / 2 }
    val firstCornerScale = 2

    Box(
        modifier = modifier
            .padding(
                padding,
                if (left) padding else 0.dp,
                if (left) 0.dp else padding,
                0.dp
            )
            .background(
                color = color,
                shape = RoundedCornerShape(
                    if (first && left) cornerRadius * firstCornerScale else cornerRadius,
                    if (first && !left) cornerRadius * firstCornerScale else cornerRadius,
                    cornerRadius,
                    cornerRadius
                )
            )
            .padding(textPadding)
    ) {
        if(videoElementProps != null){
            with(videoElementProps){
                VideoElement(
                    isPlaying = isPlaying,
                    thumbLink = videoLink,
                    exoPlayer = exoPlayer
                ){}
            }
        }

        if (text != null) {
            Text(text = text, fontSize = fontSize, color=textColor)
        }
    }
}