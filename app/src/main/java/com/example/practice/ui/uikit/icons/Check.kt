package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Check: ImageVector
    get() {
        if (_Property1Check != null) {
            return _Property1Check!!
        }
        _Property1Check = ImageVector.Builder(
            name = "Property1Check",
            defaultWidth = 35.dp,
            defaultHeight = 35.dp,
            viewportWidth = 35f,
            viewportHeight = 35f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(17.5f, 17.5f)
                moveToRelative(-17.5f, 0f)
                arcToRelative(17.5f, 17.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 35f, 0f)
                arcToRelative(17.5f, 17.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -35f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF232323)),
                strokeLineWidth = 5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(10f, 18.566f)
                lineTo(14.071f, 24f)
                lineTo(19.536f, 18f)
                lineTo(25f, 12f)
            }
        }.build()

        return _Property1Check!!
    }

@Suppress("ObjectPropertyName")
private var _Property1Check: ImageVector? = null
