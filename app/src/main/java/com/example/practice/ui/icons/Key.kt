package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Key: ImageVector
    get() {
        if (_Key != null) {
            return _Key!!
        }
        _Key = ImageVector.Builder(
            name = "Key",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF896CFE)),
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 2f
            ) {
                moveTo(20f, 20f)
                moveToRelative(-19f, 0f)
                arcToRelative(19f, 19f, 0f, isMoreThanHalf = true, isPositiveArc = true, 38f, 0f)
                arcToRelative(19f, 19f, 0f, isMoreThanHalf = true, isPositiveArc = true, -38f, 0f)
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 3f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15.222f, 20f)
                horizontalLineTo(33f)
                moveTo(25.897f, 20f)
                verticalLineTo(23.53f)
                moveTo(30.561f, 20f)
                verticalLineTo(25.445f)
                moveTo(10.343f, 14f)
                horizontalLineTo(13.878f)
                curveTo(14.62f, 14f, 15.222f, 14.609f, 15.222f, 15.36f)
                verticalLineTo(24.64f)
                curveTo(15.222f, 25.391f, 14.62f, 26f, 13.878f, 26f)
                horizontalLineTo(10.343f)
                curveTo(9.601f, 26f, 9f, 25.391f, 9f, 24.64f)
                verticalLineTo(15.36f)
                curveTo(9f, 14.609f, 9.601f, 14f, 10.343f, 14f)
                close()
            }
        }.build()

        return _Key!!
    }

@Suppress("ObjectPropertyName")
private var _Key: ImageVector? = null
