package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.Bell: ImageVector
    get() {
        if (_Bell != null) {
            return _Bell!!
        }
        _Bell = ImageVector.Builder(
            name = "Bell",
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
                moveTo(9.373f, 27.574f)
                curveTo(9.65f, 27.958f, 10.05f, 28.243f, 10.512f, 28.384f)
                curveTo(11.85f, 28.768f, 13.221f, 29.032f, 14.609f, 29.173f)
                curveTo(16.395f, 29.369f, 18.19f, 29.465f, 19.987f, 29.461f)
                curveTo(21.785f, 29.466f, 23.582f, 29.369f, 25.369f, 29.173f)
                curveTo(26.757f, 29.032f, 28.128f, 28.768f, 29.465f, 28.384f)
                curveTo(29.927f, 28.243f, 30.328f, 27.958f, 30.605f, 27.574f)
                curveTo(30.864f, 27.211f, 31.002f, 26.78f, 31f, 26.339f)
                curveTo(31f, 26.049f, 30.939f, 25.763f, 30.822f, 25.496f)
                curveTo(30.705f, 25.23f, 30.534f, 24.989f, 30.318f, 24.787f)
                curveTo(29.61f, 24.095f, 29.097f, 23.238f, 28.829f, 22.299f)
                curveTo(28.58f, 21.493f, 28.455f, 20.656f, 28.456f, 19.815f)
                curveTo(28.456f, 19.455f, 28.475f, 19.171f, 28.493f, 18.937f)
                curveTo(28.523f, 18.623f, 28.546f, 18.303f, 28.546f, 17.975f)
                curveTo(28.548f, 17.628f, 28.52f, 17.281f, 28.464f, 16.938f)
                curveTo(28.139f, 15.01f, 27.118f, 13.256f, 25.581f, 11.988f)
                curveTo(24.626f, 11.192f, 23.5f, 10.611f, 22.285f, 10.288f)
                curveTo(22.625f, 9.829f, 22.807f, 9.279f, 22.806f, 8.715f)
                curveTo(22.806f, 7.995f, 22.511f, 7.304f, 21.984f, 6.795f)
                curveTo(21.457f, 6.286f, 20.743f, 6f, 19.998f, 6f)
                curveTo(19.254f, 6.001f, 18.541f, 6.287f, 18.015f, 6.796f)
                curveTo(17.489f, 7.306f, 17.194f, 7.995f, 17.194f, 8.715f)
                curveTo(17.193f, 9.279f, 17.375f, 9.829f, 17.715f, 10.288f)
                curveTo(16.5f, 10.611f, 15.374f, 11.192f, 14.419f, 11.988f)
                curveTo(12.883f, 13.256f, 11.861f, 15.01f, 11.536f, 16.938f)
                curveTo(11.48f, 17.281f, 11.453f, 17.628f, 11.455f, 17.975f)
                curveTo(11.455f, 18.303f, 11.477f, 18.623f, 11.507f, 18.937f)
                curveTo(11.507f, 19.171f, 11.544f, 19.469f, 11.544f, 19.815f)
                curveTo(11.55f, 20.655f, 11.431f, 21.492f, 11.19f, 22.299f)
                curveTo(10.916f, 23.24f, 10.397f, 24.097f, 9.682f, 24.787f)
                curveTo(9.466f, 24.989f, 9.295f, 25.23f, 9.178f, 25.496f)
                curveTo(9.061f, 25.763f, 9.001f, 26.049f, 9f, 26.339f)
                curveTo(8.992f, 26.778f, 9.122f, 27.209f, 9.373f, 27.574f)
                close()
                moveTo(19.056f, 9.618f)
                curveTo(18.813f, 9.377f, 18.679f, 9.052f, 18.684f, 8.715f)
                curveTo(18.68f, 8.379f, 18.814f, 8.055f, 19.056f, 7.815f)
                curveTo(19.305f, 7.581f, 19.64f, 7.451f, 19.987f, 7.455f)
                curveTo(20.336f, 7.45f, 20.672f, 7.58f, 20.922f, 7.815f)
                curveTo(21.164f, 8.055f, 21.298f, 8.379f, 21.294f, 8.715f)
                curveTo(21.299f, 9.052f, 21.165f, 9.377f, 20.922f, 9.618f)
                curveTo(20.672f, 9.853f, 20.336f, 9.983f, 19.987f, 9.979f)
                curveTo(19.813f, 9.982f, 19.64f, 9.952f, 19.479f, 9.89f)
                curveTo(19.317f, 9.828f, 19.169f, 9.736f, 19.045f, 9.618f)
                lineTo(19.056f, 9.618f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(21.458f, 30.073f)
                curveTo(21.361f, 30.061f, 21.263f, 30.068f, 21.168f, 30.094f)
                curveTo(21.074f, 30.119f, 20.986f, 30.162f, 20.909f, 30.22f)
                curveTo(20.832f, 30.278f, 20.767f, 30.35f, 20.719f, 30.433f)
                curveTo(20.671f, 30.515f, 20.64f, 30.605f, 20.628f, 30.699f)
                curveTo(20.598f, 30.935f, 20.48f, 31.153f, 20.296f, 31.311f)
                curveTo(20.11f, 31.472f, 19.868f, 31.561f, 19.618f, 31.56f)
                curveTo(19.371f, 31.56f, 19.133f, 31.473f, 18.948f, 31.315f)
                curveTo(18.763f, 31.158f, 18.644f, 30.942f, 18.613f, 30.706f)
                curveTo(18.587f, 30.518f, 18.484f, 30.346f, 18.328f, 30.23f)
                curveTo(18.172f, 30.114f, 17.974f, 30.063f, 17.778f, 30.087f)
                curveTo(17.681f, 30.099f, 17.588f, 30.13f, 17.503f, 30.177f)
                curveTo(17.418f, 30.224f, 17.343f, 30.286f, 17.283f, 30.361f)
                curveTo(17.223f, 30.436f, 17.18f, 30.522f, 17.154f, 30.613f)
                curveTo(17.128f, 30.705f, 17.122f, 30.8f, 17.134f, 30.894f)
                curveTo(17.213f, 31.473f, 17.507f, 32.006f, 17.961f, 32.391f)
                curveTo(18.417f, 32.784f, 19.007f, 33f, 19.618f, 33f)
                curveTo(20.234f, 32.999f, 20.827f, 32.78f, 21.287f, 32.384f)
                curveTo(21.741f, 31.994f, 22.033f, 31.456f, 22.106f, 30.872f)
                curveTo(22.129f, 30.683f, 22.074f, 30.493f, 21.953f, 30.343f)
                curveTo(21.831f, 30.194f, 21.653f, 30.096f, 21.458f, 30.073f)
                close()
            }
        }.build()

        return _Bell!!
    }

@Suppress("ObjectPropertyName")
private var _Bell: ImageVector? = null
