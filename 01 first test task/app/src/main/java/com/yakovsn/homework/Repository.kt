package com.yakovsn.homework

import com.google.gson.Gson
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister

class Repository(private var kiparoCom: GetFromNetwork) {

    fun getNewsJson(): AllNews? = convertJson(kiparoCom.getJson())
    fun getNewsXML(): AllNews? = convertXML(kiparoCom.getXML())

    private fun convertJson(json: String?): AllNews? {
        return try {
            val gsonAdapter = Gson().getAdapter(AllNews::class.java)
            gsonAdapter.fromJson(json)
        } catch (t: Throwable) {
            //no UI interaction here, just throw 
            println("ошибка данных")
            null
        }
    }

    private fun convertXML(xml: String?): AllNews? {
        return try {
            val serializer: Serializer = Persister()
            serializer.read(AllNews::class.java, xml)
        } catch (t: Throwable) {
            //no UI interaction here, just throw 
            println("ошибка данных")
            null
        }
    }


}


