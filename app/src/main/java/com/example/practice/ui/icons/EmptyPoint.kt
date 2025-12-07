package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.EmptyPoint: ImageVector
    get() {
        if (_EmptyPoint != null) {
            return _EmptyPoint!!
        }
        _EmptyPoint = ImageVector.Builder(
            name = "EmptyPoint",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 1f
            ) {
                moveTo(10f, 10f)
                moveToRelative(-9.5f, 0f)
                arcToRelative(9.5f, 9.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 19f, 0f)
                arcToRelative(9.5f, 9.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -19f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 1f
            ) {
                moveTo(10f, 10f)
                moveToRelative(-5.5f, 0f)
                arcToRelative(5.5f, 5.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 11f, 0f)
                arcToRelative(5.5f, 5.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -11f, 0f)
            }
        }.build()

        return _EmptyPoint!!
    }

@Suppress("ObjectPropertyName")
private var _EmptyPoint: ImageVector? = null
