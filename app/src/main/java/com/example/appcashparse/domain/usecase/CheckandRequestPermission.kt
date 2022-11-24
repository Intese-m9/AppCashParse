package com.example.appcashparse.domain.usecase

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CheckandRequestPermission {
    fun execute(context: Context): Boolean{
        val storageread =
            ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
        val listpermissionNeeded: MutableList<String> = ArrayList()
        if (storageread != PackageManager.PERMISSION_GRANTED) {
            listpermissionNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (!listpermissionNeeded.isEmpty()) {
            val REQUEST_ID_MULTIPLE_PERMISSIONS = 0
            ActivityCompat.requestPermissions(
                context as Activity,
                listpermissionNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
            return false
        }
        return true
    }
}