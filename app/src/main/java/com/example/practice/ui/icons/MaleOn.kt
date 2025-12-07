package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Property1MaleOn: ImageVector
    get() {
        if (_Property1MaleOn != null) {
            return _Property1MaleOn!!
        }
        _Property1MaleOn = ImageVector.Builder(
            name = "Property1MaleOn",
            defaultWidth = 162.dp,
            defaultHeight = 162.dp,
            viewportWidth = 162f,
            viewportHeight = 162f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(81f, 81f)
                moveToRelative(-81f, 0f)
                arcToRelative(81f, 81f, 0f, isMoreThanHalf = true, isPositiveArc = true, 162f, 0f)
                arcToRelative(81f, 81f, 0f, isMoreThanHalf = true, isPositiveArc = true, -162f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF232323)),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(87.05f, 74.17f)
                lineTo(112.69f, 47.32f)
                moveTo(112.69f, 47.32f)
                lineTo(113f, 66.62f)
                moveTo(112.69f, 47.32f)
                lineTo(94.26f, 47f)
                moveTo(93.57f, 90.67f)
                curveTo(93.57f, 103.56f, 83.59f, 114f, 71.28f, 114f)
                curveTo(58.98f, 114f, 49f, 103.56f, 49f, 90.67f)
                curveTo(49f, 77.79f, 58.98f, 67.34f, 71.28f, 67.34f)
                curveTo(83.59f, 67.34f, 93.57f, 77.79f, 93.57f, 90.67f)
                close()
            }
        }.build()

        return _Property1MaleOn!!
    }

@Suppress("ObjectPropertyName")
private var _Property1MaleOn: ImageVector? = null
