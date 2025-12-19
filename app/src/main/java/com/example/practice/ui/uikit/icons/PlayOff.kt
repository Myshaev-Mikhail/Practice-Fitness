package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.PlayOff: ImageVector
    get() {
        if (_Property1PlayOff != null) {
            return _Property1PlayOff!!
        }
        _Property1PlayOff = ImageVector.Builder(
            name = "Property1PlayOff",
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
            path(fill = SolidColor(Color.White)) {
                moveTo(16.424f, 8.618f)
                lineTo(24.341f, 14.004f)
                curveTo(24.857f, 14.355f, 25.275f, 14.808f, 25.563f, 15.328f)
                curveTo(25.85f, 15.847f, 26f, 16.42f, 26f, 17f)
                curveTo(26f, 17.58f, 25.85f, 18.153f, 25.563f, 18.672f)
                curveTo(25.275f, 19.192f, 24.857f, 19.645f, 24.341f, 19.996f)
                lineTo(16.424f, 25.387f)
                curveTo(15.922f, 25.727f, 15.324f, 25.935f, 14.698f, 25.987f)
                curveTo(14.071f, 26.039f, 13.441f, 25.934f, 12.877f, 25.683f)
                curveTo(12.314f, 25.432f, 11.84f, 25.045f, 11.508f, 24.566f)
                curveTo(11.177f, 24.086f, 11f, 23.534f, 11f, 22.97f)
                verticalLineTo(11.031f)
                curveTo(11f, 10.466f, 11.175f, 9.913f, 11.507f, 9.433f)
                curveTo(11.838f, 8.954f, 12.313f, 8.567f, 12.877f, 8.316f)
                curveTo(13.441f, 8.065f, 14.072f, 7.96f, 14.699f, 8.014f)
                curveTo(15.325f, 8.067f, 15.923f, 8.276f, 16.424f, 8.618f)
                close()
            }
        }.build()

        return _Property1PlayOff!!
    }

@Suppress("ObjectPropertyName")
private var _Property1PlayOff: ImageVector? = null
