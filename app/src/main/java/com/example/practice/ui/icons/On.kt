package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.On: ImageVector
    get() {
        if (_On != null) {
            return _On!!
        }
        _On = ImageVector.Builder(
            name = "On",
            defaultWidth = 31.dp,
            defaultHeight = 15.dp,
            viewportWidth = 31f,
            viewportHeight = 15f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(7.5f, 0f)
                lineTo(23.5f, 0f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 31f, 7.5f)
                lineTo(31f, 7.5f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 23.5f, 15f)
                lineTo(7.5f, 15f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 7.5f)
                lineTo(0f, 7.5f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 7.5f, 0f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(23f, 7.5f)
                moveToRelative(6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = false, -12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = false, 12f, 0f)
            }
        }.build()

        return _On!!
    }

@Suppress("ObjectPropertyName")
private var _On: ImageVector? = null
