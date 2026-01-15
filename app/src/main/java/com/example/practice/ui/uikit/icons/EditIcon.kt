package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.EditIcon: ImageVector
    get() {
        if (_EditIcon != null) {
            return _EditIcon!!
        }
        _EditIcon = ImageVector.Builder(
            name = "EditIcon",
            defaultWidth = 27.dp,
            defaultHeight = 27.dp,
            viewportWidth = 27f,
            viewportHeight = 27f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(13.5f, 13.5f)
                moveToRelative(-13.5f, 0f)
                arcToRelative(13.5f, 13.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 27f, 0f)
                arcToRelative(13.5f, 13.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -27f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF252525)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveToRelative(14.273f, 20.512f)
                lineToRelative(5.288f, -2.983f)
                moveToRelative(-8.186f, -8.34f)
                lineToRelative(5.731f, 9.724f)
                moveTo(13.76f, 7.457f)
                curveToRelative(0.087f, 0.15f, 0.03f, 0.344f, -0.127f, 0.434f)
                lineToRelative(-4.75f, 2.728f)
                arcToRelative(0.322f, 0.322f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.44f, -0.108f)
                curveToRelative(-1.96f, -3.378f, -0.685f, -4.67f, 0.454f, -5.325f)
                curveToRelative(1.14f, -0.655f, 2.9f, -1.113f, 4.863f, 2.27f)
                close()
                moveTo(13.917f, 7.728f)
                lineTo(19.48f, 17.315f)
                curveToRelative(0.068f, 0.117f, 0.101f, 0.25f, 0.094f, 0.386f)
                arcToRelative(32.662f, 32.662f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.482f, 4.033f)
                arcToRelative(0.656f, 0.656f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.867f, 0.503f)
                arcToRelative(31.766f, 31.766f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.773f, -1.595f)
                arcToRelative(0.697f, 0.697f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.288f, -0.273f)
                lineTo(8.6f, 10.782f)
                lineToRelative(5.317f, -3.054f)
                close()
            }
        }.build()

        return _EditIcon!!
    }

@Suppress("ObjectPropertyName")
private var _EditIcon: ImageVector? = null