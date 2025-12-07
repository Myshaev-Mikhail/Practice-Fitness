package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Microphone: ImageVector
    get() {
        if (_Microphone != null) {
            return _Microphone!!
        }
        _Microphone = ImageVector.Builder(
            name = "Microphone",
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
                moveTo(19.291f, 28.872f)
                lineTo(19.291f, 30.597f)
                lineTo(16.859f, 30.597f)
                curveTo(16.676f, 30.597f, 16.5f, 30.671f, 16.371f, 30.803f)
                curveTo(16.241f, 30.934f, 16.169f, 31.113f, 16.169f, 31.299f)
                curveTo(16.169f, 31.485f, 16.241f, 31.663f, 16.371f, 31.795f)
                curveTo(16.5f, 31.926f, 16.676f, 32f, 16.859f, 32f)
                lineTo(23.1f, 32f)
                curveTo(23.283f, 32f, 23.458f, 31.926f, 23.588f, 31.795f)
                curveTo(23.717f, 31.663f, 23.79f, 31.485f, 23.79f, 31.299f)
                curveTo(23.79f, 31.113f, 23.717f, 30.934f, 23.588f, 30.803f)
                curveTo(23.458f, 30.671f, 23.283f, 30.597f, 23.1f, 30.597f)
                lineTo(20.685f, 30.597f)
                lineTo(20.685f, 28.872f)
                curveTo(23.21f, 28.689f, 25.573f, 27.542f, 27.301f, 25.662f)
                curveTo(29.028f, 23.781f, 29.993f, 21.306f, 30f, 18.734f)
                curveTo(30f, 18.548f, 29.927f, 18.369f, 29.798f, 18.238f)
                curveTo(29.668f, 18.106f, 29.493f, 18.032f, 29.31f, 18.032f)
                curveTo(29.127f, 18.032f, 28.951f, 18.106f, 28.822f, 18.238f)
                curveTo(28.693f, 18.369f, 28.62f, 18.548f, 28.62f, 18.734f)
                curveTo(28.62f, 19.884f, 28.397f, 21.022f, 27.962f, 22.084f)
                curveTo(27.528f, 23.146f, 26.89f, 24.109f, 26.088f, 24.92f)
                curveTo(24.644f, 26.393f, 22.731f, 27.296f, 20.692f, 27.466f)
                lineTo(20.692f, 24.744f)
                curveTo(20.463f, 24.771f, 20.232f, 24.785f, 20.002f, 24.787f)
                curveTo(19.771f, 24.786f, 19.541f, 24.77f, 19.312f, 24.741f)
                lineTo(19.312f, 27.466f)
                curveTo(17.271f, 27.297f, 15.357f, 26.394f, 13.912f, 24.92f)
                curveTo(13.11f, 24.109f, 12.474f, 23.145f, 12.039f, 22.083f)
                curveTo(11.604f, 21.022f, 11.38f, 19.884f, 11.38f, 18.734f)
                curveTo(11.38f, 18.548f, 11.307f, 18.369f, 11.178f, 18.238f)
                curveTo(11.049f, 18.106f, 10.873f, 18.032f, 10.69f, 18.032f)
                curveTo(10.507f, 18.032f, 10.331f, 18.106f, 10.202f, 18.238f)
                curveTo(10.073f, 18.369f, 10f, 18.548f, 10f, 18.734f)
                curveTo(10.008f, 21.302f, 10.969f, 23.773f, 12.691f, 25.653f)
                curveTo(14.414f, 27.532f, 16.771f, 28.682f, 19.291f, 28.872f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(16.859f, 10.282f)
                curveTo(17.042f, 10.282f, 17.217f, 10.356f, 17.347f, 10.488f)
                curveTo(17.476f, 10.619f, 17.549f, 10.798f, 17.549f, 10.984f)
                curveTo(17.549f, 11.17f, 17.476f, 11.348f, 17.347f, 11.48f)
                curveTo(17.217f, 11.611f, 17.042f, 11.685f, 16.859f, 11.685f)
                lineTo(15.403f, 11.685f)
                lineTo(15.403f, 13.438f)
                lineTo(16.859f, 13.438f)
                curveTo(17.042f, 13.438f, 17.217f, 13.512f, 17.347f, 13.644f)
                curveTo(17.476f, 13.775f, 17.549f, 13.954f, 17.549f, 14.14f)
                curveTo(17.549f, 14.326f, 17.476f, 14.504f, 17.347f, 14.636f)
                curveTo(17.217f, 14.767f, 17.042f, 14.841f, 16.859f, 14.841f)
                lineTo(15.403f, 14.841f)
                lineTo(15.403f, 16.84f)
                lineTo(24.556f, 16.84f)
                lineTo(24.556f, 14.841f)
                lineTo(23.1f, 14.841f)
                curveTo(22.917f, 14.841f, 22.741f, 14.767f, 22.612f, 14.636f)
                curveTo(22.483f, 14.504f, 22.41f, 14.326f, 22.41f, 14.14f)
                curveTo(22.41f, 13.954f, 22.483f, 13.775f, 22.612f, 13.644f)
                curveTo(22.741f, 13.512f, 22.917f, 13.438f, 23.1f, 13.438f)
                lineTo(24.556f, 13.438f)
                lineTo(24.556f, 11.685f)
                lineTo(23.231f, 11.685f)
                curveTo(23.048f, 11.685f, 22.872f, 11.611f, 22.743f, 11.48f)
                curveTo(22.614f, 11.348f, 22.541f, 11.17f, 22.541f, 10.984f)
                curveTo(22.541f, 10.798f, 22.614f, 10.619f, 22.743f, 10.488f)
                curveTo(22.872f, 10.356f, 23.048f, 10.282f, 23.231f, 10.282f)
                lineTo(24.352f, 10.282f)
                curveTo(24.128f, 9.56f, 23.737f, 8.903f, 23.21f, 8.368f)
                curveTo(22.787f, 7.935f, 22.284f, 7.591f, 21.73f, 7.356f)
                curveTo(21.176f, 7.122f, 20.581f, 7.001f, 19.981f, 7f)
                curveTo(19.38f, 7f, 18.784f, 7.121f, 18.229f, 7.356f)
                curveTo(17.674f, 7.591f, 17.169f, 7.934f, 16.745f, 8.368f)
                curveTo(16.22f, 8.904f, 15.829f, 9.561f, 15.606f, 10.282f)
                lineTo(16.859f, 10.282f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(19.981f, 23.384f)
                curveTo(21.194f, 23.382f, 22.356f, 22.891f, 23.214f, 22.02f)
                curveTo(24.072f, 21.148f, 24.555f, 19.967f, 24.556f, 18.734f)
                lineTo(24.556f, 18.713f)
                lineTo(15.403f, 18.713f)
                lineTo(15.403f, 18.734f)
                curveTo(15.403f, 19.344f, 15.522f, 19.948f, 15.753f, 20.512f)
                curveTo(15.984f, 21.075f, 16.322f, 21.586f, 16.748f, 22.016f)
                curveTo(17.172f, 22.449f, 17.676f, 22.793f, 18.23f, 23.028f)
                curveTo(18.785f, 23.263f, 19.38f, 23.384f, 19.981f, 23.384f)
                close()
            }
        }.build()

        return _Microphone!!
    }

@Suppress("ObjectPropertyName")
private var _Microphone: ImageVector? = null
