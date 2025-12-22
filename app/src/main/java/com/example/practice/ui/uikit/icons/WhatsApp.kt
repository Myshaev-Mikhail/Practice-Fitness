package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.WhatsApp: ImageVector
    get() {
        if (_WhatsApp != null) {
            return _WhatsApp!!
        }
        _WhatsApp = ImageVector.Builder(
            name = "WhatsApp",
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
                moveTo(28.809f, 10.009f)
                curveTo(26.602f, 8.087f, 23.778f, 7.019f, 20.85f, 7f)
                curveTo(17.922f, 6.981f, 15.084f, 8.012f, 12.853f, 9.906f)
                curveTo(10.621f, 11.8f, 9.143f, 14.43f, 8.687f, 17.32f)
                curveTo(8.232f, 20.21f, 8.829f, 23.167f, 10.37f, 25.655f)
                curveTo(10.463f, 25.798f, 10.509f, 25.967f, 10.503f, 26.138f)
                curveTo(10.496f, 26.308f, 10.437f, 26.473f, 10.333f, 26.609f)
                curveTo(9.431f, 27.753f, 7.256f, 30.737f, 8.259f, 31.739f)
                curveTo(8.353f, 31.828f, 8.465f, 31.897f, 8.587f, 31.941f)
                curveTo(8.709f, 31.986f, 8.839f, 32.006f, 8.969f, 31.999f)
                curveTo(10.264f, 31.999f, 12.412f, 30.409f, 13.346f, 29.635f)
                curveTo(13.487f, 29.518f, 13.666f, 29.454f, 13.85f, 29.455f)
                curveTo(14.011f, 29.456f, 14.169f, 29.502f, 14.306f, 29.587f)
                curveTo(16.915f, 31.209f, 20.04f, 31.79f, 23.058f, 31.215f)
                curveTo(26.077f, 30.64f, 28.768f, 28.951f, 30.597f, 26.484f)
                curveTo(32.426f, 24.017f, 33.259f, 20.952f, 32.93f, 17.899f)
                curveTo(32.6f, 14.847f, 31.133f, 12.03f, 28.819f, 10.009f)
                horizontalLineTo(28.809f)
                close()
                moveTo(27.016f, 24.425f)
                lineTo(26.958f, 24.489f)
                curveTo(26.04f, 25.421f, 24.231f, 25.501f, 23.064f, 25.114f)
                curveTo(22.366f, 24.878f, 21.695f, 24.567f, 21.064f, 24.186f)
                curveTo(17.802f, 22.225f, 13.908f, 18.107f, 14.942f, 13.952f)
                curveTo(15.128f, 13.205f, 15.473f, 12.277f, 16.332f, 12.224f)
                curveTo(16.718f, 12.221f, 17.099f, 12.297f, 17.454f, 12.449f)
                curveTo(17.808f, 12.6f, 18.127f, 12.823f, 18.39f, 13.104f)
                curveTo(19.048f, 13.761f, 19.51f, 14.742f, 19.075f, 15.616f)
                curveTo(18.544f, 16.676f, 19.345f, 17.98f, 20.061f, 18.743f)
                curveTo(20.662f, 19.352f, 21.355f, 19.861f, 22.114f, 20.254f)
                curveTo(22.814f, 20.641f, 23.355f, 20.821f, 24.119f, 20.423f)
                curveTo(24.883f, 20.026f, 25.939f, 20.646f, 26.507f, 21.213f)
                curveTo(27.302f, 22.008f, 27.875f, 23.471f, 27.016f, 24.425f)
                close()
            }
        }.build()

        return _WhatsApp!!
    }

@Suppress("ObjectPropertyName")
private var _WhatsApp: ImageVector? = null
