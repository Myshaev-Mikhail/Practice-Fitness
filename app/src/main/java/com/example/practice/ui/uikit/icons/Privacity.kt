package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Privacity: ImageVector
    get() {
        if (_Privacity != null) {
            return _Privacity!!
        }
        _Privacity = ImageVector.Builder(
            name = "Privacity",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(fill = SolidColor(Color(0xFF896CFE))) {
                moveTo(20f, 20f)
                moveToRelative(-20f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, 40f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, -40f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(14.776f, 12.703f)
                curveTo(14.775f, 12.016f, 14.91f, 11.335f, 15.174f, 10.701f)
                curveTo(15.438f, 10.066f, 15.825f, 9.49f, 16.313f, 9.006f)
                curveTo(16.795f, 8.521f, 17.368f, 8.136f, 17.999f, 7.873f)
                curveTo(18.631f, 7.61f, 19.308f, 7.475f, 19.993f, 7.475f)
                curveTo(20.677f, 7.475f, 21.355f, 7.61f, 21.988f, 7.872f)
                curveTo(22.62f, 8.135f, 23.194f, 8.52f, 23.676f, 9.006f)
                curveTo(24.165f, 9.49f, 24.552f, 10.066f, 24.815f, 10.7f)
                curveTo(25.078f, 11.335f, 25.212f, 12.016f, 25.209f, 12.703f)
                verticalLineTo(14.921f)
                curveTo(25.732f, 15.219f, 26.228f, 15.563f, 26.69f, 15.949f)
                verticalLineTo(12.688f)
                curveTo(26.686f, 10.915f, 25.979f, 9.217f, 24.724f, 7.963f)
                curveTo(23.469f, 6.71f, 21.768f, 6.004f, 19.993f, 6f)
                curveTo(18.218f, 6.004f, 16.517f, 6.71f, 15.263f, 7.963f)
                curveTo(14.008f, 9.217f, 13.302f, 10.916f, 13.299f, 12.688f)
                verticalLineTo(15.949f)
                curveTo(13.761f, 15.564f, 14.257f, 15.22f, 14.78f, 14.921f)
                lineTo(14.776f, 12.703f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(13.636f, 30.368f)
                curveTo(14.471f, 31.203f, 15.463f, 31.866f, 16.555f, 32.318f)
                curveTo(17.647f, 32.77f, 18.818f, 33.001f, 20f, 33f)
                curveTo(21.182f, 33.002f, 22.353f, 32.77f, 23.445f, 32.318f)
                curveTo(24.538f, 31.867f, 25.529f, 31.204f, 26.364f, 30.368f)
                curveTo(27.202f, 29.535f, 27.866f, 28.544f, 28.319f, 27.453f)
                curveTo(28.771f, 26.362f, 29.003f, 25.193f, 29f, 24.012f)
                curveTo(29.002f, 22.832f, 28.771f, 21.662f, 28.318f, 20.572f)
                curveTo(27.866f, 19.481f, 27.201f, 18.49f, 26.364f, 17.657f)
                curveTo(25.529f, 16.821f, 24.538f, 16.158f, 23.445f, 15.706f)
                curveTo(22.353f, 15.255f, 21.182f, 15.023f, 20f, 15.025f)
                curveTo(18.818f, 15.023f, 17.647f, 15.255f, 16.555f, 15.707f)
                curveTo(15.463f, 16.159f, 14.471f, 16.821f, 13.636f, 17.657f)
                curveTo(12.8f, 18.491f, 12.137f, 19.482f, 11.684f, 20.573f)
                curveTo(11.232f, 21.663f, 10.999f, 22.832f, 11f, 24.012f)
                curveTo(10.999f, 25.193f, 11.231f, 26.362f, 11.684f, 27.452f)
                curveTo(12.136f, 28.543f, 12.8f, 29.534f, 13.636f, 30.368f)
                close()
                moveTo(20f, 20.016f)
                curveTo(20.315f, 20.015f, 20.627f, 20.077f, 20.918f, 20.197f)
                curveTo(21.209f, 20.317f, 21.473f, 20.493f, 21.696f, 20.715f)
                curveTo(21.919f, 20.937f, 22.096f, 21.201f, 22.216f, 21.492f)
                curveTo(22.337f, 21.782f, 22.399f, 22.093f, 22.399f, 22.408f)
                curveTo(22.399f, 22.916f, 22.237f, 23.41f, 21.937f, 23.82f)
                curveTo(21.637f, 24.23f, 21.214f, 24.535f, 20.729f, 24.689f)
                curveTo(20.733f, 24.726f, 20.733f, 24.763f, 20.729f, 24.8f)
                verticalLineTo(28.02f)
                curveTo(20.729f, 28.216f, 20.651f, 28.404f, 20.513f, 28.543f)
                curveTo(20.374f, 28.682f, 20.185f, 28.759f, 19.989f, 28.759f)
                curveTo(19.793f, 28.759f, 19.604f, 28.682f, 19.465f, 28.543f)
                curveTo(19.326f, 28.404f, 19.249f, 28.216f, 19.249f, 28.02f)
                verticalLineTo(24.8f)
                curveTo(19.249f, 24.763f, 19.249f, 24.726f, 19.249f, 24.689f)
                curveTo(18.765f, 24.534f, 18.343f, 24.229f, 18.043f, 23.819f)
                curveTo(17.744f, 23.41f, 17.583f, 22.915f, 17.583f, 22.408f)
                curveTo(17.582f, 22.092f, 17.644f, 21.779f, 17.765f, 21.488f)
                curveTo(17.886f, 21.196f, 18.064f, 20.931f, 18.288f, 20.709f)
                curveTo(18.512f, 20.486f, 18.778f, 20.31f, 19.07f, 20.19f)
                curveTo(19.363f, 20.071f, 19.677f, 20.01f, 19.993f, 20.012f)
                lineTo(20f, 20.016f)
                close()
            }
        }.build()

        return _Privacity!!
    }

@Suppress("ObjectPropertyName")
private var _Privacity: ImageVector? = null
