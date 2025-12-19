package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Arrow: ImageVector
    get() {
        if (_Arrow != null) {
            return _Arrow!!
        }
        _Arrow = ImageVector.Builder(
            name = "Arrow",
            defaultWidth = 14.dp,
            defaultHeight = 26.dp,
            viewportWidth = 14f,
            viewportHeight = 26f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(12.634f, 0f)
                curveTo(12.338f, -0.001f, 12.051f, 0.127f, 11.818f, 0.364f)
                lineTo(0.538f, 11.577f)
                curveTo(0.371f, 11.744f, 0.235f, 11.959f, 0.142f, 12.206f)
                curveTo(0.049f, 12.453f, 0f, 12.725f, 0f, 13f)
                curveTo(0f, 13.276f, 0.049f, 13.547f, 0.142f, 13.794f)
                curveTo(0.235f, 14.041f, 0.371f, 14.256f, 0.538f, 14.423f)
                lineTo(11.818f, 25.636f)
                curveTo(12.051f, 25.873f, 12.338f, 26.001f, 12.634f, 26f)
                curveTo(12.813f, 26.001f, 12.99f, 25.955f, 13.156f, 25.866f)
                curveTo(13.322f, 25.777f, 13.473f, 25.645f, 13.599f, 25.479f)
                curveTo(13.726f, 25.314f, 13.827f, 25.117f, 13.896f, 24.9f)
                curveTo(13.965f, 24.683f, 14f, 24.451f, 14f, 24.216f)
                lineTo(14f, 1.784f)
                curveTo(14f, 1.549f, 13.965f, 1.317f, 13.896f, 1.1f)
                curveTo(13.827f, 0.883f, 13.726f, 0.686f, 13.599f, 0.521f)
                curveTo(13.473f, 0.355f, 13.322f, 0.224f, 13.156f, 0.134f)
                curveTo(12.99f, 0.045f, 12.813f, -0.001f, 12.634f, 0f)
                close()
            }
        }.build()

        return _Arrow!!
    }

@Suppress("ObjectPropertyName")
private var _Arrow: ImageVector? = null
