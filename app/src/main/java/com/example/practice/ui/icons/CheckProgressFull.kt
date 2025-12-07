package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.CheckProgressFull: ImageVector
    get() {
        if (_Property1Default != null) {
            return _Property1Default!!
        }
        _Property1Default = ImageVector.Builder(
            name = "Property1Default",
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
                moveTo(31.07f, 54.89f)
                lineTo(43.29f, 70.17f)
                lineTo(59.68f, 53.3f)
                lineTo(76.07f, 36.42f)
            }
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
        }.build()

        return _Property1Default!!
    }

@Suppress("ObjectPropertyName")
private var _Property1Default: ImageVector? = null
