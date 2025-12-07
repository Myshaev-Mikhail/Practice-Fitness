package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Globe: ImageVector
    get() {
        if (_Globe != null) {
            return _Globe!!
        }
        _Globe = ImageVector.Builder(
            name = "Globe",
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
                moveTo(21.059f, 13.282f)
                curveTo(21.059f, 13.213f, 21.059f, 13.14f, 21.059f, 13.067f)
                curveTo(21.09f, 12.768f, 21.173f, 12.476f, 21.304f, 12.206f)
                curveTo(19.112f, 10.64f, 16.894f, 9.811f, 15.144f, 9.815f)
                curveTo(14.21f, 9.78f, 13.294f, 10.076f, 12.557f, 10.651f)
                curveTo(12.082f, 11.05f, 11.718f, 11.566f, 11.501f, 12.147f)
                curveTo(11.246f, 12.84f, 11.122f, 13.574f, 11.136f, 14.312f)
                curveTo(11.162f, 15.62f, 11.409f, 16.914f, 11.866f, 18.14f)
                curveTo(13.685f, 16.722f, 15.667f, 15.528f, 17.771f, 14.582f)
                curveTo(18.842f, 14.089f, 19.94f, 13.655f, 21.059f, 13.282f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(15.166f, 31.773f)
                lineTo(15.268f, 31.773f)
                curveTo(15.53f, 31.773f, 15.783f, 31.675f, 15.977f, 31.499f)
                curveTo(16.174f, 31.323f, 16.297f, 31.079f, 16.32f, 30.816f)
                curveTo(16.32f, 30.776f, 16.32f, 30.743f, 16.32f, 30.711f)
                curveTo(16.319f, 30.449f, 16.222f, 30.197f, 16.046f, 30.003f)
                curveTo(15.868f, 29.806f, 15.623f, 29.684f, 15.359f, 29.659f)
                lineTo(15.257f, 29.659f)
                curveTo(14.995f, 29.659f, 14.742f, 29.757f, 14.548f, 29.933f)
                curveTo(14.35f, 30.11f, 14.226f, 30.355f, 14.201f, 30.619f)
                curveTo(14.201f, 30.649f, 14.201f, 30.681f, 14.201f, 30.718f)
                curveTo(14.202f, 30.98f, 14.299f, 31.232f, 14.475f, 31.426f)
                curveTo(14.653f, 31.625f, 14.9f, 31.748f, 15.166f, 31.773f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(23.482f, 14.359f)
                lineTo(23.584f, 14.359f)
                curveTo(23.846f, 14.359f, 24.099f, 14.262f, 24.293f, 14.085f)
                curveTo(24.49f, 13.91f, 24.613f, 13.666f, 24.636f, 13.403f)
                curveTo(24.636f, 13.363f, 24.636f, 13.33f, 24.636f, 13.297f)
                curveTo(24.635f, 13.035f, 24.538f, 12.783f, 24.362f, 12.589f)
                curveTo(24.184f, 12.392f, 23.939f, 12.27f, 23.675f, 12.246f)
                lineTo(23.573f, 12.246f)
                curveTo(23.311f, 12.246f, 23.058f, 12.343f, 22.864f, 12.52f)
                curveTo(22.659f, 12.693f, 22.528f, 12.939f, 22.499f, 13.206f)
                curveTo(22.497f, 13.237f, 22.497f, 13.269f, 22.499f, 13.301f)
                curveTo(22.5f, 13.562f, 22.598f, 13.814f, 22.773f, 14.009f)
                curveTo(22.955f, 14.213f, 23.209f, 14.339f, 23.482f, 14.359f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(31.929f, 18.064f)
                curveTo(31.341f, 18.995f, 30.631f, 19.843f, 29.817f, 20.586f)
                lineTo(29.74f, 20.655f)
                curveTo(30.378f, 22.19f, 30.724f, 23.83f, 30.76f, 25.491f)
                curveTo(30.765f, 26.251f, 30.658f, 27.007f, 30.442f, 27.736f)
                curveTo(31.854f, 25.838f, 32.717f, 23.59f, 32.938f, 21.235f)
                curveTo(33.089f, 19.705f, 32.965f, 18.16f, 32.572f, 16.673f)
                curveTo(32.416f, 17.162f, 32.201f, 17.629f, 31.929f, 18.064f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(10.62f, 19.202f)
                curveTo(10.642f, 19.181f, 10.672f, 19.159f, 10.693f, 19.133f)
                curveTo(10.058f, 17.598f, 9.712f, 15.958f, 9.674f, 14.297f)
                curveTo(9.66f, 13.378f, 9.818f, 12.465f, 10.138f, 11.603f)
                lineTo(10.193f, 11.49f)
                curveTo(8.407f, 13.534f, 7.31f, 16.088f, 7.058f, 18.79f)
                curveTo(6.885f, 20.615f, 7.101f, 22.457f, 7.694f, 24.192f)
                curveTo(7.747f, 23.318f, 8.026f, 22.473f, 8.505f, 21.739f)
                curveTo(9.091f, 20.801f, 9.803f, 19.948f, 10.62f, 19.202f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(22.155f, 11.005f)
                curveTo(22.206f, 11.044f, 22.251f, 11.09f, 22.291f, 11.14f)
                curveTo(22.678f, 10.904f, 23.123f, 10.778f, 23.577f, 10.775f)
                lineTo(23.818f, 10.775f)
                curveTo(24.444f, 10.834f, 25.025f, 11.126f, 25.447f, 11.592f)
                curveTo(25.61f, 11.77f, 25.745f, 11.97f, 25.849f, 12.187f)
                curveTo(26.402f, 12.122f, 26.959f, 12.088f, 27.515f, 12.085f)
                curveTo(28.309f, 12.074f, 29.101f, 12.165f, 29.872f, 12.355f)
                curveTo(30.162f, 12.431f, 30.446f, 12.53f, 30.72f, 12.651f)
                curveTo(29.645f, 11.079f, 28.236f, 9.763f, 26.594f, 8.797f)
                curveTo(24.952f, 7.83f, 23.117f, 7.237f, 21.22f, 7.059f)
                curveTo(18.781f, 6.825f, 16.325f, 7.288f, 14.139f, 8.395f)
                curveTo(14.469f, 8.344f, 14.803f, 8.318f, 15.137f, 8.319f)
                curveTo(17.34f, 8.348f, 19.791f, 9.319f, 22.155f, 11.005f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(25.17f, 15.837f)
                lineTo(24.833f, 15.472f)
                curveTo(24.453f, 15.689f, 24.022f, 15.804f, 23.584f, 15.804f)
                curveTo(23.503f, 15.804f, 23.423f, 15.804f, 23.35f, 15.804f)
                curveTo(22.723f, 15.744f, 22.14f, 15.453f, 21.717f, 14.987f)
                curveTo(21.63f, 14.89f, 21.55f, 14.786f, 21.479f, 14.677f)
                curveTo(20.43f, 15.023f, 19.4f, 15.428f, 18.396f, 15.888f)
                curveTo(16.476f, 16.752f, 14.66f, 17.831f, 12.984f, 19.104f)
                curveTo(12.802f, 19.246f, 12.619f, 19.385f, 12.458f, 19.527f)
                curveTo(13.208f, 21.12f, 14.158f, 22.61f, 15.286f, 23.962f)
                curveTo(15.348f, 24.036f, 15.394f, 24.121f, 15.423f, 24.212f)
                curveTo(15.451f, 24.304f, 15.461f, 24.401f, 15.453f, 24.496f)
                curveTo(15.444f, 24.592f, 15.416f, 24.685f, 15.371f, 24.77f)
                curveTo(15.326f, 24.855f, 15.265f, 24.93f, 15.191f, 24.991f)
                curveTo(15.117f, 25.052f, 15.032f, 25.098f, 14.94f, 25.127f)
                curveTo(14.848f, 25.155f, 14.751f, 25.165f, 14.656f, 25.156f)
                curveTo(14.56f, 25.146f, 14.467f, 25.118f, 14.382f, 25.073f)
                curveTo(14.297f, 25.028f, 14.222f, 24.967f, 14.161f, 24.893f)
                curveTo(13.053f, 23.559f, 12.102f, 22.101f, 11.329f, 20.549f)
                curveTo(10.733f, 21.126f, 10.208f, 21.772f, 9.765f, 22.473f)
                curveTo(9.408f, 22.999f, 9.199f, 23.612f, 9.159f, 24.247f)
                curveTo(9.154f, 24.465f, 9.2f, 24.683f, 9.29f, 24.882f)
                curveTo(9.384f, 25.083f, 9.521f, 25.262f, 9.692f, 25.404f)
                curveTo(9.912f, 25.583f, 10.159f, 25.727f, 10.423f, 25.831f)
                curveTo(11.224f, 26.105f, 12.069f, 26.228f, 12.915f, 26.196f)
                curveTo(15.337f, 26.196f, 18.659f, 25.418f, 22.049f, 23.871f)
                curveTo(23.969f, 23.006f, 25.785f, 21.926f, 27.461f, 20.652f)
                curveTo(27.64f, 20.513f, 27.826f, 20.37f, 27.983f, 20.232f)
                curveTo(27.235f, 18.654f, 26.29f, 17.177f, 25.17f, 15.837f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(21.527f, 30.619f)
                curveTo(20.134f, 30.024f, 18.827f, 29.248f, 17.639f, 28.309f)
                curveTo(17.564f, 28.25f, 17.5f, 28.176f, 17.453f, 28.093f)
                curveTo(17.406f, 28.009f, 17.376f, 27.917f, 17.364f, 27.822f)
                curveTo(17.353f, 27.727f, 17.36f, 27.63f, 17.386f, 27.538f)
                curveTo(17.412f, 27.445f, 17.456f, 27.359f, 17.515f, 27.283f)
                curveTo(17.634f, 27.131f, 17.808f, 27.032f, 18f, 27.008f)
                curveTo(18.192f, 26.985f, 18.385f, 27.037f, 18.538f, 27.156f)
                curveTo(19.621f, 28.015f, 20.814f, 28.725f, 22.086f, 29.269f)
                curveTo(23.097f, 29.717f, 24.185f, 29.965f, 25.29f, 29.999f)
                curveTo(26.224f, 30.034f, 27.139f, 29.739f, 27.877f, 29.167f)
                curveTo(28.352f, 28.766f, 28.716f, 28.249f, 28.933f, 27.667f)
                curveTo(29.188f, 26.974f, 29.312f, 26.24f, 29.298f, 25.502f)
                curveTo(29.274f, 24.194f, 29.026f, 22.899f, 28.568f, 21.673f)
                curveTo(26.749f, 23.091f, 24.767f, 24.286f, 22.663f, 25.232f)
                curveTo(19.112f, 26.853f, 15.644f, 27.688f, 12.922f, 27.692f)
                curveTo(12.128f, 27.704f, 11.336f, 27.613f, 10.566f, 27.422f)
                curveTo(9.917f, 27.268f, 9.309f, 26.974f, 8.786f, 26.561f)
                curveTo(9.726f, 28.173f, 11.002f, 29.565f, 12.528f, 30.641f)
                lineTo(12.751f, 30.747f)
                curveTo(12.751f, 30.67f, 12.751f, 30.587f, 12.751f, 30.503f)
                curveTo(12.81f, 29.877f, 13.102f, 29.296f, 13.569f, 28.875f)
                curveTo(14.033f, 28.457f, 14.636f, 28.225f, 15.261f, 28.225f)
                lineTo(15.502f, 28.225f)
                curveTo(16.128f, 28.285f, 16.71f, 28.576f, 17.132f, 29.043f)
                curveTo(17.552f, 29.503f, 17.786f, 30.105f, 17.785f, 30.729f)
                curveTo(17.785f, 30.813f, 17.785f, 30.889f, 17.785f, 30.966f)
                curveTo(17.725f, 31.592f, 17.433f, 32.172f, 16.967f, 32.594f)
                lineTo(16.923f, 32.627f)
                curveTo(17.532f, 32.775f, 18.152f, 32.88f, 18.776f, 32.941f)
                curveTo(21.379f, 33.191f, 23.996f, 32.647f, 26.284f, 31.382f)
                curveTo(25.958f, 31.432f, 25.628f, 31.457f, 25.298f, 31.455f)
                curveTo(23.998f, 31.426f, 22.717f, 31.142f, 21.527f, 30.619f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(25.835f, 14.428f)
                lineTo(26.24f, 14.848f)
                lineTo(26.277f, 14.888f)
                curveTo(27.386f, 16.221f, 28.337f, 17.679f, 29.108f, 19.232f)
                curveTo(29.706f, 18.657f, 30.232f, 18.011f, 30.672f, 17.308f)
                curveTo(31.03f, 16.782f, 31.239f, 16.169f, 31.279f, 15.534f)
                curveTo(31.282f, 15.316f, 31.238f, 15.099f, 31.151f, 14.899f)
                curveTo(31.055f, 14.699f, 30.916f, 14.522f, 30.745f, 14.381f)
                curveTo(30.527f, 14.199f, 30.28f, 14.055f, 30.015f, 13.954f)
                curveTo(29.215f, 13.672f, 28.37f, 13.541f, 27.523f, 13.567f)
                curveTo(27.041f, 13.571f, 26.559f, 13.6f, 26.08f, 13.655f)
                curveTo(26.042f, 13.925f, 25.959f, 14.186f, 25.835f, 14.428f)
                close()
            }
        }.build()

        return _Globe!!
    }

@Suppress("ObjectPropertyName")
private var _Globe: ImageVector? = null
