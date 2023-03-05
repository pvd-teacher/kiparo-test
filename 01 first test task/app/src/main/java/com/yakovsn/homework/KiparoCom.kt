package com.yakovsn.homework

import java.net.HttpURLConnection
import java.net.URL

class KiparoCom : GetFromNetwork {

    override fun getJson(): String? {
        val url = URL("https://api2.kiparo.com/static/it_news.json")
        val urlConnection = url.openConnection() as HttpURLConnection
        return try {
            urlConnection.inputStream.bufferedReader().readText()
        } catch (t: Throwable) {
            println("соединение отстутсвует")
            null
        }
    }

    override fun getXML(): String? {
        val url2 = URL("https://api2.kiparo.com/static/it_news.xml")
        val urlConnection2 = url2.openConnection() as HttpURLConnection
        return try {
            urlConnection2.inputStream.bufferedReader().readText()
        } catch (t: Throwable) {
            println("соединение отстутсвует")
            null
        }
    }
}