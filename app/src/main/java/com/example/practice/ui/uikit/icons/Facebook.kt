package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Facebook: ImageVector
    get() {
        if (_Facebook != null) {
            return _Facebook!!
        }
        _Facebook = ImageVector.Builder(
            name = "Facebook",
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
                moveTo(19.931f, 7.022f)
                curveTo(16.803f, 7.004f, 13.776f, 8.098f, 11.416f, 10.102f)
                curveTo(9.056f, 12.105f, 7.526f, 14.879f, 7.113f, 17.904f)
                curveTo(6.699f, 20.929f, 7.431f, 23.997f, 9.171f, 26.534f)
                curveTo(10.911f, 29.07f, 13.539f, 30.9f, 16.563f, 31.681f)
                curveTo(16.531f, 29.56f, 16.525f, 26.561f, 16.531f, 25.015f)
                horizontalLineTo(13.457f)
                curveTo(13.284f, 25.015f, 13.117f, 24.948f, 12.995f, 24.828f)
                curveTo(12.872f, 24.709f, 12.804f, 24.547f, 12.804f, 24.378f)
                verticalLineTo(21.039f)
                curveTo(12.805f, 20.871f, 12.874f, 20.71f, 12.997f, 20.592f)
                curveTo(13.119f, 20.473f, 13.285f, 20.407f, 13.457f, 20.407f)
                horizontalLineTo(16.563f)
                curveTo(16.6f, 17.654f, 16.649f, 16.985f, 16.649f, 16.985f)
                curveTo(16.649f, 16.381f, 16.771f, 15.783f, 17.007f, 15.226f)
                curveTo(17.244f, 14.668f, 17.591f, 14.161f, 18.029f, 13.734f)
                curveTo(18.466f, 13.307f, 18.986f, 12.969f, 19.558f, 12.738f)
                curveTo(20.13f, 12.507f, 20.742f, 12.388f, 21.361f, 12.388f)
                horizontalLineTo(24.307f)
                curveTo(24.443f, 12.388f, 24.578f, 12.414f, 24.704f, 12.465f)
                curveTo(24.83f, 12.516f, 24.945f, 12.59f, 25.041f, 12.684f)
                curveTo(25.138f, 12.779f, 25.214f, 12.89f, 25.267f, 13.013f)
                curveTo(25.319f, 13.136f, 25.346f, 13.268f, 25.346f, 13.401f)
                verticalLineTo(16.985f)
                horizontalLineTo(22.984f)
                curveTo(22.61f, 16.986f, 22.251f, 17.132f, 21.986f, 17.391f)
                curveTo(21.721f, 17.649f, 21.572f, 17.999f, 21.57f, 18.364f)
                curveTo(21.57f, 19.205f, 21.57f, 19.049f, 21.57f, 20.407f)
                horizontalLineTo(24.783f)
                curveTo(24.86f, 20.407f, 24.936f, 20.422f, 25.007f, 20.45f)
                curveTo(25.078f, 20.479f, 25.142f, 20.521f, 25.196f, 20.574f)
                curveTo(25.25f, 20.627f, 25.293f, 20.69f, 25.323f, 20.759f)
                curveTo(25.352f, 20.828f, 25.367f, 20.902f, 25.367f, 20.976f)
                verticalLineTo(24.425f)
                curveTo(25.367f, 24.499f, 25.352f, 24.573f, 25.323f, 24.643f)
                curveTo(25.293f, 24.712f, 25.25f, 24.774f, 25.196f, 24.827f)
                curveTo(25.142f, 24.88f, 25.078f, 24.922f, 25.007f, 24.951f)
                curveTo(24.936f, 24.979f, 24.86f, 24.994f, 24.783f, 24.994f)
                horizontalLineTo(21.57f)
                curveTo(21.57f, 26.561f, 21.57f, 29.801f, 21.57f, 32f)
                curveTo(24.851f, 31.643f, 27.866f, 30.069f, 29.989f, 27.603f)
                curveTo(32.112f, 25.137f, 33.181f, 21.968f, 32.975f, 18.754f)
                curveTo(32.768f, 15.54f, 31.302f, 12.526f, 28.879f, 10.338f)
                curveTo(26.457f, 8.15f, 23.264f, 6.955f, 19.963f, 7.001f)
                lineTo(19.931f, 7.022f)
                close()
            }
        }.build()

        return _Facebook!!
    }

@Suppress("ObjectPropertyName")
private var _Facebook: ImageVector? = null
