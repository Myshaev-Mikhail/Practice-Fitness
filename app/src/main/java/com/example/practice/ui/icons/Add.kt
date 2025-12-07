package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.github.composegears.valkyrie.ValkyrieIcons

val ValkyrieIcons.Add: ImageVector
    get() {
        if (_Property1Add != null) {
            return _Property1Add!!
        }
        _Property1Add = ImageVector.Builder(
            name = "Property1Add",
            defaultWidth = 35.dp,
            defaultHeight = 35.dp,
            viewportWidth = 35f,
            viewportHeight = 35f
        ).apply {
            path(fill = SolidColor(Color(0xFF896CFE))) {
                moveTo(17.5f, 17.5f)
                moveToRelative(-17.5f, 0f)
                arcToRelative(17.5f, 17.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 35f, 0f)
                arcToRelative(17.5f, 17.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -35f, 0f)
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(17.505f, 10f)
                verticalLineTo(17.412f)
                moveTo(17.505f, 17.412f)
                verticalLineTo(25f)
                moveTo(17.505f, 17.412f)
                horizontalLineTo(25f)
                moveTo(17.505f, 17.412f)
                horizontalLineTo(10f)
            }
        }.build()

        return _Property1Add!!
    }

@Suppress("ObjectPropertyName")
private var _Property1Add: ImageVector? = null
