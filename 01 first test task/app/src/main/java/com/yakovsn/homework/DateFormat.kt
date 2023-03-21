package com.yakovsn.homework

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//Singletone too much, it could be simply kotlin file with util functions
object DateFormat {
    @RequiresApi(Build.VERSION_CODES.O)
    fun dateForm(dateString: String?): String {
        //private const DATE_FORMAT_...
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss [.SSS]Z")
        val date = LocalDateTime.parse(dateString, formatter)
        //private const DATE_FORMAT_...
        val newFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        return date.format(newFormatter)
    }
}
