package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Attachment: ImageVector
    get() {
        if (_Attachment != null) {
            return _Attachment!!
        }
        _Attachment = ImageVector.Builder(
            name = "Attachment",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF896CFE)),
                stroke = SolidColor(Color(0xFF896CFE)),
                strokeLineWidth = 2f
            ) {
                moveTo(20f, 20f)
                moveToRelative(-19f, 0f)
                arcToRelative(19f, 19f, 0f, isMoreThanHalf = true, isPositiveArc = true, 38f, 0f)
                arcToRelative(19f, 19f, 0f, isMoreThanHalf = true, isPositiveArc = true, -38f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(20f, 32f)
                curveTo(23.183f, 32f, 26.235f, 30.736f, 28.485f, 28.485f)
                curveTo(30.736f, 26.235f, 32f, 23.183f, 32f, 20f)
                curveTo(32f, 16.817f, 30.736f, 13.765f, 28.485f, 11.515f)
                curveTo(26.235f, 9.264f, 23.183f, 8f, 20f, 8f)
                curveTo(16.817f, 8f, 13.765f, 9.264f, 11.515f, 11.515f)
                curveTo(9.264f, 13.765f, 8f, 16.817f, 8f, 20f)
                curveTo(8f, 23.183f, 9.264f, 26.235f, 11.515f, 28.485f)
                curveTo(13.765f, 30.736f, 16.817f, 32f, 20f, 32f)
                close()
                moveTo(12.457f, 21.656f)
                lineTo(12.512f, 21.587f)
                lineTo(19.815f, 12.519f)
                curveTo(20.244f, 11.983f, 20.788f, 11.551f, 21.407f, 11.254f)
                curveTo(22.027f, 10.958f, 22.704f, 10.804f, 23.391f, 10.804f)
                curveTo(24.437f, 10.809f, 25.45f, 11.172f, 26.261f, 11.833f)
                curveTo(26.796f, 12.262f, 27.229f, 12.807f, 27.525f, 13.426f)
                curveTo(27.822f, 14.045f, 27.976f, 14.723f, 27.975f, 15.409f)
                curveTo(27.978f, 16.453f, 27.622f, 17.466f, 26.967f, 18.279f)
                curveTo(26.937f, 18.315f, 26.904f, 18.349f, 26.867f, 18.378f)
                curveTo(26.846f, 18.42f, 26.82f, 18.46f, 26.792f, 18.498f)
                lineTo(21.056f, 25.619f)
                curveTo(20.775f, 25.968f, 20.419f, 26.249f, 20.015f, 26.442f)
                curveTo(19.611f, 26.635f, 19.169f, 26.734f, 18.721f, 26.734f)
                curveTo(18.04f, 26.735f, 17.379f, 26.502f, 16.849f, 26.075f)
                curveTo(16.501f, 25.794f, 16.221f, 25.438f, 16.029f, 25.034f)
                curveTo(15.837f, 24.63f, 15.737f, 24.188f, 15.738f, 23.74f)
                curveTo(15.737f, 23.059f, 15.969f, 22.397f, 16.397f, 21.865f)
                lineTo(21.382f, 15.677f)
                curveTo(21.567f, 15.445f, 21.803f, 15.259f, 22.071f, 15.131f)
                curveTo(22.338f, 15.004f, 22.631f, 14.938f, 22.928f, 14.939f)
                curveTo(23.38f, 14.936f, 23.818f, 15.09f, 24.169f, 15.375f)
                curveTo(24.399f, 15.561f, 24.585f, 15.797f, 24.712f, 16.065f)
                curveTo(24.84f, 16.332f, 24.906f, 16.625f, 24.906f, 16.921f)
                curveTo(24.906f, 17.373f, 24.751f, 17.811f, 24.467f, 18.162f)
                lineTo(21.344f, 22.043f)
                curveTo(21.23f, 22.185f, 21.064f, 22.275f, 20.883f, 22.294f)
                curveTo(20.703f, 22.313f, 20.522f, 22.26f, 20.381f, 22.146f)
                curveTo(20.239f, 22.033f, 20.148f, 21.867f, 20.128f, 21.687f)
                curveTo(20.108f, 21.506f, 20.161f, 21.325f, 20.274f, 21.183f)
                lineTo(23.401f, 17.302f)
                curveTo(23.488f, 17.194f, 23.535f, 17.059f, 23.535f, 16.921f)
                curveTo(23.535f, 16.83f, 23.515f, 16.74f, 23.476f, 16.657f)
                curveTo(23.437f, 16.574f, 23.38f, 16.502f, 23.309f, 16.444f)
                curveTo(23.201f, 16.356f, 23.067f, 16.309f, 22.928f, 16.311f)
                curveTo(22.836f, 16.309f, 22.745f, 16.329f, 22.662f, 16.368f)
                curveTo(22.579f, 16.408f, 22.505f, 16.465f, 22.448f, 16.537f)
                lineTo(19.325f, 20.418f)
                lineTo(17.463f, 22.726f)
                curveTo(17.234f, 23.019f, 17.113f, 23.382f, 17.12f, 23.754f)
                curveTo(17.119f, 23.997f, 17.173f, 24.236f, 17.276f, 24.455f)
                curveTo(17.38f, 24.674f, 17.532f, 24.867f, 17.72f, 25.019f)
                curveTo(18.013f, 25.249f, 18.376f, 25.371f, 18.749f, 25.362f)
                curveTo(18.991f, 25.364f, 19.231f, 25.31f, 19.45f, 25.206f)
                curveTo(19.669f, 25.101f, 19.862f, 24.948f, 20.014f, 24.759f)
                lineTo(25.75f, 17.638f)
                curveTo(25.779f, 17.601f, 25.813f, 17.568f, 25.849f, 17.538f)
                curveTo(25.871f, 17.496f, 25.896f, 17.456f, 25.925f, 17.418f)
                curveTo(26.384f, 16.85f, 26.633f, 16.14f, 26.631f, 15.409f)
                curveTo(26.633f, 14.928f, 26.527f, 14.453f, 26.32f, 14.018f)
                curveTo(26.114f, 13.584f, 25.812f, 13.202f, 25.438f, 12.899f)
                curveTo(24.868f, 12.443f, 24.159f, 12.194f, 23.429f, 12.193f)
                curveTo(22.948f, 12.193f, 22.472f, 12.3f, 22.038f, 12.507f)
                curveTo(21.604f, 12.714f, 21.222f, 13.016f, 20.919f, 13.39f)
                lineTo(13.616f, 22.458f)
                curveTo(13.159f, 23.028f, 12.91f, 23.737f, 12.91f, 24.467f)
                curveTo(12.909f, 24.948f, 13.017f, 25.423f, 13.224f, 25.856f)
                curveTo(13.431f, 26.29f, 13.732f, 26.672f, 14.106f, 26.974f)
                curveTo(14.177f, 27.03f, 14.235f, 27.1f, 14.279f, 27.18f)
                curveTo(14.322f, 27.259f, 14.349f, 27.346f, 14.359f, 27.436f)
                curveTo(14.368f, 27.526f, 14.36f, 27.616f, 14.334f, 27.703f)
                curveTo(14.309f, 27.79f, 14.266f, 27.87f, 14.209f, 27.941f)
                curveTo(14.095f, 28.082f, 13.929f, 28.172f, 13.749f, 28.191f)
                curveTo(13.568f, 28.211f, 13.387f, 28.157f, 13.246f, 28.043f)
                curveTo(12.71f, 27.614f, 12.279f, 27.069f, 11.982f, 26.45f)
                curveTo(11.685f, 25.831f, 11.531f, 25.154f, 11.531f, 24.467f)
                curveTo(11.532f, 23.478f, 11.854f, 22.515f, 12.45f, 21.725f)
                curveTo(12.441f, 21.703f, 12.435f, 21.68f, 12.433f, 21.656f)
                horizontalLineTo(12.457f)
                close()
            }
        }.build()

        return _Attachment!!
    }

@Suppress("ObjectPropertyName")
private var _Attachment: ImageVector? = null
