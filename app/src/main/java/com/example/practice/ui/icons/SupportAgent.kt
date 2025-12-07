package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.SupportAgent: ImageVector
    get() {
        if (_SupportAgent != null) {
            return _SupportAgent!!
        }
        _SupportAgent = ImageVector.Builder(
            name = "SupportAgent",
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
                moveTo(30.268f, 28.577f)
                curveTo(29.68f, 27.346f, 28.903f, 26.217f, 27.966f, 25.232f)
                curveTo(26.668f, 26.536f, 25.073f, 27.496f, 23.32f, 28.026f)
                curveTo(23.239f, 28.648f, 22.937f, 29.219f, 22.471f, 29.632f)
                curveTo(22.005f, 30.046f, 21.406f, 30.274f, 20.787f, 30.275f)
                curveTo(20.448f, 30.276f, 20.114f, 30.209f, 19.801f, 30.079f)
                curveTo(19.489f, 29.948f, 19.205f, 29.757f, 18.965f, 29.515f)
                curveTo(18.726f, 29.274f, 18.536f, 28.987f, 18.407f, 28.671f)
                curveTo(18.277f, 28.355f, 18.21f, 28.016f, 18.21f, 27.674f)
                curveTo(18.21f, 27.332f, 18.277f, 26.993f, 18.407f, 26.677f)
                curveTo(18.536f, 26.361f, 18.726f, 26.074f, 18.965f, 25.832f)
                curveTo(19.205f, 25.59f, 19.489f, 25.399f, 19.801f, 25.268f)
                curveTo(20.114f, 25.138f, 20.448f, 25.071f, 20.787f, 25.072f)
                curveTo(21.248f, 25.074f, 21.7f, 25.202f, 22.095f, 25.441f)
                curveTo(22.491f, 25.681f, 22.816f, 26.024f, 23.035f, 26.434f)
                curveTo(24.444f, 25.982f, 25.73f, 25.202f, 26.789f, 24.159f)
                curveTo(26.578f, 23.993f, 26.361f, 23.833f, 26.145f, 23.683f)
                curveTo(25.507f, 23.247f, 24.826f, 22.88f, 24.112f, 22.588f)
                curveTo(22.972f, 23.463f, 21.579f, 23.936f, 20.148f, 23.934f)
                curveTo(18.746f, 23.935f, 17.381f, 23.482f, 16.252f, 22.641f)
                curveTo(15.578f, 22.933f, 14.935f, 23.291f, 14.33f, 23.71f)
                curveTo(12.556f, 24.947f, 11.134f, 26.635f, 10.207f, 28.603f)
                curveTo(10.093f, 28.849f, 10.034f, 29.117f, 10.033f, 29.389f)
                curveTo(10.035f, 29.714f, 10.113f, 30.034f, 10.26f, 30.323f)
                curveTo(10.392f, 30.59f, 10.595f, 30.814f, 10.846f, 30.97f)
                curveTo(12.13f, 31.695f, 13.523f, 32.2f, 14.969f, 32.466f)
                curveTo(16.706f, 32.823f, 18.475f, 33.002f, 20.248f, 33f)
                curveTo(22.021f, 33.001f, 23.79f, 32.822f, 25.527f, 32.466f)
                curveTo(26.973f, 32.2f, 28.365f, 31.696f, 29.65f, 30.975f)
                curveTo(29.905f, 30.804f, 30.113f, 30.571f, 30.256f, 30.298f)
                curveTo(30.399f, 30.024f, 30.472f, 29.719f, 30.468f, 29.41f)
                curveTo(30.465f, 29.131f, 30.404f, 28.857f, 30.289f, 28.603f)
                lineTo(30.268f, 28.577f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(16.595f, 20.841f)
                curveTo(17.061f, 21.314f, 17.614f, 21.69f, 18.224f, 21.946f)
                curveTo(18.834f, 22.202f, 19.488f, 22.333f, 20.148f, 22.331f)
                curveTo(20.808f, 22.334f, 21.462f, 22.203f, 22.072f, 21.947f)
                curveTo(22.682f, 21.691f, 23.236f, 21.315f, 23.701f, 20.841f)
                curveTo(24.17f, 20.37f, 24.541f, 19.81f, 24.794f, 19.193f)
                curveTo(25.047f, 18.576f, 25.176f, 17.914f, 25.174f, 17.246f)
                curveTo(25.175f, 16.577f, 25.045f, 15.916f, 24.792f, 15.299f)
                curveTo(24.54f, 14.682f, 24.169f, 14.121f, 23.701f, 13.65f)
                curveTo(23.236f, 13.176f, 22.682f, 12.8f, 22.072f, 12.544f)
                curveTo(21.462f, 12.288f, 20.808f, 12.157f, 20.148f, 12.16f)
                curveTo(19.488f, 12.158f, 18.834f, 12.29f, 18.224f, 12.545f)
                curveTo(17.614f, 12.801f, 17.061f, 13.177f, 16.595f, 13.65f)
                curveTo(16.127f, 14.121f, 15.756f, 14.682f, 15.503f, 15.299f)
                curveTo(15.25f, 15.916f, 15.121f, 16.577f, 15.122f, 17.246f)
                curveTo(15.12f, 17.914f, 15.249f, 18.576f, 15.502f, 19.193f)
                curveTo(15.755f, 19.81f, 16.126f, 20.37f, 16.595f, 20.841f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(30.421f, 21.829f)
                curveTo(30.891f, 21.829f, 31.357f, 21.735f, 31.792f, 21.553f)
                curveTo(32.226f, 21.371f, 32.621f, 21.103f, 32.953f, 20.767f)
                curveTo(33.286f, 20.43f, 33.549f, 20.03f, 33.729f, 19.59f)
                curveTo(33.909f, 19.149f, 34.001f, 18.678f, 34f, 18.202f)
                curveTo(33.999f, 17.333f, 33.69f, 16.494f, 33.129f, 15.837f)
                curveTo(32.568f, 15.18f, 31.792f, 14.749f, 30.943f, 14.623f)
                curveTo(30.366f, 12.165f, 28.986f, 9.977f, 27.027f, 8.412f)
                curveTo(25.067f, 6.848f, 22.644f, 5.998f, 20.148f, 6f)
                curveTo(17.654f, 6f, 15.234f, 6.85f, 13.277f, 8.414f)
                curveTo(11.32f, 9.977f, 9.941f, 12.163f, 9.363f, 14.617f)
                curveTo(8.453f, 14.673f, 7.599f, 15.078f, 6.974f, 15.749f)
                curveTo(6.349f, 16.42f, 6.001f, 17.306f, 6f, 18.229f)
                curveTo(6f, 19.19f, 6.377f, 20.111f, 7.048f, 20.792f)
                curveTo(7.719f, 21.472f, 8.629f, 21.854f, 9.579f, 21.856f)
                curveTo(9.793f, 21.855f, 10.004f, 21.806f, 10.197f, 21.712f)
                curveTo(10.492f, 21.562f, 10.738f, 21.328f, 10.904f, 21.039f)
                curveTo(11.144f, 20.636f, 11.308f, 20.192f, 11.39f, 19.73f)
                curveTo(11.484f, 19.235f, 11.53f, 18.732f, 11.527f, 18.229f)
                curveTo(11.54f, 17.475f, 11.426f, 16.726f, 11.189f, 16.011f)
                curveTo(11.101f, 15.756f, 10.977f, 15.515f, 10.82f, 15.296f)
                curveTo(11.199f, 13.461f, 12.1f, 11.779f, 13.412f, 10.455f)
                curveTo(14.295f, 9.559f, 15.345f, 8.848f, 16.501f, 8.363f)
                curveTo(17.657f, 7.878f, 18.896f, 7.628f, 20.148f, 7.629f)
                curveTo(21.4f, 7.628f, 22.64f, 7.877f, 23.797f, 8.362f)
                curveTo(24.954f, 8.847f, 26.005f, 9.558f, 26.889f, 10.455f)
                curveTo(28.132f, 11.715f, 29.004f, 13.301f, 29.407f, 15.034f)
                curveTo(29.289f, 15.149f, 29.184f, 15.278f, 29.096f, 15.418f)
                curveTo(28.857f, 15.823f, 28.693f, 16.269f, 28.61f, 16.733f)
                curveTo(28.516f, 17.226f, 28.47f, 17.727f, 28.473f, 18.229f)
                curveTo(28.459f, 18.982f, 28.574f, 19.732f, 28.811f, 20.446f)
                curveTo(28.862f, 20.586f, 28.922f, 20.724f, 28.99f, 20.857f)
                curveTo(28.693f, 21.615f, 28.303f, 22.333f, 27.829f, 22.994f)
                curveTo(27.681f, 23.191f, 27.533f, 23.389f, 27.375f, 23.576f)
                lineTo(28.573f, 24.645f)
                curveTo(28.726f, 24.463f, 28.869f, 24.276f, 29.006f, 24.11f)
                curveTo(29.52f, 23.427f, 29.952f, 22.684f, 30.294f, 21.899f)
                lineTo(30.421f, 21.829f)
                close()
                moveTo(9.954f, 18.202f)
                curveTo(9.968f, 18.767f, 9.887f, 19.33f, 9.716f, 19.869f)
                curveTo(9.673f, 19.995f, 9.611f, 20.114f, 9.532f, 20.221f)
                curveTo(9.023f, 20.208f, 8.54f, 19.997f, 8.18f, 19.634f)
                curveTo(7.994f, 19.446f, 7.846f, 19.223f, 7.745f, 18.977f)
                curveTo(7.645f, 18.731f, 7.593f, 18.468f, 7.594f, 18.202f)
                curveTo(7.594f, 17.937f, 7.645f, 17.674f, 7.746f, 17.429f)
                curveTo(7.846f, 17.184f, 7.994f, 16.962f, 8.18f, 16.775f)
                curveTo(8.54f, 16.412f, 9.023f, 16.201f, 9.532f, 16.188f)
                curveTo(9.679f, 16.408f, 9.778f, 16.657f, 9.822f, 16.92f)
                curveTo(9.912f, 17.341f, 9.956f, 17.771f, 9.954f, 18.202f)
                close()
                moveTo(30.489f, 20.221f)
                curveTo(30.342f, 19.999f, 30.244f, 19.748f, 30.199f, 19.484f)
                curveTo(30.114f, 19.064f, 30.071f, 18.636f, 30.072f, 18.207f)
                curveTo(30.062f, 17.644f, 30.142f, 17.083f, 30.31f, 16.546f)
                curveTo(30.353f, 16.419f, 30.415f, 16.3f, 30.495f, 16.193f)
                curveTo(31.003f, 16.207f, 31.487f, 16.417f, 31.846f, 16.781f)
                curveTo(32.032f, 16.967f, 32.18f, 17.189f, 32.281f, 17.434f)
                curveTo(32.381f, 17.679f, 32.433f, 17.942f, 32.432f, 18.207f)
                curveTo(32.433f, 18.473f, 32.382f, 18.737f, 32.281f, 18.983f)
                curveTo(32.181f, 19.228f, 32.033f, 19.451f, 31.846f, 19.639f)
                curveTo(31.482f, 20.004f, 30.992f, 20.213f, 30.479f, 20.221f)
                horizontalLineTo(30.489f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(19.794f, 27.674f)
                curveTo(19.795f, 27.939f, 19.901f, 28.193f, 20.087f, 28.38f)
                curveTo(20.273f, 28.568f, 20.524f, 28.673f, 20.787f, 28.673f)
                curveTo(21.048f, 28.673f, 21.299f, 28.567f, 21.485f, 28.38f)
                curveTo(21.67f, 28.193f, 21.774f, 27.939f, 21.774f, 27.674f)
                curveTo(21.774f, 27.409f, 21.67f, 27.155f, 21.485f, 26.967f)
                curveTo(21.299f, 26.78f, 21.048f, 26.675f, 20.787f, 26.675f)
                curveTo(20.524f, 26.675f, 20.273f, 26.78f, 20.087f, 26.967f)
                curveTo(19.901f, 27.154f, 19.795f, 27.408f, 19.794f, 27.674f)
                close()
            }
        }.build()

        return _SupportAgent!!
    }

@Suppress("ObjectPropertyName")
private var _SupportAgent: ImageVector? = null
