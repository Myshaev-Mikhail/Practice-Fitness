package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Settings: ImageVector
    get() {
        if (_Settings != null) {
            return _Settings!!
        }
        _Settings = ImageVector.Builder(
            name = "Settings",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(fill = SolidColor(Color(0xFF896CFE))) {
                moveTo(20f, 20f)
                moveToRelative(-20f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, 40f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, -40f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(7.098f, 24.573f)
                lineTo(9.856f, 29.393f)
                curveTo(9.951f, 29.557f, 10.105f, 29.677f, 10.287f, 29.726f)
                curveTo(10.468f, 29.775f, 10.662f, 29.75f, 10.825f, 29.656f)
                lineTo(14.449f, 27.569f)
                curveTo(15.226f, 28.2f, 16.097f, 28.704f, 17.029f, 29.063f)
                verticalLineTo(33.282f)
                curveTo(17.029f, 33.472f, 17.104f, 33.654f, 17.236f, 33.788f)
                curveTo(17.369f, 33.923f, 17.549f, 33.999f, 17.737f, 34f)
                horizontalLineTo(23.262f)
                curveTo(23.356f, 34f, 23.448f, 33.981f, 23.534f, 33.945f)
                curveTo(23.621f, 33.909f, 23.699f, 33.856f, 23.765f, 33.79f)
                curveTo(23.83f, 33.723f, 23.883f, 33.644f, 23.918f, 33.556f)
                curveTo(23.953f, 33.47f, 23.971f, 33.376f, 23.971f, 33.282f)
                verticalLineTo(29.063f)
                curveTo(24.903f, 28.704f, 25.773f, 28.2f, 26.551f, 27.569f)
                lineTo(30.175f, 29.656f)
                curveTo(30.338f, 29.75f, 30.531f, 29.775f, 30.713f, 29.726f)
                curveTo(30.895f, 29.677f, 31.049f, 29.557f, 31.144f, 29.393f)
                lineTo(33.906f, 24.573f)
                curveTo(34f, 24.409f, 34.024f, 24.214f, 33.975f, 24.031f)
                curveTo(33.927f, 23.848f, 33.808f, 23.692f, 33.646f, 23.597f)
                lineTo(30.017f, 21.486f)
                curveTo(30.097f, 20.99f, 30.138f, 20.489f, 30.142f, 19.987f)
                curveTo(30.138f, 19.487f, 30.097f, 18.988f, 30.017f, 18.493f)
                lineTo(33.646f, 16.382f)
                curveTo(33.808f, 16.287f, 33.927f, 16.131f, 33.975f, 15.948f)
                curveTo(34.024f, 15.765f, 34f, 15.57f, 33.906f, 15.406f)
                lineTo(31.144f, 10.586f)
                curveTo(31.049f, 10.422f, 30.895f, 10.303f, 30.713f, 10.253f)
                curveTo(30.531f, 10.204f, 30.338f, 10.229f, 30.175f, 10.323f)
                lineTo(26.551f, 12.43f)
                curveTo(25.772f, 11.8f, 24.902f, 11.295f, 23.971f, 10.932f)
                verticalLineTo(6.714f)
                curveTo(23.971f, 6.524f, 23.896f, 6.343f, 23.763f, 6.209f)
                curveTo(23.63f, 6.075f, 23.45f, 6f, 23.262f, 6f)
                horizontalLineTo(17.737f)
                curveTo(17.55f, 6.001f, 17.371f, 6.077f, 17.238f, 6.21f)
                curveTo(17.105f, 6.344f, 17.03f, 6.525f, 17.029f, 6.714f)
                verticalLineTo(10.932f)
                curveTo(16.098f, 11.295f, 15.227f, 11.8f, 14.449f, 12.43f)
                lineTo(10.825f, 10.323f)
                curveTo(10.662f, 10.229f, 10.468f, 10.204f, 10.287f, 10.253f)
                curveTo(10.105f, 10.303f, 9.951f, 10.422f, 9.856f, 10.586f)
                lineTo(7.098f, 15.406f)
                curveTo(7.051f, 15.487f, 7.02f, 15.576f, 7.008f, 15.669f)
                curveTo(6.995f, 15.762f, 7.001f, 15.857f, 7.025f, 15.948f)
                curveTo(7.049f, 16.038f, 7.09f, 16.123f, 7.147f, 16.198f)
                curveTo(7.203f, 16.272f, 7.274f, 16.335f, 7.355f, 16.382f)
                lineTo(10.987f, 18.493f)
                curveTo(10.904f, 18.987f, 10.861f, 19.487f, 10.858f, 19.987f)
                curveTo(10.861f, 20.49f, 10.904f, 20.99f, 10.987f, 21.486f)
                lineTo(7.355f, 23.597f)
                curveTo(7.274f, 23.644f, 7.203f, 23.706f, 7.146f, 23.781f)
                curveTo(7.089f, 23.855f, 7.047f, 23.94f, 7.024f, 24.031f)
                curveTo(7f, 24.122f, 6.994f, 24.217f, 7.007f, 24.31f)
                curveTo(7.019f, 24.403f, 7.05f, 24.493f, 7.098f, 24.573f)
                close()
                moveTo(20.5f, 17.021f)
                curveTo(20.885f, 17.021f, 21.266f, 17.098f, 21.621f, 17.247f)
                curveTo(21.976f, 17.396f, 22.299f, 17.614f, 22.571f, 17.889f)
                curveTo(22.844f, 18.162f, 23.061f, 18.487f, 23.21f, 18.845f)
                curveTo(23.358f, 19.203f, 23.435f, 19.587f, 23.436f, 19.975f)
                curveTo(23.432f, 20.758f, 23.121f, 21.508f, 22.571f, 22.061f)
                curveTo(22.299f, 22.336f, 21.976f, 22.554f, 21.621f, 22.703f)
                curveTo(21.266f, 22.852f, 20.885f, 22.929f, 20.5f, 22.929f)
                curveTo(20.115f, 22.929f, 19.734f, 22.852f, 19.379f, 22.703f)
                curveTo(19.024f, 22.554f, 18.701f, 22.336f, 18.429f, 22.061f)
                curveTo(17.879f, 21.508f, 17.568f, 20.758f, 17.564f, 19.975f)
                curveTo(17.565f, 19.587f, 17.642f, 19.203f, 17.79f, 18.845f)
                curveTo(17.939f, 18.487f, 18.156f, 18.162f, 18.429f, 17.889f)
                curveTo(18.979f, 17.337f, 19.724f, 17.028f, 20.5f, 17.029f)
                verticalLineTo(17.021f)
                close()
            }
        }.build()

        return _Settings!!
    }

@Suppress("ObjectPropertyName")
private var _Settings: ImageVector? = null
