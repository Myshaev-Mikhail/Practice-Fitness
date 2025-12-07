package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Instagram: ImageVector
    get() {
        if (_Instagram != null) {
            return _Instagram!!
        }
        _Instagram = ImageVector.Builder(
            name = "Instagram",
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
                moveTo(21.706f, 31.975f)
                horizontalLineTo(21.819f)
                lineTo(22.182f, 31.944f)
                horizontalLineTo(22.379f)
                lineTo(22.694f, 31.913f)
                lineTo(23.105f, 31.863f)
                horizontalLineTo(23.206f)
                curveTo(24.626f, 31.7f, 26.015f, 31.316f, 27.327f, 30.724f)
                curveTo(28.535f, 30.191f, 29.585f, 29.332f, 30.369f, 28.234f)
                curveTo(30.913f, 27.423f, 31.29f, 26.503f, 31.477f, 25.532f)
                verticalLineTo(25.495f)
                curveTo(31.859f, 23.765f, 32.033f, 21.992f, 31.995f, 20.216f)
                verticalLineTo(19.258f)
                curveTo(32.012f, 17.606f, 31.857f, 15.957f, 31.53f, 14.34f)
                curveTo(31.509f, 14.296f, 31.491f, 14.25f, 31.477f, 14.203f)
                curveTo(31.251f, 13.13f, 30.874f, 12.098f, 30.357f, 11.141f)
                curveTo(29.868f, 10.249f, 29.19f, 9.486f, 28.375f, 8.912f)
                curveTo(27.252f, 8.168f, 26.006f, 7.65f, 24.701f, 7.387f)
                curveTo(23.359f, 7.116f, 21.995f, 6.986f, 20.628f, 7.001f)
                horizontalLineTo(19.378f)
                curveTo(18.009f, 6.986f, 16.643f, 7.115f, 15.299f, 7.387f)
                curveTo(13.994f, 7.652f, 12.748f, 8.169f, 11.625f, 8.912f)
                curveTo(10.81f, 9.485f, 10.134f, 10.248f, 9.649f, 11.141f)
                curveTo(9.13f, 12.097f, 8.751f, 13.13f, 8.523f, 14.203f)
                curveTo(8.509f, 14.25f, 8.491f, 14.296f, 8.47f, 14.34f)
                curveTo(8.143f, 15.957f, 7.988f, 17.606f, 8.005f, 19.258f)
                curveTo(8.005f, 19.407f, 8.005f, 19.563f, 8.005f, 19.712f)
                curveTo(8.005f, 19.874f, 8.005f, 20.03f, 8.005f, 20.192f)
                curveTo(7.967f, 21.967f, 8.141f, 23.74f, 8.523f, 25.47f)
                verticalLineTo(25.507f)
                curveTo(8.696f, 26.438f, 9.049f, 27.321f, 9.561f, 28.102f)
                curveTo(10.073f, 28.884f, 10.733f, 29.547f, 11.5f, 30.052f)
                curveTo(13.116f, 31.055f, 14.923f, 31.671f, 16.794f, 31.857f)
                horizontalLineTo(16.895f)
                lineTo(17.312f, 31.907f)
                lineTo(17.627f, 31.938f)
                horizontalLineTo(17.824f)
                lineTo(18.181f, 31.969f)
                horizontalLineTo(18.294f)
                lineTo(18.973f, 32f)
                horizontalLineTo(21.009f)
                lineTo(21.706f, 31.975f)
                close()
                moveTo(25.666f, 11.738f)
                curveTo(25.771f, 11.506f, 25.937f, 11.31f, 26.145f, 11.173f)
                curveTo(26.352f, 11.035f, 26.593f, 10.962f, 26.838f, 10.962f)
                curveTo(27.084f, 10.962f, 27.325f, 11.035f, 27.532f, 11.173f)
                curveTo(27.74f, 11.31f, 27.906f, 11.506f, 28.011f, 11.738f)
                curveTo(28.131f, 12.069f, 28.131f, 12.434f, 28.011f, 12.765f)
                curveTo(27.906f, 12.998f, 27.74f, 13.194f, 27.532f, 13.331f)
                curveTo(27.325f, 13.468f, 27.084f, 13.541f, 26.838f, 13.541f)
                curveTo(26.593f, 13.541f, 26.352f, 13.468f, 26.145f, 13.331f)
                curveTo(25.937f, 13.194f, 25.771f, 12.998f, 25.666f, 12.765f)
                curveTo(25.551f, 12.44f, 25.551f, 12.082f, 25.666f, 11.757f)
                verticalLineTo(11.738f)
                close()
                moveTo(20.2f, 25.744f)
                horizontalLineTo(19.824f)
                curveTo(19.221f, 25.744f, 18.62f, 25.658f, 18.038f, 25.489f)
                curveTo(17.118f, 25.231f, 16.275f, 24.732f, 15.591f, 24.038f)
                curveTo(15.019f, 23.446f, 14.578f, 22.73f, 14.299f, 21.941f)
                curveTo(13.735f, 20.357f, 13.735f, 18.613f, 14.299f, 17.029f)
                curveTo(14.578f, 16.24f, 15.019f, 15.524f, 15.591f, 14.932f)
                curveTo(16.066f, 14.444f, 16.623f, 14.054f, 17.234f, 13.78f)
                curveTo(18.046f, 13.418f, 18.918f, 13.23f, 19.801f, 13.226f)
                horizontalLineTo(20.176f)
                curveTo(20.779f, 13.226f, 21.38f, 13.312f, 21.962f, 13.481f)
                curveTo(22.882f, 13.739f, 23.725f, 14.238f, 24.409f, 14.932f)
                curveTo(24.981f, 15.524f, 25.422f, 16.24f, 25.701f, 17.029f)
                curveTo(26.273f, 18.612f, 26.273f, 20.358f, 25.701f, 21.941f)
                curveTo(25.422f, 22.73f, 24.981f, 23.446f, 24.409f, 24.038f)
                curveTo(23.934f, 24.526f, 23.377f, 24.916f, 22.766f, 25.19f)
                curveTo(21.955f, 25.554f, 21.082f, 25.744f, 20.2f, 25.75f)
                verticalLineTo(25.744f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(21.48f, 23.709f)
                curveTo(22.11f, 23.536f, 22.688f, 23.197f, 23.159f, 22.725f)
                curveTo(23.545f, 22.322f, 23.842f, 21.836f, 24.028f, 21.3f)
                curveTo(24.237f, 20.727f, 24.344f, 20.119f, 24.344f, 19.507f)
                curveTo(24.343f, 18.893f, 24.238f, 18.284f, 24.034f, 17.708f)
                curveTo(23.844f, 17.172f, 23.545f, 16.686f, 23.159f, 16.282f)
                curveTo(22.839f, 15.955f, 22.463f, 15.694f, 22.051f, 15.51f)
                curveTo(21.464f, 15.254f, 20.836f, 15.119f, 20.2f, 15.112f)
                horizontalLineTo(19.824f)
                curveTo(19.392f, 15.116f, 18.962f, 15.179f, 18.544f, 15.299f)
                curveTo(17.915f, 15.476f, 17.338f, 15.814f, 16.865f, 16.282f)
                curveTo(16.479f, 16.685f, 16.182f, 17.172f, 15.996f, 17.708f)
                curveTo(15.583f, 18.866f, 15.583f, 20.141f, 15.996f, 21.3f)
                curveTo(16.182f, 21.836f, 16.479f, 22.322f, 16.865f, 22.725f)
                curveTo(17.186f, 23.051f, 17.562f, 23.312f, 17.973f, 23.497f)
                curveTo(18.56f, 23.753f, 19.188f, 23.888f, 19.824f, 23.895f)
                horizontalLineTo(20.2f)
                curveTo(20.632f, 23.891f, 21.063f, 23.829f, 21.48f, 23.709f)
                close()
            }
        }.build()

        return _Instagram!!
    }

@Suppress("ObjectPropertyName")
private var _Instagram: ImageVector? = null
