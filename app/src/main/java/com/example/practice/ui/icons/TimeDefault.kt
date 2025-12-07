package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ValkyrieIcons.TimeDefault: ImageVector
    get() {
        if (_TimeDefault != null) {
            return _TimeDefault!!
        }
        _TimeDefault = ImageVector.Builder(
            name = "TimeDefault",
            defaultWidth = 55.dp,
            defaultHeight = 55.dp,
            viewportWidth = 55f,
            viewportHeight = 55f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(27.5f, 55f)
                curveTo(34.793f, 54.998f, 41.786f, 52.099f, 46.943f, 46.942f)
                curveTo(52.1f, 41.784f, 54.998f, 34.79f, 55f, 27.496f)
                curveTo(54.998f, 20.203f, 52.099f, 13.209f, 46.942f, 8.053f)
                curveTo(41.785f, 2.897f, 34.792f, -0f, 27.5f, 0f)
                curveTo(20.208f, -0f, 13.215f, 2.897f, 8.057f, 8.053f)
                curveTo(2.901f, 13.209f, 0.002f, 20.203f, 0f, 27.496f)
                curveTo(0.002f, 34.79f, 2.9f, 41.784f, 8.057f, 46.942f)
                curveTo(13.214f, 52.099f, 20.207f, 54.998f, 27.5f, 55f)
                close()
                moveTo(15.585f, 34.551f)
                lineTo(25.752f, 26.683f)
                verticalLineTo(15.623f)
                curveTo(25.752f, 15.159f, 25.936f, 14.715f, 26.264f, 14.387f)
                curveTo(26.592f, 14.059f, 27.036f, 13.875f, 27.5f, 13.875f)
                curveTo(27.964f, 13.875f, 28.408f, 14.059f, 28.736f, 14.387f)
                curveTo(29.064f, 14.715f, 29.248f, 15.159f, 29.248f, 15.623f)
                verticalLineTo(27.539f)
                curveTo(29.248f, 27.539f, 29.248f, 27.609f, 29.248f, 27.644f)
                curveTo(29.248f, 27.679f, 29.248f, 27.767f, 29.248f, 27.828f)
                curveTo(29.238f, 27.881f, 29.223f, 27.934f, 29.205f, 27.985f)
                curveTo(29.209f, 28.04f, 29.209f, 28.096f, 29.205f, 28.151f)
                lineTo(29.135f, 28.309f)
                lineTo(29.056f, 28.457f)
                lineTo(28.96f, 28.597f)
                curveTo(28.927f, 28.642f, 28.889f, 28.683f, 28.846f, 28.72f)
                curveTo(28.807f, 28.768f, 28.763f, 28.811f, 28.715f, 28.851f)
                lineTo(28.645f, 28.921f)
                lineTo(17.797f, 37.357f)
                curveTo(17.432f, 37.64f, 16.969f, 37.767f, 16.51f, 37.71f)
                curveTo(16.052f, 37.652f, 15.634f, 37.416f, 15.349f, 37.051f)
                curveTo(15.197f, 36.873f, 15.083f, 36.666f, 15.012f, 36.443f)
                curveTo(14.941f, 36.22f, 14.916f, 35.984f, 14.938f, 35.751f)
                curveTo(14.96f, 35.518f, 15.029f, 35.292f, 15.14f, 35.085f)
                curveTo(15.251f, 34.879f, 15.403f, 34.697f, 15.585f, 34.551f)
                close()
            }
        }.build()

        return _TimeDefault!!
    }

@Suppress("ObjectPropertyName")
private var _TimeDefault: ImageVector? = null
