package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Message: ImageVector
    get() {
        if (_Message != null) {
            return _Message!!
        }
        _Message = ImageVector.Builder(
            name = "Message",
            defaultWidth = 42.dp,
            defaultHeight = 38.dp,
            viewportWidth = 42f,
            viewportHeight = 38f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(34.55f, 0f)
                horizontalLineTo(6.61f)
                curveTo(5.742f, 0f, 4.883f, 0.171f, 4.081f, 0.503f)
                curveTo(3.279f, 0.835f, 2.55f, 1.322f, 1.936f, 1.936f)
                curveTo(1.322f, 2.55f, 0.835f, 3.278f, 0.503f, 4.08f)
                curveTo(0.171f, 4.882f, 0f, 5.742f, 0f, 6.61f)
                verticalLineTo(35.23f)
                curveTo(0f, 35.914f, 0.272f, 36.57f, 0.756f, 37.054f)
                curveTo(1.239f, 37.538f, 1.896f, 37.81f, 2.58f, 37.81f)
                curveTo(3.078f, 37.805f, 3.565f, 37.655f, 3.98f, 37.38f)
                lineTo(9.44f, 33.79f)
                curveTo(9.858f, 33.513f, 10.349f, 33.367f, 10.85f, 33.37f)
                horizontalLineTo(34.55f)
                curveTo(36.303f, 33.37f, 37.985f, 32.674f, 39.224f, 31.434f)
                curveTo(40.464f, 30.194f, 41.16f, 28.513f, 41.16f, 26.76f)
                verticalLineTo(6.66f)
                curveTo(41.167f, 5.788f, 41.001f, 4.923f, 40.671f, 4.115f)
                curveTo(40.342f, 3.307f, 39.856f, 2.573f, 39.242f, 1.954f)
                curveTo(38.627f, 1.335f, 37.896f, 0.843f, 37.091f, 0.508f)
                curveTo(36.286f, 0.173f, 35.422f, -0f, 34.55f, 0f)
                close()
                moveTo(10.07f, 19.12f)
                curveTo(9.373f, 19.12f, 8.704f, 18.843f, 8.21f, 18.35f)
                curveTo(7.717f, 17.856f, 7.44f, 17.188f, 7.44f, 16.49f)
                curveTo(7.44f, 15.792f, 7.717f, 15.123f, 8.21f, 14.63f)
                curveTo(8.704f, 14.137f, 9.373f, 13.86f, 10.07f, 13.86f)
                curveTo(10.768f, 13.86f, 11.436f, 14.137f, 11.93f, 14.63f)
                curveTo(12.423f, 15.123f, 12.7f, 15.792f, 12.7f, 16.49f)
                curveTo(12.7f, 17.186f, 12.424f, 17.853f, 11.933f, 18.346f)
                curveTo(11.442f, 18.839f, 10.776f, 19.117f, 10.08f, 19.12f)
                horizontalLineTo(10.07f)
                close()
                moveTo(20.58f, 19.12f)
                curveTo(19.883f, 19.12f, 19.214f, 18.843f, 18.721f, 18.35f)
                curveTo(18.227f, 17.856f, 17.95f, 17.188f, 17.95f, 16.49f)
                curveTo(17.95f, 15.792f, 18.227f, 15.123f, 18.721f, 14.63f)
                curveTo(19.214f, 14.137f, 19.883f, 13.86f, 20.58f, 13.86f)
                curveTo(21.278f, 13.86f, 21.947f, 14.137f, 22.44f, 14.63f)
                curveTo(22.933f, 15.123f, 23.21f, 15.792f, 23.21f, 16.49f)
                curveTo(23.21f, 16.838f, 23.141f, 17.182f, 23.007f, 17.503f)
                curveTo(22.873f, 17.824f, 22.677f, 18.116f, 22.429f, 18.36f)
                curveTo(22.182f, 18.605f, 21.888f, 18.798f, 21.566f, 18.928f)
                curveTo(21.243f, 19.059f, 20.898f, 19.124f, 20.55f, 19.12f)
                horizontalLineTo(20.58f)
                close()
                moveTo(31.09f, 19.12f)
                curveTo(30.393f, 19.12f, 29.724f, 18.843f, 29.23f, 18.35f)
                curveTo(28.737f, 17.856f, 28.46f, 17.188f, 28.46f, 16.49f)
                curveTo(28.46f, 15.792f, 28.737f, 15.123f, 29.23f, 14.63f)
                curveTo(29.724f, 14.137f, 30.393f, 13.86f, 31.09f, 13.86f)
                curveTo(31.788f, 13.86f, 32.457f, 14.137f, 32.95f, 14.63f)
                curveTo(33.443f, 15.123f, 33.72f, 15.792f, 33.72f, 16.49f)
                curveTo(33.72f, 17.186f, 33.444f, 17.853f, 32.953f, 18.346f)
                curveTo(32.462f, 18.839f, 31.796f, 19.117f, 31.1f, 19.12f)
                horizontalLineTo(31.09f)
                close()
            }
        }.build()

        return _Message!!
    }

@Suppress("ObjectPropertyName")
private var _Message: ImageVector? = null
