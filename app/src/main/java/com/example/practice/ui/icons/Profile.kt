package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Profile: ImageVector
    get() {
        if (_Profile != null) {
            return _Profile!!
        }
        _Profile = ImageVector.Builder(
            name = "Profile",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(fill = SolidColor(Color(0xFF896CFE))) {
                moveTo(20f, 20f)
                moveToRelative(-20f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, 40f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, -40f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(20f, 15.473f)
                curveTo(20.552f, 15.473f, 21.098f, 15.363f, 21.608f, 15.15f)
                curveTo(22.118f, 14.937f, 22.581f, 14.625f, 22.971f, 14.231f)
                curveTo(23.361f, 13.837f, 23.67f, 13.37f, 23.881f, 12.856f)
                curveTo(24.091f, 12.342f, 24.2f, 11.791f, 24.199f, 11.234f)
                curveTo(24.199f, 10.111f, 23.757f, 9.034f, 22.969f, 8.24f)
                curveTo(22.182f, 7.446f, 21.114f, 7f, 20f, 7f)
                curveTo(18.886f, 7f, 17.818f, 7.446f, 17.031f, 8.24f)
                curveTo(16.243f, 9.034f, 15.801f, 10.111f, 15.801f, 11.234f)
                curveTo(15.801f, 12.358f, 16.243f, 13.435f, 17.03f, 14.23f)
                curveTo(17.818f, 15.025f, 18.886f, 15.472f, 20f, 15.473f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(30f, 27.822f)
                curveTo(29.999f, 25.148f, 28.945f, 22.584f, 27.07f, 20.694f)
                curveTo(25.194f, 18.804f, 22.652f, 17.742f, 20f, 17.742f)
                curveTo(17.348f, 17.742f, 14.806f, 18.804f, 12.93f, 20.694f)
                curveTo(11.055f, 22.584f, 10.001f, 25.148f, 10f, 27.822f)
                curveTo(10f, 33.393f, 30f, 33.393f, 30f, 27.822f)
                close()
            }
        }.build()

        return _Profile!!
    }

@Suppress("ObjectPropertyName")
private var _Profile: ImageVector? = null
