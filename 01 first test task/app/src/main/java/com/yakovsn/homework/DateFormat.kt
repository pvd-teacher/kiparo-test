package com.yakovsn.homework

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateFormat {
    @RequiresApi(Build.VERSION_CODES.O)
    fun dateForm(dateString: String?): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss [.SSS]Z")
        val date = LocalDateTime.parse(dateString, formatter)
        val newFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        return date.format(newFormatter)
    }
}