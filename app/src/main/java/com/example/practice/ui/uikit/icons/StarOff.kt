package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.StarOff: ImageVector
    get() {
        if (_Property1StarOff != null) {
            return _Property1StarOff!!
        }
        _Property1StarOff = ImageVector.Builder(
            name = "Property1StarOff",
            defaultWidth = 45.dp,
            defaultHeight = 45.dp,
            viewportWidth = 45f,
            viewportHeight = 45f
        ).apply {
            path(fill = SolidColor(Color(0xFFB3A0FF))) {
                moveTo(22.5f, 22.5f)
                moveToRelative(-22.5f, 0f)
                arcToRelative(22.5f, 22.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 45f, 0f)
                arcToRelative(22.5f, 22.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -45f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(34.086f, 16.146f)
                lineTo(28.975f, 14.843f)
                curveTo(28.343f, 14.679f, 27.796f, 14.279f, 27.446f, 13.722f)
                lineTo(24.642f, 9.202f)
                curveTo(24.417f, 8.832f, 24.102f, 8.526f, 23.726f, 8.315f)
                curveTo(23.35f, 8.104f, 22.927f, 7.996f, 22.497f, 8f)
                curveTo(22.068f, 7.997f, 21.646f, 8.106f, 21.271f, 8.317f)
                curveTo(20.897f, 8.527f, 20.582f, 8.832f, 20.358f, 9.202f)
                lineTo(17.548f, 13.722f)
                curveTo(17.201f, 14.28f, 16.656f, 14.681f, 16.025f, 14.843f)
                lineTo(10.914f, 16.146f)
                curveTo(10.499f, 16.251f, 10.116f, 16.462f, 9.803f, 16.758f)
                curveTo(9.49f, 17.055f, 9.256f, 17.427f, 9.124f, 17.84f)
                curveTo(8.991f, 18.252f, 8.965f, 18.692f, 9.046f, 19.118f)
                curveTo(9.128f, 19.544f, 9.315f, 19.942f, 9.59f, 20.275f)
                lineTo(12.966f, 24.373f)
                curveTo(13.384f, 24.879f, 13.593f, 25.528f, 13.55f, 26.186f)
                lineTo(13.196f, 31.512f)
                curveTo(13.173f, 31.862f, 13.221f, 32.213f, 13.338f, 32.544f)
                curveTo(13.454f, 32.875f, 13.636f, 33.178f, 13.873f, 33.434f)
                curveTo(14.109f, 33.691f, 14.395f, 33.896f, 14.713f, 34.036f)
                curveTo(15.031f, 34.176f, 15.374f, 34.249f, 15.72f, 34.25f)
                curveTo(16.044f, 34.25f, 16.364f, 34.188f, 16.665f, 34.068f)
                lineTo(21.558f, 32.078f)
                curveTo(21.857f, 31.959f, 22.176f, 31.897f, 22.497f, 31.896f)
                curveTo(22.82f, 31.897f, 23.141f, 31.958f, 23.442f, 32.078f)
                lineTo(28.335f, 34.068f)
                curveTo(28.636f, 34.188f, 28.956f, 34.25f, 29.28f, 34.25f)
                curveTo(29.626f, 34.249f, 29.969f, 34.176f, 30.287f, 34.036f)
                curveTo(30.605f, 33.896f, 30.891f, 33.691f, 31.127f, 33.434f)
                curveTo(31.364f, 33.178f, 31.546f, 32.875f, 31.662f, 32.544f)
                curveTo(31.779f, 32.213f, 31.827f, 31.862f, 31.804f, 31.512f)
                lineTo(31.45f, 26.186f)
                curveTo(31.407f, 25.528f, 31.617f, 24.879f, 32.034f, 24.373f)
                lineTo(35.41f, 20.275f)
                curveTo(35.685f, 19.942f, 35.872f, 19.544f, 35.954f, 19.118f)
                curveTo(36.035f, 18.692f, 36.009f, 18.252f, 35.876f, 17.84f)
                curveTo(35.744f, 17.427f, 35.51f, 17.055f, 35.197f, 16.758f)
                curveTo(34.884f, 16.462f, 34.501f, 16.251f, 34.086f, 16.146f)
                close()
            }
        }.build()

        return _Property1StarOff!!
    }

@Suppress("ObjectPropertyName")
private var _Property1StarOff: ImageVector? = null
