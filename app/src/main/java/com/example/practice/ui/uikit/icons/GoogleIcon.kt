package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.GoogleIcon: ImageVector
    get() {
        if (_GoogleIcon != null) {
            return _GoogleIcon!!
        }
        _GoogleIcon = ImageVector.Builder(
            name = "GoogleIcon",
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
                strokeLineWidth = 1.34766f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(23.291f, 10.307f)
                curveTo(21.74f, 8.877f, 19.743f, 8.025f, 17.638f, 7.894f)
                curveTo(15.532f, 7.762f, 13.445f, 8.36f, 11.728f, 9.585f)
                curveTo(10.01f, 10.811f, 8.767f, 12.59f, 8.207f, 14.624f)
                curveTo(7.646f, 16.658f, 7.803f, 18.823f, 8.65f, 20.755f)
                curveTo(9.497f, 22.687f, 10.983f, 24.269f, 12.859f, 25.235f)
                curveTo(14.735f, 26.2f, 16.885f, 26.491f, 18.95f, 26.059f)
                curveTo(21.015f, 25.626f, 22.868f, 24.496f, 24.198f, 22.858f)
                curveTo(25.528f, 21.22f, 26.254f, 19.175f, 26.254f, 17.065f)
                lineTo(17.066f, 17.065f)
            }
        }.build()

        return _GoogleIcon!!
    }

@Suppress("ObjectPropertyName")
private var _GoogleIcon: ImageVector? = null
