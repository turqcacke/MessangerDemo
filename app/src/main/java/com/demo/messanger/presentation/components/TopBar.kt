package com.demo.messanger.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.demo.messanger.presentation.ui.theme.MessengerDemoTheme

@Composable
fun TopBar(
    modifier: Modifier,
    fonSize: TextUnit = TextUnit.Unspecified
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "User", fontSize = fonSize, color = Color.Black)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    MessengerDemoTheme {
        TopBar(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight())
    }
}