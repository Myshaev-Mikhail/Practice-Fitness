package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.MaleOff: ImageVector
    get() {
        if (_Property1MaleOff != null) {
            return _Property1MaleOff!!
        }
        _Property1MaleOff = ImageVector.Builder(
            name = "Property1MaleOff",
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
                moveTo(91.05f, 74.17f)
                lineTo(116.69f, 47.32f)
                moveTo(116.69f, 47.32f)
                lineTo(117f, 66.62f)
                moveTo(116.69f, 47.32f)
                lineTo(98.26f, 47f)
                moveTo(97.57f, 90.67f)
                curveTo(97.57f, 103.56f, 87.59f, 114f, 75.28f, 114f)
                curveTo(62.98f, 114f, 53f, 103.56f, 53f, 90.67f)
                curveTo(53f, 77.79f, 62.98f, 67.34f, 75.28f, 67.34f)
                curveTo(87.59f, 67.34f, 97.57f, 77.79f, 97.57f, 90.67f)
                close()
            }
        }.build()

        return _Property1MaleOff!!
    }

@Suppress("ObjectPropertyName")
private var _Property1MaleOff: ImageVector? = null
