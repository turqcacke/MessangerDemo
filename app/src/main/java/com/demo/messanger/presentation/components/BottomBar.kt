package com.demo.messanger.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.demo.messanger.presentation.ui.theme.MessengerDemoTheme
import com.demo.messanger.R

@Composable
fun BottomBar(
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth().padding(15.dp, 1.dp, 15.dp, 5.dp),
    ) {
        val (input, icon)  = createRefs()
        TextField(
            modifier = Modifier.constrainAs(input){
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(icon.start, margin = 5.dp)
                width = Dimension.fillToConstraints
            },
            value = "Message",
            onValueChange = {},
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        Icon(
            modifier = Modifier.constrainAs(icon){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            },
            painter = painterResource(id = R.drawable.ic_baseline_send_24),
            contentDescription = null,
            tint = Color.Blue)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    MessengerDemoTheme {
        BottomBar(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight())
    }
}