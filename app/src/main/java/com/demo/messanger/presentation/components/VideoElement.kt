package com.demo.messanger.presentation.components

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.rememberDrawablePainter
import com.demo.messanger.R


data class VideoElementProps(
    val isPlaying: Boolean,
    val videoLink: String,
    val exoPlayer: ExoPlayer,
    val onClickPlay: () -> Unit
)

@Composable
fun VideoElement(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    thumbLink: String,
    exoPlayer: ExoPlayer,
    onClickPlay: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isPlaying) {
            AndroidView(
                modifier = Modifier
                    .fillMaxSize(),
                factory = {
                    StyledPlayerView(context).apply {
                        player = exoPlayer
                        layoutParams = FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        exoPlayer.seekTo(C.TIME_UNSET)
                        exoPlayer.playWhenReady = true
                    }
                }
            )
        } else {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = thumbLink,
                success = { imageState ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        val painter = rememberDrawablePainter(drawable = imageState.drawable)
                        Image(
                            modifier = modifier,
                            painter = painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24, )
                        IconButton(
                            modifier = Modifier.wrapContentSize(),
                            onClick = {
                                onClickPlay()
                            }
                        ) {
                            Icon(
                                modifier = Modifier.fillMaxSize(0.3f),
                                painter = painter,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        }
    }
}