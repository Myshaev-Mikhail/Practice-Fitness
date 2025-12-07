package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.StarOn: ImageVector
    get() {
        if (_Property1StarOn != null) {
            return _Property1StarOn!!
        }
        _Property1StarOn = ImageVector.Builder(
            name = "Property1StarOn",
            defaultWidth = 48.dp,
            defaultHeight = 45.dp,
            viewportWidth = 48f,
            viewportHeight = 45f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(25.5f, 22.5f)
                moveToRelative(-22.5f, 0f)
                arcToRelative(22.5f, 22.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 45f, 0f)
                arcToRelative(22.5f, 22.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -45f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB3A0FF))) {
                moveTo(6.5f, 9.5f)
                moveToRelative(-6.5f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 13f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -13f, 0f)
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(37.086f, 16.146f)
                lineTo(31.975f, 14.843f)
                curveTo(31.343f, 14.679f, 30.796f, 14.279f, 30.446f, 13.722f)
                lineTo(27.642f, 9.202f)
                curveTo(27.417f, 8.832f, 27.102f, 8.526f, 26.726f, 8.315f)
                curveTo(26.35f, 8.104f, 25.927f, 7.996f, 25.497f, 8f)
                curveTo(25.068f, 7.997f, 24.646f, 8.106f, 24.271f, 8.317f)
                curveTo(23.897f, 8.527f, 23.582f, 8.832f, 23.358f, 9.202f)
                lineTo(20.548f, 13.722f)
                curveTo(20.201f, 14.28f, 19.656f, 14.681f, 19.025f, 14.843f)
                lineTo(13.914f, 16.146f)
                curveTo(13.499f, 16.251f, 13.116f, 16.462f, 12.803f, 16.758f)
                curveTo(12.49f, 17.055f, 12.256f, 17.427f, 12.124f, 17.84f)
                curveTo(11.991f, 18.252f, 11.965f, 18.692f, 12.046f, 19.118f)
                curveTo(12.128f, 19.544f, 12.315f, 19.942f, 12.59f, 20.275f)
                lineTo(15.966f, 24.373f)
                curveTo(16.383f, 24.879f, 16.593f, 25.528f, 16.551f, 26.186f)
                lineTo(16.196f, 31.512f)
                curveTo(16.173f, 31.862f, 16.221f, 32.213f, 16.338f, 32.544f)
                curveTo(16.454f, 32.875f, 16.636f, 33.178f, 16.873f, 33.434f)
                curveTo(17.109f, 33.691f, 17.395f, 33.896f, 17.713f, 34.036f)
                curveTo(18.031f, 34.176f, 18.374f, 34.249f, 18.72f, 34.25f)
                curveTo(19.044f, 34.25f, 19.364f, 34.188f, 19.665f, 34.068f)
                lineTo(24.558f, 32.078f)
                curveTo(24.857f, 31.959f, 25.176f, 31.897f, 25.497f, 31.896f)
                curveTo(25.82f, 31.897f, 26.141f, 31.958f, 26.442f, 32.078f)
                lineTo(31.335f, 34.068f)
                curveTo(31.636f, 34.188f, 31.956f, 34.25f, 32.28f, 34.25f)
                curveTo(32.626f, 34.249f, 32.969f, 34.176f, 33.287f, 34.036f)
                curveTo(33.605f, 33.896f, 33.891f, 33.691f, 34.127f, 33.434f)
                curveTo(34.364f, 33.178f, 34.546f, 32.875f, 34.662f, 32.544f)
                curveTo(34.779f, 32.213f, 34.827f, 31.862f, 34.804f, 31.512f)
                lineTo(34.45f, 26.186f)
                curveTo(34.407f, 25.528f, 34.617f, 24.879f, 35.034f, 24.373f)
                lineTo(38.41f, 20.275f)
                curveTo(38.685f, 19.942f, 38.872f, 19.544f, 38.954f, 19.118f)
                curveTo(39.035f, 18.692f, 39.009f, 18.252f, 38.876f, 17.84f)
                curveTo(38.744f, 17.427f, 38.51f, 17.055f, 38.197f, 16.758f)
                curveTo(37.884f, 16.462f, 37.501f, 16.251f, 37.086f, 16.146f)
                close()
            }
        }.build()

        return _Property1StarOn!!
    }

@Suppress("ObjectPropertyName")
private var _Property1StarOn: ImageVector? = null
