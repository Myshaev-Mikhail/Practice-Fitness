package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Telegram: ImageVector
    get() {
        if (_Telegram != null) {
            return _Telegram!!
        }
        _Telegram = ImageVector.Builder(
            name = "Telegram",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF896CFE)),
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 2f
            ) {
                moveTo(20f, 20f)
                moveToRelative(-19f, 0f)
                arcToRelative(19f, 19f, 0f, isMoreThanHalf = true, isPositiveArc = true, 38f, 0f)
                arcToRelative(19f, 19f, 0f, isMoreThanHalf = true, isPositiveArc = true, -38f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(23.343f, 17.715f)
                curveTo(23.273f, 17.784f, 23.191f, 17.84f, 23.1f, 17.877f)
                curveTo(23.009f, 17.915f, 22.912f, 17.934f, 22.814f, 17.934f)
                curveTo(22.715f, 17.934f, 22.618f, 17.915f, 22.528f, 17.877f)
                curveTo(22.437f, 17.84f, 22.354f, 17.784f, 22.285f, 17.715f)
                curveTo(22.215f, 17.646f, 22.16f, 17.563f, 22.123f, 17.472f)
                curveTo(22.085f, 17.382f, 22.066f, 17.284f, 22.066f, 17.186f)
                curveTo(22.066f, 17.088f, 22.085f, 16.991f, 22.123f, 16.9f)
                curveTo(22.16f, 16.809f, 22.215f, 16.727f, 22.285f, 16.657f)
                lineTo(29.942f, 9f)
                lineTo(7.303f, 18.074f)
                curveTo(7.21f, 18.106f, 7.132f, 18.169f, 7.082f, 18.253f)
                curveTo(7.027f, 18.343f, 6.999f, 18.447f, 7f, 18.552f)
                curveTo(7.006f, 18.734f, 7.072f, 18.908f, 7.187f, 19.049f)
                lineTo(15.439f, 21.351f)
                curveTo(16.202f, 21.57f, 16.897f, 21.98f, 17.458f, 22.542f)
                curveTo(18.02f, 23.103f, 18.429f, 23.798f, 18.649f, 24.561f)
                lineTo(20.951f, 32.813f)
                curveTo(21.093f, 32.928f, 21.269f, 32.994f, 21.452f, 33f)
                curveTo(21.555f, 33.002f, 21.658f, 32.975f, 21.747f, 32.921f)
                curveTo(21.829f, 32.869f, 21.893f, 32.792f, 21.93f, 32.701f)
                lineTo(31f, 10.057f)
                lineTo(23.343f, 17.715f)
                close()
            }
        }.build()

        return _Telegram!!
    }

@Suppress("ObjectPropertyName")
private var _Telegram: ImageVector? = null
