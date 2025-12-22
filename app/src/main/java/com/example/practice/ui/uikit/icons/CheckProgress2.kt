package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.CheckProgress2: ImageVector
    get() {
        if (_Property1Variant3 != null) {
            return _Property1Variant3!!
        }
        _Property1Variant3 = ImageVector.Builder(
            name = "Property1Variant3",
            defaultWidth = 107.dp,
            defaultHeight = 107.dp,
            viewportWidth = 107f,
            viewportHeight = 107f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(53.5f, 103.5f)
                curveTo(81.11f, 103.5f, 103.5f, 81.11f, 103.5f, 53.5f)
                curveTo(103.5f, 25.89f, 81.11f, 3.5f, 53.5f, 3.5f)
                curveTo(25.89f, 3.5f, 3.5f, 25.89f, 3.5f, 53.5f)
                curveTo(3.5f, 81.11f, 25.89f, 103.5f, 53.5f, 103.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF896CFE))) {
                moveTo(32f, 53f)
                moveToRelative(-6.5f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 13f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -13f, 0f)
            }
            path(fill = SolidColor(Color(0xFF896CFE))) {
                moveTo(54f, 53f)
                moveToRelative(-6.5f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 13f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -13f, 0f)
            }
        }.build()

        return _Property1Variant3!!
    }

@Suppress("ObjectPropertyName")
private var _Property1Variant3: ImageVector? = null
