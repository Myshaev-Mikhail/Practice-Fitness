package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.CheckWhite: ImageVector
    get() {
        if (_CheckWhite != null) {
            return _CheckWhite!!
        }
        _CheckWhite = ImageVector.Builder(
            name = "CheckWhite",
            defaultWidth = 39.dp,
            defaultHeight = 39.dp,
            viewportWidth = 39f,
            viewportHeight = 39f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(32.73f, 5.61f)
                curveTo(30.951f, 3.828f, 28.837f, 2.415f, 26.51f, 1.452f)
                curveTo(24.183f, 0.49f, 21.688f, -0.004f, 19.17f, 0f)
                curveTo(16.652f, -0.004f, 14.157f, 0.49f, 11.83f, 1.452f)
                curveTo(9.503f, 2.415f, 7.389f, 3.828f, 5.61f, 5.61f)
                curveTo(3.828f, 7.389f, 2.415f, 9.503f, 1.452f, 11.83f)
                curveTo(0.489f, 14.157f, -0.004f, 16.652f, 0f, 19.17f)
                curveTo(-0.004f, 21.688f, 0.489f, 24.183f, 1.452f, 26.51f)
                curveTo(2.415f, 28.837f, 3.828f, 30.951f, 5.61f, 32.73f)
                curveTo(7.389f, 34.512f, 9.503f, 35.925f, 11.83f, 36.888f)
                curveTo(14.157f, 37.85f, 16.652f, 38.344f, 19.17f, 38.34f)
                curveTo(21.688f, 38.344f, 24.183f, 37.85f, 26.51f, 36.888f)
                curveTo(28.837f, 35.925f, 30.951f, 34.512f, 32.73f, 32.73f)
                curveTo(34.512f, 30.951f, 35.925f, 28.837f, 36.888f, 26.51f)
                curveTo(37.85f, 24.183f, 38.344f, 21.688f, 38.34f, 19.17f)
                curveTo(38.344f, 16.652f, 37.85f, 14.157f, 36.888f, 11.83f)
                curveTo(35.925f, 9.503f, 34.512f, 7.389f, 32.73f, 5.61f)
                close()
                moveTo(30.42f, 12.86f)
                lineTo(17.58f, 29.6f)
                curveTo(17.368f, 29.885f, 17.099f, 30.122f, 16.788f, 30.295f)
                curveTo(16.478f, 30.467f, 16.134f, 30.571f, 15.78f, 30.6f)
                curveTo(15.429f, 30.63f, 15.076f, 30.584f, 14.744f, 30.465f)
                curveTo(14.413f, 30.346f, 14.111f, 30.157f, 13.86f, 29.91f)
                lineTo(7.67f, 23.91f)
                curveTo(7.193f, 23.449f, 6.917f, 22.818f, 6.904f, 22.154f)
                curveTo(6.891f, 21.491f, 7.141f, 20.85f, 7.6f, 20.37f)
                curveTo(8.062f, 19.894f, 8.694f, 19.621f, 9.358f, 19.61f)
                curveTo(10.021f, 19.598f, 10.662f, 19.85f, 11.14f, 20.31f)
                lineTo(15.32f, 24.31f)
                lineTo(26.45f, 9.79f)
                curveTo(26.649f, 9.528f, 26.898f, 9.308f, 27.183f, 9.143f)
                curveTo(27.467f, 8.978f, 27.781f, 8.87f, 28.107f, 8.826f)
                curveTo(28.434f, 8.783f, 28.765f, 8.804f, 29.083f, 8.889f)
                curveTo(29.401f, 8.973f, 29.699f, 9.12f, 29.96f, 9.32f)
                curveTo(30.224f, 9.521f, 30.446f, 9.773f, 30.612f, 10.06f)
                curveTo(30.778f, 10.347f, 30.886f, 10.665f, 30.929f, 10.994f)
                curveTo(30.972f, 11.323f, 30.949f, 11.658f, 30.861f, 11.978f)
                curveTo(30.774f, 12.298f, 30.624f, 12.598f, 30.42f, 12.86f)
                close()
            }
        }.build()

        return _CheckWhite!!
    }

@Suppress("ObjectPropertyName")
private var _CheckWhite: ImageVector? = null
