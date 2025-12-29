package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.StarVariant: ImageVector
    get() {
        if (_StarVariant != null) {
            return _StarVariant!!
        }
        _StarVariant = ImageVector.Builder(
            name = "StarVariant",
            defaultWidth = 44.dp,
            defaultHeight = 42.dp,
            viewportWidth = 44f,
            viewportHeight = 42f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(40.349f, 12.94f)
                lineTo(32.129f, 10.87f)
                curveTo(31.113f, 10.611f, 30.233f, 9.974f, 29.669f, 9.09f)
                lineTo(25.159f, 1.91f)
                curveTo(24.798f, 1.321f, 24.291f, 0.835f, 23.686f, 0.5f)
                curveTo(23.081f, 0.166f, 22.4f, -0.007f, 21.709f, 0f)
                curveTo(21.02f, -0.005f, 20.341f, 0.168f, 19.738f, 0.503f)
                curveTo(19.135f, 0.838f, 18.629f, 1.322f, 18.269f, 1.91f)
                lineTo(13.749f, 9.09f)
                curveTo(13.191f, 9.976f, 12.314f, 10.613f, 11.299f, 10.87f)
                lineTo(3.079f, 12.94f)
                curveTo(2.411f, 13.108f, 1.795f, 13.443f, 1.292f, 13.914f)
                curveTo(0.788f, 14.384f, 0.412f, 14.975f, 0.199f, 15.631f)
                curveTo(-0.014f, 16.287f, -0.057f, 16.986f, 0.074f, 17.662f)
                curveTo(0.206f, 18.339f, 0.507f, 18.972f, 0.949f, 19.5f)
                lineTo(6.379f, 26.01f)
                curveTo(7.051f, 26.814f, 7.387f, 27.845f, 7.319f, 28.89f)
                lineTo(6.749f, 37.35f)
                curveTo(6.712f, 37.907f, 6.79f, 38.465f, 6.977f, 38.99f)
                curveTo(7.164f, 39.515f, 7.457f, 39.996f, 7.838f, 40.404f)
                curveTo(8.218f, 40.812f, 8.678f, 41.137f, 9.189f, 41.36f)
                curveTo(9.7f, 41.583f, 10.252f, 41.699f, 10.809f, 41.7f)
                curveTo(11.33f, 41.7f, 11.845f, 41.602f, 12.329f, 41.41f)
                lineTo(20.199f, 38.25f)
                curveTo(20.68f, 38.061f, 21.192f, 37.963f, 21.709f, 37.96f)
                curveTo(22.229f, 37.962f, 22.745f, 38.06f, 23.229f, 38.25f)
                lineTo(31.099f, 41.41f)
                curveTo(31.583f, 41.602f, 32.099f, 41.7f, 32.619f, 41.7f)
                curveTo(33.177f, 41.699f, 33.728f, 41.583f, 34.239f, 41.36f)
                curveTo(34.75f, 41.137f, 35.21f, 40.812f, 35.591f, 40.404f)
                curveTo(35.971f, 39.996f, 36.264f, 39.515f, 36.451f, 38.99f)
                curveTo(36.639f, 38.465f, 36.716f, 37.907f, 36.679f, 37.35f)
                lineTo(36.109f, 28.89f)
                curveTo(36.041f, 27.845f, 36.378f, 26.814f, 37.049f, 26.01f)
                lineTo(42.479f, 19.5f)
                curveTo(42.922f, 18.972f, 43.223f, 18.339f, 43.354f, 17.662f)
                curveTo(43.485f, 16.986f, 43.442f, 16.287f, 43.229f, 15.631f)
                curveTo(43.016f, 14.975f, 42.64f, 14.384f, 42.137f, 13.914f)
                curveTo(41.633f, 13.443f, 41.018f, 13.108f, 40.349f, 12.94f)
                close()
            }
        }.build()

        return _StarVariant!!
    }

@Suppress("ObjectPropertyName")
private var _StarVariant: ImageVector? = null
