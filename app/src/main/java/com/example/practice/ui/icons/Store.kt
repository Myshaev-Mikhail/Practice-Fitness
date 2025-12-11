package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Store: ImageVector
    get() {
        if (_Store != null) {
            return _Store!!
        }
        _Store = ImageVector.Builder(
            name = "Store",
            defaultWidth = 15.dp,
            defaultHeight = 17.dp,
            viewportWidth = 15f,
            viewportHeight = 17f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(4.525f, 7.089f)
                verticalLineTo(3.435f)
                curveTo(4.527f, 2.658f, 4.841f, 1.913f, 5.398f, 1.363f)
                curveTo(5.955f, 0.813f, 6.71f, 0.503f, 7.499f, 0.5f)
                curveTo(8.287f, 0.502f, 9.043f, 0.812f, 9.601f, 1.362f)
                curveTo(10.159f, 1.912f, 10.473f, 2.657f, 10.476f, 3.435f)
                verticalLineTo(7.089f)
                moveTo(14.484f, 13.564f)
                lineTo(13.587f, 7.019f)
                curveTo(13.502f, 6.48f, 13.222f, 5.988f, 12.798f, 5.637f)
                curveTo(12.374f, 5.285f, 11.835f, 5.097f, 11.281f, 5.107f)
                horizontalLineTo(3.719f)
                curveTo(3.165f, 5.097f, 2.626f, 5.285f, 2.202f, 5.637f)
                curveTo(1.778f, 5.988f, 1.498f, 6.48f, 1.413f, 7.019f)
                lineTo(0.516f, 13.564f)
                curveTo(0.474f, 13.94f, 0.514f, 14.32f, 0.634f, 14.679f)
                curveTo(0.753f, 15.038f, 0.949f, 15.368f, 1.209f, 15.646f)
                curveTo(1.469f, 15.924f, 1.786f, 16.144f, 2.139f, 16.291f)
                curveTo(2.492f, 16.438f, 2.873f, 16.509f, 3.256f, 16.499f)
                horizontalLineTo(11.753f)
                curveTo(12.135f, 16.508f, 12.516f, 16.436f, 12.868f, 16.288f)
                curveTo(13.219f, 16.141f, 13.535f, 15.92f, 13.794f, 15.642f)
                curveTo(14.052f, 15.365f, 14.248f, 15.035f, 14.367f, 14.677f)
                curveTo(14.486f, 14.319f, 14.526f, 13.939f, 14.484f, 13.564f)
                close()
            }
        }.build()

        return _Store!!
    }

@Suppress("ObjectPropertyName")
private var _Store: ImageVector? = null
