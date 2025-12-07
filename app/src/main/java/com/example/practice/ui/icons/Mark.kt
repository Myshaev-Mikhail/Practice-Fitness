package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Mark: ImageVector
    get() {
        if (_Mark != null) {
            return _Mark!!
        }
        _Mark = ImageVector.Builder(
            name = "Mark",
            defaultWidth = 76.dp,
            defaultHeight = 97.dp,
            viewportWidth = 76f,
            viewportHeight = 97f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFFE2F163)),
                strokeLineWidth = 3.55852f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(66.616f, 86.441f)
                curveTo(65.192f, 81.673f, 66.858f, 76.563f, 68.718f, 71.94f)
                curveTo(71.867f, 64.654f, 73.585f, 56.828f, 73.779f, 48.89f)
                curveTo(73.779f, 34.567f, 68.831f, 19.789f, 58.206f, 9.878f)
                curveTo(52.798f, 4.959f, 45.839f, 2.101f, 38.544f, 1.805f)
                curveTo(31.25f, 1.508f, 24.083f, 3.792f, 18.296f, 8.256f)
                curveTo(5.666f, 17.989f, 1.607f, 34.388f, 1.785f, 49.668f)
                verticalLineTo(57f)
                moveTo(53.986f, 23.958f)
                curveTo(47.646f, 15.848f, 38.93f, 12.604f, 29.988f, 16.562f)
                curveTo(22.969f, 19.676f, 18.279f, 26.521f, 15.886f, 33.61f)
                curveTo(12.862f, 42.531f, 14.269f, 51.891f, 13.283f, 61.104f)
                curveTo(12.749f, 66.311f, 10.889f, 71.697f, 6.814f, 74.908f)
                moveTo(58.53f, 32.215f)
                curveTo(60.529f, 37.516f, 61.538f, 43.141f, 61.505f, 48.809f)
                curveTo(61.471f, 55.972f, 59.812f, 63.033f, 56.654f, 69.458f)
                curveTo(54.859f, 73.14f, 51.075f, 79.629f, 46.062f, 77.082f)
                curveTo(41.97f, 75.006f, 42.65f, 70.204f, 43.814f, 66.538f)
                curveTo(46.029f, 59.579f, 49.264f, 53.562f, 49.587f, 46.067f)
                curveTo(49.894f, 39.044f, 47.695f, 31.663f, 40.742f, 28.711f)
                curveTo(38.763f, 27.858f, 36.557f, 27.691f, 34.472f, 28.234f)
                curveTo(32.388f, 28.777f, 30.542f, 30.001f, 29.227f, 31.712f)
                curveTo(23.325f, 39.822f, 26.656f, 48.809f, 23.923f, 57.746f)
                moveTo(34.871f, 59.174f)
                curveTo(32.187f, 66.701f, 29.114f, 75.671f, 31.637f, 83.651f)
                curveTo(34.726f, 93.384f, 45.835f, 96.726f, 54.762f, 93.579f)
                moveTo(22.339f, 68.598f)
                curveTo(21.501f, 71.687f, 20.301f, 74.665f, 18.765f, 77.471f)
                curveTo(17.222f, 80.288f, 14.998f, 82.67f, 12.296f, 84.398f)
                moveTo(37.378f, 48.679f)
                curveTo(38.002f, 45.93f, 38.177f, 43.098f, 37.895f, 40.293f)
                curveTo(38.247f, 43.096f, 38.071f, 45.941f, 37.378f, 48.679f)
                close()
            }
        }.build()

        return _Mark!!
    }

@Suppress("ObjectPropertyName")
private var _Mark: ImageVector? = null
