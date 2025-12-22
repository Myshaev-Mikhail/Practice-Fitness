package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.ManGender: ImageVector
    get() {
        if (_ManGender != null) {
            return _ManGender!!
        }
        _ManGender = ImageVector.Builder(
            name = "ManGender",
            defaultWidth = 41.dp,
            defaultHeight = 41.dp,
            viewportWidth = 41f,
            viewportHeight = 41f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 4.13906f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(23.951f, 16.996f)
                lineTo(38.701f, 2.245f)
                moveTo(38.701f, 2.245f)
                lineTo(38.877f, 12.848f)
                moveTo(38.701f, 2.245f)
                lineTo(28.099f, 2.069f)
                moveTo(27.701f, 26.062f)
                curveTo(27.701f, 33.14f, 21.963f, 38.877f, 14.885f, 38.877f)
                curveTo(7.807f, 38.877f, 2.069f, 33.14f, 2.069f, 26.062f)
                curveTo(2.069f, 18.984f, 7.807f, 13.246f, 14.885f, 13.246f)
                curveTo(21.963f, 13.246f, 27.701f, 18.984f, 27.701f, 26.062f)
                close()
            }
        }.build()

        return _ManGender!!
    }

@Suppress("ObjectPropertyName")
private var _ManGender: ImageVector? = null
