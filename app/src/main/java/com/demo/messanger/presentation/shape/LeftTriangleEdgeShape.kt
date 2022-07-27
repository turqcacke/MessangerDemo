package com.demo.messanger.presentation.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class LeftTriangleEdgeShape(private val offset: Int) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val trianglePath = Path().apply {
            moveTo(x = size.width, y = size.height-offset)
            lineTo(x = size.width, y = size.height)
            lineTo(x = size.width - offset, y = size.height)
        }
        return Outline.Generic(path = trianglePath)
    }
}