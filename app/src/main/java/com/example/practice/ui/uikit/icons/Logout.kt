package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Logout: ImageVector
    get() {
        if (_Logout != null) {
            return _Logout!!
        }
        _Logout = ImageVector.Builder(
            name = "Logout",
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
                moveTo(11.639f, 18.991f)
                lineTo(19.249f, 18.991f)
                lineTo(16.997f, 17.263f)
                curveTo(16.788f, 17.103f, 16.651f, 16.866f, 16.616f, 16.604f)
                curveTo(16.58f, 16.343f, 16.649f, 16.077f, 16.807f, 15.867f)
                curveTo(16.885f, 15.762f, 16.983f, 15.674f, 17.095f, 15.608f)
                curveTo(17.207f, 15.541f, 17.33f, 15.498f, 17.459f, 15.48f)
                curveTo(17.587f, 15.463f, 17.718f, 15.471f, 17.844f, 15.504f)
                curveTo(17.969f, 15.538f, 18.087f, 15.596f, 18.19f, 15.675f)
                lineTo(22.781f, 19.194f)
                lineTo(22.817f, 19.226f)
                curveTo(22.853f, 19.257f, 22.887f, 19.291f, 22.919f, 19.326f)
                lineTo(22.967f, 19.386f)
                curveTo(22.994f, 19.423f, 23.019f, 19.461f, 23.042f, 19.501f)
                lineTo(23.077f, 19.565f)
                curveTo(23.099f, 19.613f, 23.116f, 19.662f, 23.129f, 19.713f)
                lineTo(23.129f, 19.769f)
                curveTo(23.143f, 19.841f, 23.151f, 19.914f, 23.153f, 19.988f)
                curveTo(23.151f, 20.06f, 23.143f, 20.132f, 23.129f, 20.204f)
                lineTo(23.129f, 20.259f)
                curveTo(23.116f, 20.31f, 23.099f, 20.359f, 23.077f, 20.407f)
                lineTo(23.042f, 20.471f)
                curveTo(23.019f, 20.511f, 22.994f, 20.549f, 22.967f, 20.587f)
                lineTo(22.919f, 20.646f)
                curveTo(22.888f, 20.683f, 22.854f, 20.716f, 22.817f, 20.746f)
                lineTo(22.781f, 20.782f)
                lineTo(18.19f, 24.297f)
                curveTo(18.019f, 24.43f, 17.809f, 24.502f, 17.593f, 24.5f)
                curveTo(17.44f, 24.501f, 17.288f, 24.465f, 17.151f, 24.396f)
                curveTo(17.014f, 24.326f, 16.895f, 24.226f, 16.803f, 24.101f)
                curveTo(16.645f, 23.891f, 16.576f, 23.625f, 16.612f, 23.364f)
                curveTo(16.647f, 23.102f, 16.784f, 22.865f, 16.993f, 22.705f)
                lineTo(19.245f, 20.982f)
                lineTo(11.635f, 20.982f)
                lineTo(11.635f, 28.562f)
                curveTo(11.635f, 30.004f, 12.202f, 31.387f, 13.212f, 32.407f)
                curveTo(14.222f, 33.427f, 15.592f, 34f, 17.02f, 34f)
                lineTo(24.622f, 34f)
                curveTo(25.329f, 34f, 26.029f, 33.858f, 26.681f, 33.585f)
                curveTo(27.334f, 33.311f, 27.927f, 32.91f, 28.427f, 32.406f)
                curveTo(28.926f, 31.901f, 29.322f, 31.301f, 29.592f, 30.642f)
                curveTo(29.862f, 29.982f, 30f, 29.275f, 30f, 28.562f)
                lineTo(30f, 11.434f)
                curveTo(30f, 10.721f, 29.862f, 10.014f, 29.592f, 9.355f)
                curveTo(29.322f, 8.696f, 28.926f, 8.097f, 28.426f, 7.592f)
                curveTo(27.927f, 7.087f, 27.334f, 6.687f, 26.681f, 6.414f)
                curveTo(26.028f, 6.141f, 25.329f, 6f, 24.622f, 6f)
                lineTo(17.02f, 6f)
                curveTo(15.593f, 6f, 14.223f, 6.572f, 13.214f, 7.591f)
                curveTo(12.204f, 8.61f, 11.636f, 9.993f, 11.635f, 11.434f)
                lineTo(11.635f, 16.15f)
                lineTo(11.639f, 18.991f)
                close()
                moveTo(25.211f, 11.41f)
                curveTo(25.211f, 11.279f, 25.236f, 11.149f, 25.285f, 11.028f)
                curveTo(25.335f, 10.906f, 25.407f, 10.796f, 25.499f, 10.704f)
                curveTo(25.591f, 10.611f, 25.7f, 10.537f, 25.82f, 10.488f)
                curveTo(25.94f, 10.438f, 26.069f, 10.412f, 26.199f, 10.413f)
                curveTo(26.329f, 10.412f, 26.458f, 10.438f, 26.578f, 10.488f)
                curveTo(26.698f, 10.537f, 26.807f, 10.611f, 26.899f, 10.704f)
                curveTo(26.99f, 10.796f, 27.063f, 10.906f, 27.113f, 11.028f)
                curveTo(27.162f, 11.149f, 27.187f, 11.279f, 27.187f, 11.41f)
                lineTo(27.187f, 28.606f)
                curveTo(27.187f, 28.87f, 27.083f, 29.124f, 26.897f, 29.311f)
                curveTo(26.712f, 29.498f, 26.461f, 29.603f, 26.199f, 29.603f)
                curveTo(25.937f, 29.603f, 25.686f, 29.498f, 25.5f, 29.311f)
                curveTo(25.315f, 29.124f, 25.211f, 28.87f, 25.211f, 28.606f)
                lineTo(25.211f, 11.41f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(7.988f, 20.985f)
                lineTo(11.635f, 20.985f)
                curveTo(11.897f, 20.985f, 12.148f, 20.88f, 12.333f, 20.693f)
                curveTo(12.519f, 20.506f, 12.623f, 20.253f, 12.623f, 19.988f)
                curveTo(12.623f, 19.723f, 12.519f, 19.47f, 12.333f, 19.283f)
                curveTo(12.148f, 19.096f, 11.897f, 18.991f, 11.635f, 18.991f)
                lineTo(7.988f, 18.991f)
                curveTo(7.726f, 18.991f, 7.475f, 19.096f, 7.289f, 19.283f)
                curveTo(7.104f, 19.47f, 7f, 19.723f, 7f, 19.988f)
                curveTo(7f, 20.253f, 7.104f, 20.506f, 7.289f, 20.693f)
                curveTo(7.475f, 20.88f, 7.726f, 20.985f, 7.988f, 20.985f)
                close()
            }
        }.build()

        return _Logout!!
    }

@Suppress("ObjectPropertyName")
private var _Logout: ImageVector? = null
