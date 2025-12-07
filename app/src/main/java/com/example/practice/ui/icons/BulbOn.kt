package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.BulbOn: ImageVector
    get() {
        if (_Property1BulbOn != null) {
            return _Property1BulbOn!!
        }
        _Property1BulbOn = ImageVector.Builder(
            name = "Property1BulbOn",
            defaultWidth = 48.dp,
            defaultHeight = 45.dp,
            viewportWidth = 48f,
            viewportHeight = 45f
        ).apply {
            path(fill = SolidColor(Color(0xFFE2F163))) {
                moveTo(25.5f, 22.5f)
                moveToRelative(-22.5f, 0f)
                arcToRelative(22.5f, 22.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 45f, 0f)
                arcToRelative(22.5f, 22.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -45f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB3A0FF))) {
                moveTo(6.5f, 9.5f)
                moveToRelative(-6.5f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 13f, 0f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -13f, 0f)
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(34.363f, 21.162f)
                curveTo(34.215f, 18.952f, 33.274f, 16.872f, 31.716f, 15.315f)
                curveTo(30.159f, 13.757f, 28.092f, 12.828f, 25.904f, 12.702f)
                horizontalLineTo(25.114f)
                curveTo(22.926f, 12.828f, 20.86f, 13.757f, 19.302f, 15.315f)
                curveTo(17.744f, 16.872f, 16.803f, 18.952f, 16.656f, 21.162f)
                curveTo(16.656f, 21.334f, 16.656f, 21.513f, 16.656f, 21.685f)
                curveTo(16.658f, 23.279f, 17.078f, 24.845f, 17.872f, 26.222f)
                curveTo(18.322f, 26.926f, 18.833f, 27.589f, 19.398f, 28.202f)
                curveTo(20.068f, 28.927f, 20.616f, 29.758f, 21.022f, 30.662f)
                curveTo(21.277f, 31.276f, 21.447f, 31.891f, 21.63f, 32.408f)
                curveTo(21.75f, 32.756f, 21.975f, 33.057f, 22.272f, 33.271f)
                curveTo(22.569f, 33.484f, 22.925f, 33.599f, 23.29f, 33.6f)
                horizontalLineTo(27.765f)
                curveTo(28.131f, 33.599f, 28.486f, 33.484f, 28.785f, 33.27f)
                curveTo(29.083f, 33.057f, 29.309f, 32.756f, 29.431f, 32.408f)
                curveTo(29.62f, 31.873f, 29.79f, 31.276f, 30.039f, 30.662f)
                curveTo(30.447f, 29.759f, 30.995f, 28.929f, 31.663f, 28.202f)
                curveTo(32.228f, 27.589f, 32.739f, 26.926f, 33.189f, 26.222f)
                curveTo(33.983f, 24.845f, 34.403f, 23.279f, 34.405f, 21.685f)
                curveTo(34.375f, 21.519f, 34.375f, 21.341f, 34.363f, 21.162f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(25.485f, 9.665f)
                curveTo(25.727f, 9.665f, 25.959f, 9.568f, 26.13f, 9.395f)
                curveTo(26.301f, 9.222f, 26.397f, 8.987f, 26.397f, 8.743f)
                verticalLineTo(6.222f)
                curveTo(26.397f, 5.977f, 26.301f, 5.743f, 26.13f, 5.57f)
                curveTo(25.959f, 5.397f, 25.727f, 5.3f, 25.485f, 5.3f)
                curveTo(25.243f, 5.3f, 25.011f, 5.397f, 24.84f, 5.57f)
                curveTo(24.669f, 5.743f, 24.573f, 5.977f, 24.573f, 6.222f)
                verticalLineTo(8.743f)
                curveTo(24.573f, 8.987f, 24.669f, 9.222f, 24.84f, 9.395f)
                curveTo(25.011f, 9.568f, 25.243f, 9.665f, 25.485f, 9.665f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(15.889f, 13.016f)
                curveTo(16.061f, 13.187f, 16.293f, 13.283f, 16.534f, 13.283f)
                curveTo(16.775f, 13.283f, 17.007f, 13.187f, 17.179f, 13.016f)
                curveTo(17.264f, 12.931f, 17.332f, 12.829f, 17.378f, 12.717f)
                curveTo(17.424f, 12.606f, 17.448f, 12.485f, 17.448f, 12.364f)
                curveTo(17.448f, 12.243f, 17.424f, 12.123f, 17.378f, 12.011f)
                curveTo(17.332f, 11.899f, 17.264f, 11.798f, 17.179f, 11.712f)
                lineTo(15.032f, 9.536f)
                curveTo(14.947f, 9.45f, 14.846f, 9.381f, 14.735f, 9.334f)
                curveTo(14.624f, 9.287f, 14.505f, 9.263f, 14.385f, 9.263f)
                curveTo(14.264f, 9.263f, 14.145f, 9.287f, 14.034f, 9.334f)
                curveTo(13.923f, 9.381f, 13.822f, 9.45f, 13.737f, 9.536f)
                curveTo(13.568f, 9.71f, 13.473f, 9.944f, 13.473f, 10.188f)
                curveTo(13.473f, 10.432f, 13.568f, 10.666f, 13.737f, 10.839f)
                lineTo(15.889f, 13.016f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(12.715f, 20.406f)
                horizontalLineTo(9.912f)
                curveTo(9.67f, 20.406f, 9.438f, 20.503f, 9.267f, 20.676f)
                curveTo(9.096f, 20.849f, 9f, 21.084f, 9f, 21.328f)
                curveTo(9f, 21.573f, 9.096f, 21.808f, 9.267f, 21.98f)
                curveTo(9.438f, 22.153f, 9.67f, 22.251f, 9.912f, 22.251f)
                horizontalLineTo(12.715f)
                curveTo(12.957f, 22.251f, 13.189f, 22.153f, 13.36f, 21.98f)
                curveTo(13.531f, 21.808f, 13.627f, 21.573f, 13.627f, 21.328f)
                curveTo(13.627f, 21.084f, 13.531f, 20.849f, 13.36f, 20.676f)
                curveTo(13.189f, 20.503f, 12.957f, 20.406f, 12.715f, 20.406f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(15.665f, 29.739f)
                lineTo(13.682f, 31.744f)
                curveTo(13.597f, 31.829f, 13.529f, 31.93f, 13.483f, 32.042f)
                curveTo(13.437f, 32.154f, 13.413f, 32.274f, 13.413f, 32.395f)
                curveTo(13.413f, 32.516f, 13.437f, 32.637f, 13.483f, 32.749f)
                curveTo(13.529f, 32.86f, 13.597f, 32.962f, 13.682f, 33.047f)
                curveTo(13.767f, 33.133f, 13.867f, 33.202f, 13.977f, 33.249f)
                curveTo(14.088f, 33.295f, 14.207f, 33.319f, 14.327f, 33.319f)
                curveTo(14.447f, 33.319f, 14.565f, 33.295f, 14.676f, 33.249f)
                curveTo(14.787f, 33.202f, 14.887f, 33.133f, 14.971f, 33.047f)
                lineTo(16.96f, 31.043f)
                curveTo(17.129f, 30.869f, 17.224f, 30.635f, 17.224f, 30.391f)
                curveTo(17.224f, 30.147f, 17.129f, 29.913f, 16.96f, 29.739f)
                curveTo(16.875f, 29.653f, 16.774f, 29.584f, 16.663f, 29.537f)
                curveTo(16.552f, 29.49f, 16.433f, 29.466f, 16.312f, 29.466f)
                curveTo(16.192f, 29.466f, 16.073f, 29.49f, 15.961f, 29.537f)
                curveTo(15.85f, 29.584f, 15.749f, 29.653f, 15.665f, 29.739f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(34.788f, 29.961f)
                curveTo(34.616f, 29.788f, 34.383f, 29.69f, 34.141f, 29.69f)
                curveTo(33.898f, 29.69f, 33.665f, 29.788f, 33.493f, 29.961f)
                curveTo(33.324f, 30.134f, 33.229f, 30.368f, 33.229f, 30.612f)
                curveTo(33.229f, 30.856f, 33.324f, 31.09f, 33.493f, 31.264f)
                lineTo(35.257f, 33.041f)
                curveTo(35.341f, 33.127f, 35.441f, 33.196f, 35.552f, 33.242f)
                curveTo(35.662f, 33.289f, 35.781f, 33.313f, 35.901f, 33.313f)
                curveTo(36.021f, 33.313f, 36.14f, 33.289f, 36.25f, 33.242f)
                curveTo(36.361f, 33.196f, 36.461f, 33.127f, 36.546f, 33.041f)
                curveTo(36.631f, 32.956f, 36.699f, 32.854f, 36.745f, 32.742f)
                curveTo(36.791f, 32.63f, 36.815f, 32.51f, 36.815f, 32.389f)
                curveTo(36.815f, 32.268f, 36.791f, 32.148f, 36.745f, 32.036f)
                curveTo(36.699f, 31.924f, 36.631f, 31.823f, 36.546f, 31.737f)
                lineTo(34.788f, 29.961f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(41.088f, 20.726f)
                horizontalLineTo(37.944f)
                curveTo(37.702f, 20.726f, 37.47f, 20.823f, 37.299f, 20.996f)
                curveTo(37.128f, 21.169f, 37.032f, 21.403f, 37.032f, 21.648f)
                curveTo(37.032f, 21.893f, 37.128f, 22.127f, 37.299f, 22.3f)
                curveTo(37.47f, 22.473f, 37.702f, 22.57f, 37.944f, 22.57f)
                horizontalLineTo(41.088f)
                curveTo(41.33f, 22.57f, 41.562f, 22.473f, 41.733f, 22.3f)
                curveTo(41.904f, 22.127f, 42f, 21.893f, 42f, 21.648f)
                curveTo(42f, 21.403f, 41.904f, 21.169f, 41.733f, 20.996f)
                curveTo(41.562f, 20.823f, 41.33f, 20.726f, 41.088f, 20.726f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(35.007f, 13.243f)
                lineTo(37.081f, 11.147f)
                curveTo(37.25f, 10.973f, 37.345f, 10.739f, 37.345f, 10.495f)
                curveTo(37.345f, 10.251f, 37.25f, 10.017f, 37.081f, 9.843f)
                curveTo(36.908f, 9.672f, 36.675f, 9.576f, 36.433f, 9.576f)
                curveTo(36.191f, 9.576f, 35.958f, 9.672f, 35.785f, 9.843f)
                lineTo(33.718f, 11.94f)
                curveTo(33.549f, 12.114f, 33.454f, 12.348f, 33.454f, 12.592f)
                curveTo(33.454f, 12.836f, 33.549f, 13.07f, 33.718f, 13.243f)
                curveTo(33.89f, 13.415f, 34.121f, 13.511f, 34.363f, 13.511f)
                curveTo(34.604f, 13.511f, 34.835f, 13.415f, 35.007f, 13.243f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(27.419f, 37.265f)
                horizontalLineTo(23.588f)
                curveTo(23.534f, 37.264f, 23.481f, 37.276f, 23.432f, 37.3f)
                curveTo(23.384f, 37.324f, 23.342f, 37.36f, 23.311f, 37.404f)
                curveTo(23.279f, 37.448f, 23.259f, 37.499f, 23.251f, 37.553f)
                curveTo(23.243f, 37.607f, 23.248f, 37.662f, 23.265f, 37.714f)
                curveTo(23.432f, 38.179f, 23.736f, 38.58f, 24.136f, 38.864f)
                curveTo(24.537f, 39.148f, 25.014f, 39.3f, 25.503f, 39.3f)
                curveTo(25.991f, 39.3f, 26.468f, 39.147f, 26.867f, 38.864f)
                curveTo(27.267f, 38.58f, 27.569f, 38.178f, 27.735f, 37.714f)
                curveTo(27.752f, 37.663f, 27.757f, 37.608f, 27.75f, 37.555f)
                curveTo(27.742f, 37.501f, 27.722f, 37.451f, 27.691f, 37.407f)
                curveTo(27.66f, 37.363f, 27.619f, 37.327f, 27.572f, 37.302f)
                curveTo(27.524f, 37.278f, 27.472f, 37.265f, 27.419f, 37.265f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232323))) {
                moveTo(27.954f, 34.486f)
                horizontalLineTo(22.846f)
                curveTo(22.626f, 34.486f, 22.416f, 34.574f, 22.261f, 34.731f)
                curveTo(22.106f, 34.887f, 22.019f, 35.1f, 22.019f, 35.322f)
                verticalLineTo(35.5f)
                curveTo(22.021f, 35.721f, 22.108f, 35.932f, 22.263f, 36.088f)
                curveTo(22.418f, 36.243f, 22.628f, 36.33f, 22.846f, 36.33f)
                horizontalLineTo(27.954f)
                curveTo(28.172f, 36.33f, 28.381f, 36.243f, 28.536f, 36.088f)
                curveTo(28.691f, 35.932f, 28.779f, 35.721f, 28.781f, 35.5f)
                verticalLineTo(35.322f)
                curveTo(28.781f, 35.1f, 28.694f, 34.887f, 28.538f, 34.731f)
                curveTo(28.383f, 34.574f, 28.173f, 34.486f, 27.954f, 34.486f)
                close()
            }
        }.build()

        return _Property1BulbOn!!
    }

@Suppress("ObjectPropertyName")
private var _Property1BulbOn: ImageVector? = null
