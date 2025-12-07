package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.FemaleOff: ImageVector
    get() {
        if (_Property1FmaleOff != null) {
            return _Property1FmaleOff!!
        }
        _Property1FmaleOff = ImageVector.Builder(
            name = "Property1FmaleOff",
            defaultWidth = 171.dp,
            defaultHeight = 171.dp,
            viewportWidth = 171f,
            viewportHeight = 171f
        ).apply {
            path(
                fill = SolidColor(Color.White),
                fillAlpha = 0.09f
            ) {
                moveTo(85.47f, 0f)
                lineTo(85.47f, 0f)
                arcTo(81.47f, 81.47f, 0f, isMoreThanHalf = false, isPositiveArc = true, 166.95f, 81.47f)
                lineTo(166.95f, 81.47f)
                arcTo(81.47f, 81.47f, 0f, isMoreThanHalf = false, isPositiveArc = true, 85.47f, 162.95f)
                lineTo(85.47f, 162.95f)
                arcTo(81.47f, 81.47f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 81.47f)
                lineTo(4f, 81.47f)
                arcTo(81.47f, 81.47f, 0f, isMoreThanHalf = false, isPositiveArc = true, 85.47f, 0f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f
            ) {
                moveTo(85.47f, 0.5f)
                lineTo(85.47f, 0.5f)
                arcTo(80.97f, 80.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, 166.45f, 81.47f)
                lineTo(166.45f, 81.47f)
                arcTo(80.97f, 80.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, 85.47f, 162.45f)
                lineTo(85.47f, 162.45f)
                arcTo(80.97f, 80.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4.5f, 81.47f)
                lineTo(4.5f, 81.47f)
                arcTo(80.97f, 80.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, 85.47f, 0.5f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(84.5f, 84.65f)
                curveTo(96.93f, 84.65f, 107f, 74.66f, 107f, 62.33f)
                curveTo(107f, 50f, 96.93f, 40f, 84.5f, 40f)
                curveTo(72.07f, 40f, 62f, 50f, 62f, 62.33f)
                curveTo(62f, 74.66f, 72.07f, 84.65f, 84.5f, 84.65f)
                close()
                moveTo(84.5f, 84.65f)
                verticalLineTo(121f)
                moveTo(98.46f, 102.08f)
                horizontalLineTo(70.55f)
            }
        }.build()

        return _Property1FmaleOff!!
    }

@Suppress("ObjectPropertyName")
private var _Property1FmaleOff: ImageVector? = null
