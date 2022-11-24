package com.example.appcashparse.data.repository

import com.example.appcashparse.domain.models.FileCash
import java.io.File
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

class Repository {
        fun getViberList(): List<FileCash> {
        val files = File("/storage/emulated/0/Android/data/com.viber.voip/cache/ImageFetcherThumb/").listFiles()
            var filesCount = files.size
            val viberList = ArrayList<FileCash>()
            val df = DecimalFormat("#.##")
            for (i in 0 until filesCount){
                val fileItem = FileCash(files[i].name,files[i].name.substringAfterLast('.', ""), df.format((files[i].length()!! * 0.000977)))
                viberList.add(fileItem)
            }

            return viberList
    }
    fun getTelegramList(): List<FileCash> {
        val files = File("/storage/emulated/0/Android/data/org.thunderdog.challegram/files/photos/").listFiles()
        var filesCount = files.size
        val telegramList = ArrayList<FileCash>()
        val df = DecimalFormat("#.##")
        for (i in 0 until filesCount){
            val fileItem = FileCash(files[i].name,files[i].name.substringAfterLast('.', ""), df.format((files[i].length()!! * 0.000977)))
            telegramList.add(fileItem)
        }

        return telegramList
    }

}