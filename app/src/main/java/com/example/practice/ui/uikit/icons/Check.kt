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
        if (_Check != null) {
            return _Check!!
        }
        _Check = ImageVector.Builder(
            name = "Vector",
            defaultWidth = 52.dp,
            defaultHeight = 41.dp,
            viewportWidth = 52f,
            viewportHeight = 41f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(3.5f, 21.967f)
                lineTo(15.714f, 37.25f)
                lineTo(32.107f, 20.375f)
                lineTo(48.5f, 3.5f)
            }
        }.build()

        return _Check!!
    }

@Suppress("ObjectPropertyName")
private var _Check: ImageVector? = null
