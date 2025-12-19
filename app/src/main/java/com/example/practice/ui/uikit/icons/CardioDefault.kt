package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.CardioDefault: ImageVector
    get() {
        if (_CardioDefault != null) {
            return _CardioDefault!!
        }
        _CardioDefault = ImageVector.Builder(
            name = "CardioDefault",
            defaultWidth = 49.dp,
            defaultHeight = 42.dp,
            viewportWidth = 49f,
            viewportHeight = 42f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(26.11f, 23.49f)
                curveTo(26.115f, 22.413f, 26.259f, 21.34f, 26.54f, 20.3f)
                horizontalLineTo(24.84f)
                curveTo(24.554f, 20.299f, 24.275f, 20.216f, 24.034f, 20.062f)
                curveTo(23.793f, 19.908f, 23.601f, 19.689f, 23.48f, 19.43f)
                lineTo(22.15f, 16.58f)
                lineTo(18.94f, 23.25f)
                curveTo(18.823f, 23.5f, 18.638f, 23.712f, 18.406f, 23.862f)
                curveTo(18.175f, 24.012f, 17.906f, 24.094f, 17.63f, 24.1f)
                curveTo(17.353f, 24.108f, 17.08f, 24.039f, 16.84f, 23.902f)
                curveTo(16.6f, 23.764f, 16.403f, 23.563f, 16.27f, 23.32f)
                lineTo(13.58f, 18.32f)
                lineTo(12.58f, 19.75f)
                curveTo(12.442f, 19.952f, 12.257f, 20.116f, 12.041f, 20.23f)
                curveTo(11.825f, 20.343f, 11.584f, 20.402f, 11.34f, 20.4f)
                horizontalLineTo(7.96f)
                curveTo(7.562f, 20.4f, 7.18f, 20.242f, 6.899f, 19.961f)
                curveTo(6.618f, 19.679f, 6.46f, 19.298f, 6.46f, 18.9f)
                curveTo(6.46f, 18.502f, 6.618f, 18.121f, 6.899f, 17.839f)
                curveTo(7.18f, 17.558f, 7.562f, 17.4f, 7.96f, 17.4f)
                horizontalLineTo(10.56f)
                lineTo(12.48f, 14.6f)
                curveTo(12.627f, 14.389f, 12.825f, 14.22f, 13.056f, 14.108f)
                curveTo(13.288f, 13.996f, 13.543f, 13.945f, 13.8f, 13.96f)
                curveTo(14.056f, 13.971f, 14.306f, 14.049f, 14.523f, 14.186f)
                curveTo(14.741f, 14.323f, 14.919f, 14.514f, 15.04f, 14.74f)
                lineTo(17.5f, 19.28f)
                lineTo(20.8f, 12.4f)
                curveTo(20.923f, 12.144f, 21.116f, 11.928f, 21.357f, 11.778f)
                curveTo(21.597f, 11.627f, 21.876f, 11.549f, 22.16f, 11.55f)
                curveTo(22.444f, 11.552f, 22.723f, 11.633f, 22.963f, 11.785f)
                curveTo(23.204f, 11.937f, 23.396f, 12.154f, 23.52f, 12.41f)
                lineTo(25.78f, 17.28f)
                horizontalLineTo(27.78f)
                curveTo(28.867f, 15.378f, 30.438f, 13.798f, 32.333f, 12.698f)
                curveTo(34.228f, 11.599f, 36.379f, 11.02f, 38.57f, 11.02f)
                curveTo(41.344f, 11.017f, 44.038f, 11.947f, 46.22f, 13.66f)
                curveTo(46.22f, 13.39f, 46.22f, 13.12f, 46.22f, 12.85f)
                curveTo(46.22f, 12.164f, 46.17f, 11.479f, 46.07f, 10.8f)
                curveTo(46.01f, 10.41f, 45.93f, 10.03f, 45.84f, 9.65f)
                curveTo(45.295f, 7.563f, 44.236f, 5.647f, 42.761f, 4.075f)
                curveTo(41.284f, 2.502f, 39.438f, 1.325f, 37.39f, 0.65f)
                curveTo(36.1f, 0.221f, 34.749f, 0.002f, 33.39f, 0f)
                curveTo(31.673f, 0.006f, 29.974f, 0.352f, 28.392f, 1.018f)
                curveTo(26.809f, 1.684f, 25.374f, 2.656f, 24.17f, 3.88f)
                lineTo(23.1f, 4.96f)
                lineTo(22.03f, 3.88f)
                curveTo(20.826f, 2.656f, 19.391f, 1.684f, 17.808f, 1.018f)
                curveTo(16.226f, 0.352f, 14.527f, 0.006f, 12.81f, 0f)
                curveTo(11.45f, 0.002f, 10.1f, 0.221f, 8.81f, 0.65f)
                curveTo(6.801f, 1.3f, 4.985f, 2.44f, 3.527f, 3.968f)
                curveTo(2.069f, 5.496f, 1.015f, 7.363f, 0.46f, 9.4f)
                curveTo(0.157f, 10.617f, 0.002f, 11.866f, 0f, 13.12f)
                curveTo(0.107f, 16.749f, 1.203f, 20.279f, 3.17f, 23.33f)
                curveTo(5.186f, 26.557f, 7.635f, 29.491f, 10.45f, 32.05f)
                curveTo(14.332f, 35.577f, 18.575f, 38.685f, 23.11f, 41.32f)
                curveTo(26.525f, 39.319f, 29.79f, 37.073f, 32.88f, 34.6f)
                curveTo(30.837f, 33.553f, 29.123f, 31.96f, 27.928f, 30f)
                curveTo(26.733f, 28.039f, 26.104f, 25.786f, 26.11f, 23.49f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(45.24f, 16.81f)
                curveTo(44.365f, 15.93f, 43.324f, 15.232f, 42.177f, 14.757f)
                curveTo(41.03f, 14.281f, 39.801f, 14.038f, 38.56f, 14.04f)
                curveTo(37.319f, 14.039f, 36.09f, 14.283f, 34.944f, 14.759f)
                curveTo(33.797f, 15.234f, 32.756f, 15.931f, 31.88f, 16.81f)
                curveTo(31.001f, 17.686f, 30.304f, 18.728f, 29.829f, 19.874f)
                curveTo(29.354f, 21.02f, 29.109f, 22.249f, 29.11f, 23.49f)
                curveTo(29.109f, 24.733f, 29.353f, 25.963f, 29.828f, 27.111f)
                curveTo(30.303f, 28.259f, 31.001f, 29.302f, 31.88f, 30.18f)
                curveTo(32.757f, 31.058f, 33.798f, 31.753f, 34.944f, 32.227f)
                curveTo(36.091f, 32.701f, 37.319f, 32.943f, 38.56f, 32.94f)
                curveTo(39.8f, 32.944f, 41.029f, 32.702f, 42.176f, 32.229f)
                curveTo(43.323f, 31.755f, 44.364f, 31.059f, 45.24f, 30.18f)
                curveTo(46.121f, 29.303f, 46.819f, 28.261f, 47.295f, 27.112f)
                curveTo(47.77f, 25.964f, 48.014f, 24.733f, 48.01f, 23.49f)
                curveTo(48.013f, 22.249f, 47.769f, 21.019f, 47.294f, 19.873f)
                curveTo(46.818f, 18.726f, 46.12f, 17.685f, 45.24f, 16.81f)
                close()
                moveTo(33.24f, 23.55f)
                curveTo(33.504f, 23.252f, 33.874f, 23.07f, 34.271f, 23.044f)
                curveTo(34.668f, 23.018f, 35.059f, 23.149f, 35.36f, 23.41f)
                lineTo(36.72f, 24.61f)
                lineTo(41.63f, 19.27f)
                curveTo(41.763f, 19.125f, 41.924f, 19.007f, 42.102f, 18.924f)
                curveTo(42.281f, 18.841f, 42.474f, 18.794f, 42.671f, 18.786f)
                curveTo(42.868f, 18.777f, 43.065f, 18.808f, 43.25f, 18.876f)
                curveTo(43.435f, 18.943f, 43.605f, 19.047f, 43.75f, 19.18f)
                curveTo(43.895f, 19.313f, 44.013f, 19.474f, 44.096f, 19.653f)
                curveTo(44.179f, 19.831f, 44.226f, 20.024f, 44.234f, 20.221f)
                curveTo(44.243f, 20.418f, 44.212f, 20.615f, 44.144f, 20.8f)
                curveTo(44.077f, 20.985f, 43.973f, 21.155f, 43.84f, 21.3f)
                lineTo(37.94f, 27.72f)
                curveTo(37.676f, 28.009f, 37.309f, 28.183f, 36.917f, 28.204f)
                curveTo(36.526f, 28.224f, 36.143f, 28.09f, 35.85f, 27.83f)
                lineTo(33.38f, 25.67f)
                curveTo(33.083f, 25.405f, 32.903f, 25.034f, 32.879f, 24.637f)
                curveTo(32.855f, 24.24f, 32.988f, 23.849f, 33.25f, 23.55f)
                horizontalLineTo(33.24f)
                close()
            }
        }.build()

        return _CardioDefault!!
    }

@Suppress("ObjectPropertyName")
private var _CardioDefault: ImageVector? = null
