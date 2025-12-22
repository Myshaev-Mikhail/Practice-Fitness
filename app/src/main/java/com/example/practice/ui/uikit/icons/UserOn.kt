package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.UserOn: ImageVector
    get() {
        if (_UserOn != null) {
            return _UserOn!!
        }
        _UserOn = ImageVector.Builder(
            name = "UserOn",
            defaultWidth = 33.dp,
            defaultHeight = 41.dp,
            viewportWidth = 33f,
            viewportHeight = 41f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(16.5f, 13.895f)
                curveTo(17.41f, 13.895f, 18.312f, 13.715f, 19.153f, 13.366f)
                curveTo(19.994f, 13.016f, 20.758f, 12.504f, 21.402f, 11.859f)
                curveTo(22.045f, 11.213f, 22.555f, 10.447f, 22.903f, 9.604f)
                curveTo(23.251f, 8.761f, 23.43f, 7.857f, 23.429f, 6.944f)
                curveTo(23.429f, 5.103f, 22.699f, 3.336f, 21.399f, 2.034f)
                curveTo(20.1f, 0.732f, 18.338f, 0f, 16.5f, 0f)
                curveTo(14.662f, 0f, 12.9f, 0.732f, 11.601f, 2.034f)
                curveTo(10.301f, 3.336f, 9.571f, 5.103f, 9.571f, 6.944f)
                curveTo(9.571f, 8.787f, 10.301f, 10.554f, 11.6f, 11.857f)
                curveTo(12.899f, 13.16f, 14.662f, 13.893f, 16.5f, 13.895f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(33f, 34.148f)
                curveTo(32.998f, 29.763f, 31.259f, 25.559f, 28.165f, 22.459f)
                curveTo(25.071f, 19.359f, 20.875f, 17.617f, 16.5f, 17.617f)
                curveTo(12.125f, 17.617f, 7.929f, 19.359f, 4.835f, 22.459f)
                curveTo(1.741f, 25.559f, 0.002f, 29.763f, 0f, 34.148f)
                curveTo(0f, 43.284f, 33f, 43.284f, 33f, 34.148f)
                close()
            }
        }.build()

        return _UserOn!!
    }

@Suppress("ObjectPropertyName")
private var _UserOn: ImageVector? = null
