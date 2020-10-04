package com.haytham.coder.extensions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment
import java.util.ArrayList

const val GET_IMAGE_REQUEST = 0
const val GET_MULTI_IMAGES_REQUEST = 1
const val DEFAULT_SELECT_IMAGE_CHOOSER_TITLE= "Select Image"

fun Activity.openImagePickerApp(
    multiSelect: Boolean= false,
    neededForLaterUsage: Boolean= false,
    chooserTitle:String= DEFAULT_SELECT_IMAGE_CHOOSER_TITLE
) {

    val intent = getImageIntent(
        multiSelect,
        neededForLaterUsage
    )
    startActivityForResult(
        Intent.createChooser(intent, chooserTitle),
        if (multiSelect) GET_MULTI_IMAGES_REQUEST else GET_IMAGE_REQUEST
    )
}

fun Fragment.openImagePickerApp(
    multiSelect: Boolean= false,
    neededForLaterUsage: Boolean= false,
    chooserTitle:String= DEFAULT_SELECT_IMAGE_CHOOSER_TITLE
) {
    val intent = getImageIntent(
        multiSelect,
        neededForLaterUsage
    )

    startActivityForResult(
        Intent.createChooser(intent, chooserTitle),
        if (multiSelect) GET_MULTI_IMAGES_REQUEST else GET_IMAGE_REQUEST
    )
}

private fun getImageIntent(
    multiSelect: Boolean,
    neededForLaterUsage: Boolean
): Intent {
    val intent = Intent()
    intent.type = "image/*"
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, multiSelect)
    intent.action =
        if (neededForLaterUsage) Intent.ACTION_OPEN_DOCUMENT else Intent.ACTION_GET_CONTENT
    return intent
}

fun Intent.getImage(): Uri {
    return getImages()[0]
}

// NOTE: there is no reliable way to convert Uri into real Path
fun Intent.getImages(): List<Uri> {
    val images: MutableList<Uri> = ArrayList()

    val imageClipData=  clipData
    val imageData= data

    if (imageClipData != null) {
        //evaluate the count before the for loop --- otherwise, the count is evaluated every loop.
        val count = imageClipData.itemCount
        for (i in 0 until count) {
            val imageUri = imageClipData.getItemAt(i).uri
            images.add(imageUri)
        }
    } else if (imageData != null) {
        images.add(imageData)
    }
    return images
}