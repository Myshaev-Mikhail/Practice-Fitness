package com.example.practice.ui.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.compose.ui.geometry.Offset
import kotlin.math.roundToInt

fun cropAndSaveAvatar(
    context: Context,
    uriString: String,
    scale: Float,
    offset: Offset,
    cropSizeDp: Float
): String {
    val resolver = context.contentResolver
    val uri = Uri.parse(uriString)

    val bitmap = if (Build.VERSION.SDK_INT >= 28) {
        ImageDecoder.decodeBitmap(ImageDecoder.createSource(resolver, uri))
    } else {
        MediaStore.Images.Media.getBitmap(resolver, uri)
    }

    val density = context.resources.displayMetrics.density
    val cropSizePx = cropSizeDp * density

    val displayBitmapSize = cropSizePx * scale

    val bitmapOffsetX = offset.x * (bitmap.width / displayBitmapSize)
    val bitmapOffsetY = offset.y * (bitmap.height / displayBitmapSize)

    val centerX = bitmap.width / 2f - bitmapOffsetX
    val centerY = bitmap.height / 2f - bitmapOffsetY

    val cropBitmapSize = (cropSizePx * (bitmap.width / displayBitmapSize)).roundToInt()

    val left = (centerX - cropBitmapSize / 2f).coerceIn(0f, (bitmap.width - cropBitmapSize).toFloat()).roundToInt()
    val top = (centerY - cropBitmapSize / 2f).coerceIn(0f, (bitmap.height - cropBitmapSize).toFloat()).roundToInt()

    val cropped = Bitmap.createBitmap(bitmap, left, top, cropBitmapSize, cropBitmapSize)

    val file = context.getFileStreamPath("avatar.jpg").apply {
        if (!exists()) createNewFile()
    }

    file.outputStream().use { cropped.compress(Bitmap.CompressFormat.JPEG, 90, it) }

    return file.absolutePath
}