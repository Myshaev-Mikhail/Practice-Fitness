package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Favorites: ImageVector
    get() {
        if (_Favorites != null) {
            return _Favorites!!
        }
        _Favorites = ImageVector.Builder(
            name = "Favorites",
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
                moveTo(31.228f, 15.448f)
                lineTo(26.496f, 14.256f)
                curveTo(25.911f, 14.107f, 25.404f, 13.741f, 25.079f, 13.232f)
                lineTo(22.483f, 9.099f)
                curveTo(22.275f, 8.76f, 21.983f, 8.481f, 21.635f, 8.288f)
                curveTo(21.287f, 8.095f, 20.895f, 7.996f, 20.497f, 8f)
                curveTo(20.1f, 7.997f, 19.709f, 8.097f, 19.362f, 8.289f)
                curveTo(19.015f, 8.482f, 18.724f, 8.761f, 18.517f, 9.099f)
                lineTo(15.915f, 13.232f)
                curveTo(15.594f, 13.741f, 15.089f, 14.108f, 14.505f, 14.256f)
                lineTo(9.773f, 15.448f)
                curveTo(9.388f, 15.544f, 9.034f, 15.737f, 8.744f, 16.008f)
                curveTo(8.454f, 16.279f, 8.237f, 16.619f, 8.115f, 16.996f)
                curveTo(7.992f, 17.374f, 7.967f, 17.776f, 8.043f, 18.165f)
                curveTo(8.118f, 18.555f, 8.292f, 18.919f, 8.546f, 19.223f)
                lineTo(11.672f, 22.97f)
                curveTo(12.059f, 23.432f, 12.252f, 24.026f, 12.213f, 24.627f)
                lineTo(11.885f, 29.496f)
                curveTo(11.864f, 29.817f, 11.909f, 30.138f, 12.016f, 30.44f)
                curveTo(12.124f, 30.742f, 12.293f, 31.019f, 12.512f, 31.254f)
                curveTo(12.731f, 31.489f, 12.996f, 31.676f, 13.29f, 31.804f)
                curveTo(13.584f, 31.933f, 13.901f, 31.999f, 14.222f, 32f)
                curveTo(14.522f, 32f, 14.819f, 31.943f, 15.097f, 31.833f)
                lineTo(19.628f, 30.014f)
                curveTo(19.905f, 29.906f, 20.199f, 29.849f, 20.497f, 29.847f)
                curveTo(20.797f, 29.848f, 21.093f, 29.905f, 21.372f, 30.014f)
                lineTo(25.903f, 31.833f)
                curveTo(26.181f, 31.943f, 26.478f, 32f, 26.778f, 32f)
                curveTo(27.099f, 31.999f, 27.416f, 31.933f, 27.71f, 31.804f)
                curveTo(28.004f, 31.676f, 28.269f, 31.489f, 28.488f, 31.254f)
                curveTo(28.707f, 31.019f, 28.876f, 30.742f, 28.984f, 30.44f)
                curveTo(29.091f, 30.138f, 29.136f, 29.817f, 29.115f, 29.496f)
                lineTo(28.787f, 24.627f)
                curveTo(28.748f, 24.026f, 28.941f, 23.432f, 29.328f, 22.97f)
                lineTo(32.454f, 19.223f)
                curveTo(32.708f, 18.919f, 32.882f, 18.555f, 32.957f, 18.165f)
                curveTo(33.033f, 17.776f, 33.008f, 17.374f, 32.886f, 16.996f)
                curveTo(32.763f, 16.619f, 32.546f, 16.279f, 32.256f, 16.008f)
                curveTo(31.966f, 15.737f, 31.612f, 15.544f, 31.228f, 15.448f)
                close()
            }
        }.build()

        return _Favorites!!
    }

@Suppress("ObjectPropertyName")
private var _Favorites: ImageVector? = null
