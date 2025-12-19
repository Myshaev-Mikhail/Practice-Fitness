package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.FemaleOn: ImageVector
    get() {
        if (_Property1FemaleOn != null) {
            return _Property1FemaleOn!!
        }
        _Property1FemaleOn = ImageVector.Builder(
            name = "Property1FemaleOn",
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
                moveTo(80.5f, 84.65f)
                curveTo(92.93f, 84.65f, 103f, 74.66f, 103f, 62.33f)
                curveTo(103f, 50f, 92.93f, 40f, 80.5f, 40f)
                curveTo(68.07f, 40f, 58f, 50f, 58f, 62.33f)
                curveTo(58f, 74.66f, 68.07f, 84.65f, 80.5f, 84.65f)
                close()
                moveTo(80.5f, 84.65f)
                verticalLineTo(121f)
                moveTo(94.46f, 102.08f)
                horizontalLineTo(66.55f)
            }
        }.build()

        return _Property1FemaleOn!!
    }

@Suppress("ObjectPropertyName")
private var _Property1FemaleOn: ImageVector? = null
