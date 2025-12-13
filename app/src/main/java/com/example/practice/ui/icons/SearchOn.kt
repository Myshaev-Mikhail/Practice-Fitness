package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.SearchOn: ImageVector
    get() {
        if (_SearchOn != null) {
            return _SearchOn!!
        }
        _SearchOn = ImageVector.Builder(
            name = "SearchOn",
            defaultWidth = 44.dp,
            defaultHeight = 42.dp,
            viewportWidth = 44f,
            viewportHeight = 42f
        ).apply {
            path(fill = SolidColor(Color.White), pathFillType = PathFillType.EvenOdd) {
                moveTo(34f, 30.446f)
                lineTo(42.48f, 35.935f)
                curveTo(43.236f, 36.424f, 43.76f, 37.184f, 43.936f, 38.047f)
                curveTo(44.111f, 38.909f, 43.925f, 39.804f, 43.417f, 40.533f)
                curveTo(42.909f, 41.263f, 42.122f, 41.768f, 41.228f, 41.938f)
                curveTo(40.334f, 42.107f, 39.408f, 41.927f, 38.652f, 41.437f)
                curveTo(38.251f, 41.174f, 37.91f, 40.834f, 37.652f, 40.438f)
                lineTo(32.266f, 32.063f)
                curveTo(32.118f, 31.831f, 32.057f, 31.559f, 32.092f, 31.289f)
                curveTo(32.117f, 31.099f, 32.189f, 30.919f, 32.3f, 30.763f)
                curveTo(26.682f, 35.991f, 18.818f, 35.431f, 18.818f, 35.431f)
                curveTo(18.818f, 35.431f, 5.87f, 36.353f, 1.328f, 24.794f)
                curveTo(-0.443f, 20.236f, -0.443f, 15.212f, 1.328f, 10.654f)
                curveTo(5.87f, -0.898f, 18.818f, 0.017f, 18.818f, 0.017f)
                curveTo(18.818f, 0.017f, 31.758f, -0.891f, 36.3f, 10.654f)
                curveTo(38.078f, 15.211f, 38.078f, 20.237f, 36.3f, 24.794f)
                curveTo(35.367f, 27.168f, 34.08f, 29.015f, 32.624f, 30.453f)
                curveTo(32.796f, 30.34f, 32.995f, 30.27f, 33.205f, 30.252f)
                curveTo(33.485f, 30.227f, 33.765f, 30.296f, 34f, 30.446f)
                close()
                moveTo(4.631f, 17.5f)
                arcToRelative(13.895f, 12.833f, 0f, isMoreThanHalf = true, isPositiveArc = false, 27.789f, 0f)
                arcToRelative(13.895f, 12.833f, 0f, isMoreThanHalf = true, isPositiveArc = false, -27.789f, 0f)
                close()
            }
        }.build()

        return _SearchOn!!
    }

@Suppress("ObjectPropertyName")
private var _SearchOn: ImageVector? = null
