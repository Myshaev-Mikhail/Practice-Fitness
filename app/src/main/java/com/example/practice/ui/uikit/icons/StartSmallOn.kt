package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.StartSmallOn: ImageVector
    get() {
        if (_StartSmallOn != null) {
            return _StartSmallOn!!
        }
        _StartSmallOn = ImageVector.Builder(
            name = "StartSmallOn",
            defaultWidth = 15.dp,
            defaultHeight = 16.dp,
            viewportWidth = 15f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(13.936f, 4.655f)
                lineTo(11.097f, 3.91f)
                curveTo(10.746f, 3.817f, 10.443f, 3.588f, 10.248f, 3.27f)
                lineTo(8.69f, 0.687f)
                curveTo(8.565f, 0.475f, 8.39f, 0.3f, 8.181f, 0.18f)
                curveTo(7.972f, 0.06f, 7.737f, -0.002f, 7.498f, 0f)
                curveTo(7.26f, -0.002f, 7.026f, 0.061f, 6.818f, 0.181f)
                curveTo(6.609f, 0.301f, 6.435f, 0.476f, 6.31f, 0.687f)
                lineTo(4.749f, 3.27f)
                curveTo(4.556f, 3.588f, 4.253f, 3.818f, 3.903f, 3.91f)
                lineTo(1.064f, 4.655f)
                curveTo(0.833f, 4.715f, 0.62f, 4.836f, 0.446f, 5.005f)
                curveTo(0.272f, 5.174f, 0.142f, 5.387f, 0.069f, 5.623f)
                curveTo(-0.005f, 5.858f, -0.02f, 6.11f, 0.026f, 6.353f)
                curveTo(0.071f, 6.597f, 0.175f, 6.824f, 0.328f, 7.014f)
                lineTo(2.203f, 9.356f)
                curveTo(2.435f, 9.645f, 2.551f, 10.016f, 2.528f, 10.392f)
                lineTo(2.331f, 13.435f)
                curveTo(2.318f, 13.635f, 2.345f, 13.836f, 2.41f, 14.025f)
                curveTo(2.474f, 14.214f, 2.576f, 14.387f, 2.707f, 14.534f)
                curveTo(2.838f, 14.68f, 2.997f, 14.797f, 3.174f, 14.878f)
                curveTo(3.35f, 14.958f, 3.541f, 15f, 3.733f, 15f)
                curveTo(3.913f, 15f, 4.091f, 14.965f, 4.258f, 14.896f)
                lineTo(6.977f, 13.759f)
                curveTo(7.143f, 13.691f, 7.32f, 13.656f, 7.498f, 13.655f)
                curveTo(7.678f, 13.655f, 7.856f, 13.691f, 8.023f, 13.759f)
                lineTo(10.742f, 14.896f)
                curveTo(10.909f, 14.965f, 11.087f, 15f, 11.267f, 15f)
                curveTo(11.459f, 15f, 11.65f, 14.958f, 11.826f, 14.878f)
                curveTo(12.003f, 14.797f, 12.161f, 14.68f, 12.293f, 14.534f)
                curveTo(12.424f, 14.387f, 12.526f, 14.214f, 12.59f, 14.025f)
                curveTo(12.655f, 13.836f, 12.682f, 13.635f, 12.669f, 13.435f)
                lineTo(12.472f, 10.392f)
                curveTo(12.449f, 10.016f, 12.565f, 9.645f, 12.797f, 9.356f)
                lineTo(14.672f, 7.014f)
                curveTo(14.825f, 6.824f, 14.929f, 6.597f, 14.974f, 6.353f)
                curveTo(15.02f, 6.11f, 15.005f, 5.858f, 14.931f, 5.623f)
                curveTo(14.858f, 5.387f, 14.728f, 5.174f, 14.554f, 5.005f)
                curveTo(14.38f, 4.836f, 14.167f, 4.715f, 13.936f, 4.655f)
                close()
            }
        }.build()

        return _StartSmallOn!!
    }

@Suppress("ObjectPropertyName")
private var _StartSmallOn: ImageVector? = null
