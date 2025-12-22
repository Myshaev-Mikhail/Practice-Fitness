package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Visibility: ImageVector
    get() {
        if (_Visibility != null) {
            return _Visibility!!
        }
        _Visibility = ImageVector.Builder(
            name = "Visibility",
            defaultWidth = 44.dp,
            defaultHeight = 30.dp,
            viewportWidth = 44f,
            viewportHeight = 30f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(43.056f, 13.37f)
                curveTo(40.056f, 9.57f, 31.706f, 0f, 21.806f, 0f)
                curveTo(11.906f, 0f, 3.526f, 9.57f, 0.526f, 13.37f)
                curveTo(0.185f, 13.807f, 0f, 14.346f, 0f, 14.9f)
                curveTo(0f, 15.454f, 0.185f, 15.993f, 0.526f, 16.43f)
                curveTo(3.466f, 20.23f, 11.866f, 29.81f, 21.776f, 29.81f)
                curveTo(31.686f, 29.81f, 40.076f, 20.23f, 43.026f, 16.43f)
                curveTo(43.366f, 15.994f, 43.553f, 15.458f, 43.558f, 14.905f)
                curveTo(43.564f, 14.352f, 43.387f, 13.813f, 43.056f, 13.37f)
                close()
                moveTo(22.056f, 22.62f)
                curveTo(19.85f, 22.617f, 17.735f, 21.74f, 16.176f, 20.18f)
                curveTo(14.616f, 18.62f, 13.738f, 16.506f, 13.736f, 14.3f)
                curveTo(13.736f, 12.092f, 14.612f, 9.975f, 16.172f, 8.413f)
                curveTo(17.732f, 6.851f, 19.848f, 5.973f, 22.056f, 5.97f)
                curveTo(24.265f, 5.97f, 26.384f, 6.848f, 27.946f, 8.41f)
                curveTo(29.508f, 9.972f, 30.386f, 12.091f, 30.386f, 14.3f)
                curveTo(30.384f, 15.396f, 30.167f, 16.48f, 29.746f, 17.492f)
                curveTo(29.325f, 18.503f, 28.708f, 19.421f, 27.932f, 20.194f)
                curveTo(27.155f, 20.967f, 26.234f, 21.579f, 25.22f, 21.996f)
                curveTo(24.207f, 22.412f, 23.121f, 22.624f, 22.026f, 22.62f)
                horizontalLineTo(22.056f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(24.166f, 10.56f)
                curveTo(23.693f, 10.56f, 23.226f, 10.653f, 22.79f, 10.834f)
                curveTo(22.353f, 11.015f, 21.957f, 11.281f, 21.624f, 11.615f)
                curveTo(21.29f, 11.949f, 21.026f, 12.346f, 20.846f, 12.783f)
                curveTo(20.666f, 13.22f, 20.574f, 13.688f, 20.576f, 14.16f)
                curveTo(20.576f, 15.112f, 20.954f, 16.025f, 21.627f, 16.698f)
                curveTo(22.301f, 17.372f, 23.213f, 17.75f, 24.166f, 17.75f)
                curveTo(24.637f, 17.75f, 25.104f, 17.657f, 25.54f, 17.477f)
                curveTo(25.975f, 17.296f, 26.371f, 17.032f, 26.704f, 16.698f)
                curveTo(27.038f, 16.365f, 27.302f, 15.969f, 27.482f, 15.534f)
                curveTo(27.663f, 15.098f, 27.756f, 14.631f, 27.756f, 14.16f)
                curveTo(27.757f, 13.688f, 27.665f, 13.22f, 27.485f, 12.783f)
                curveTo(27.306f, 12.346f, 27.041f, 11.949f, 26.708f, 11.615f)
                curveTo(26.374f, 11.281f, 25.978f, 11.015f, 25.542f, 10.834f)
                curveTo(25.105f, 10.653f, 24.638f, 10.56f, 24.166f, 10.56f)
                close()
            }
        }.build()

        return _Visibility!!
    }

@Suppress("ObjectPropertyName")
private var _Visibility: ImageVector? = null
