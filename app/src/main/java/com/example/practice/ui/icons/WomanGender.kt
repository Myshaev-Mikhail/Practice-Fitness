package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.WomanGender: ImageVector
    get() {
        if (_WomanGender != null) {
            return _WomanGender!!
        }
        _WomanGender = ImageVector.Builder(
            name = "WomanGender",
            defaultWidth = 29.dp,
            defaultHeight = 49.dp,
            viewportWidth = 29f,
            viewportHeight = 49f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 4.13906f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(14.316f, 26.562f)
                curveTo(21.079f, 26.562f, 26.562f, 21.079f, 26.562f, 14.316f)
                curveTo(26.562f, 7.552f, 21.079f, 2.069f, 14.316f, 2.069f)
                curveTo(7.552f, 2.069f, 2.069f, 7.552f, 2.069f, 14.316f)
                curveTo(2.069f, 21.079f, 7.552f, 26.562f, 14.316f, 26.562f)
                close()
                moveTo(14.316f, 26.562f)
                verticalLineTo(46.498f)
                moveTo(21.917f, 36.119f)
                horizontalLineTo(6.724f)
            }
        }.build()

        return _WomanGender!!
    }

@Suppress("ObjectPropertyName")
private var _WomanGender: ImageVector? = null
