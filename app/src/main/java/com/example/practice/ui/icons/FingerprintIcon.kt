package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.FingerprintIcon: ImageVector
    get() {
        if (_FingerprintIcon != null) {
            return _FingerprintIcon!!
        }
        _FingerprintIcon = ImageVector.Builder(
            name = "FingerprintIcon",
            defaultWidth = 35.dp,
            defaultHeight = 35.dp,
            viewportWidth = 35f,
            viewportHeight = 35f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(13.127f, 0f)
                lineTo(21.003f, 0f)
                arcTo(13.127f, 13.127f, 0f, isMoreThanHalf = false, isPositiveArc = true, 34.131f, 13.127f)
                lineTo(34.131f, 21.003f)
                arcTo(13.127f, 13.127f, 0f, isMoreThanHalf = false, isPositiveArc = true, 21.003f, 34.131f)
                lineTo(13.127f, 34.131f)
                arcTo(13.127f, 13.127f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 21.003f)
                lineTo(0f, 13.127f)
                arcTo(13.127f, 13.127f, 0f, isMoreThanHalf = false, isPositiveArc = true, 13.127f, 0f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 1.42515f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(24.359f, 26.774f)
                curveTo(23.997f, 25.562f, 24.421f, 24.263f, 24.894f, 23.087f)
                curveTo(25.694f, 21.235f, 26.131f, 19.246f, 26.181f, 17.228f)
                curveTo(26.181f, 13.586f, 24.923f, 9.83f, 22.222f, 7.31f)
                curveTo(20.847f, 6.059f, 19.077f, 5.333f, 17.223f, 5.257f)
                curveTo(15.368f, 5.182f, 13.547f, 5.763f, 12.075f, 6.898f)
                curveTo(8.865f, 9.372f, 7.833f, 13.541f, 7.878f, 17.426f)
                verticalLineTo(19.289f)
                moveTo(21.149f, 10.889f)
                curveTo(19.537f, 8.828f, 17.321f, 8.003f, 15.048f, 9.009f)
                curveTo(13.263f, 9.801f, 12.071f, 11.541f, 11.463f, 13.343f)
                curveTo(10.694f, 15.611f, 11.052f, 17.99f, 10.801f, 20.333f)
                curveTo(10.665f, 21.656f, 10.192f, 23.026f, 9.156f, 23.842f)
                moveTo(22.304f, 12.988f)
                curveTo(22.812f, 14.336f, 23.069f, 15.766f, 23.06f, 17.207f)
                curveTo(23.052f, 19.028f, 22.63f, 20.823f, 21.827f, 22.456f)
                curveTo(21.371f, 23.393f, 20.409f, 25.042f, 19.134f, 24.395f)
                curveTo(18.094f, 23.867f, 18.267f, 22.646f, 18.563f, 21.714f)
                curveTo(19.126f, 19.945f, 19.948f, 18.415f, 20.03f, 16.51f)
                curveTo(20.108f, 14.724f, 19.549f, 12.848f, 17.782f, 12.098f)
                curveTo(17.278f, 11.881f, 16.718f, 11.838f, 16.188f, 11.976f)
                curveTo(15.658f, 12.114f, 15.189f, 12.425f, 14.854f, 12.861f)
                curveTo(13.354f, 14.922f, 14.201f, 17.207f, 13.506f, 19.479f)
                moveTo(16.289f, 19.842f)
                curveTo(15.607f, 21.755f, 14.826f, 24.036f, 15.467f, 26.065f)
                curveTo(16.252f, 28.539f, 19.076f, 29.389f, 21.346f, 28.588f)
                moveTo(13.103f, 22.238f)
                curveTo(12.89f, 23.023f, 12.585f, 23.78f, 12.194f, 24.494f)
                curveTo(11.802f, 25.21f, 11.237f, 25.815f, 10.55f, 26.254f)
                moveTo(16.926f, 17.174f)
                curveTo(17.085f, 16.475f, 17.129f, 15.755f, 17.058f, 15.042f)
                curveTo(17.147f, 15.755f, 17.103f, 16.478f, 16.926f, 17.174f)
                close()
            }
        }.build()

        return _FingerprintIcon!!
    }

@Suppress("ObjectPropertyName")
private var _FingerprintIcon: ImageVector? = null
