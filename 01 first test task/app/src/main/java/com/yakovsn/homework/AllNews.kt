package com.yakovsn.homework

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false)
//How many purposes does this class have?
// Looks like we may have several classed from this one
// And this could be achieved in several ways, separate usecases each with single purpose
// delegates with single purpose, search interfaces
class AllNews {
    @field:Element(name = "location", required = false)
    @SerializedName("location")
    var location: String? = null

    @field:Element(name = "name", required = false)
    @SerializedName("name")
    var name: String? = null

    @field:ElementList(name = "news", required = false)
    @SerializedName("news")
    lateinit var news: List<News>


    @RequiresApi(Build.VERSION_CODES.O)
    fun printInfo() {
        println("$location. $name.")
        news.sortedBy { it.date }
            .forEach { println("${DateFormat.dateForm(it.date)} : ${it.description}") }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun searchByKeyword() {
        val allKeywords = mutableListOf<String>()
        news.forEach { for (i in it.keywords) allKeywords.add(i) }
        allKeywords.toSet().forEach { print("$it   ") }
//  and No UI interactions should be here
        println("\nВведите ключевое слово для поиска:")
        val keywords = readLine().toString()

        news.forEach {
            for (i in it.keywords) {
                if (i.contains(keywords)) {
                    println("$i : ${it.description}")
                }
            }
        }
    }

    fun searchById() {
        val allId = mutableListOf<String>()
        news.forEach { allId.add(it.id.toString()) }
        allId.toSet().forEach { print("$it   ") }
//  and No UI interactions should be here
        println("\nВыберете id:")
        val id = readLine()?.toIntOrNull() ?: 10000
        news.forEach { if (it.id == id) println("$id : ${it.description}") }
    }

    fun searchByTitle() {
        val allTitles = mutableListOf<String?>()
        news.forEach { allTitles.add(it.title) }
        println("Список всех заголовков:")
        allTitles.toSet().forEach { println(it) }
//  and No UI interactions should be here
        println("\nВведите заголовок для поиска (или слово из него):")
        var title = readLine().toString()
        if (title == "" || title == " ") title = "**********"

        news.forEach {
            if (it.title.toString().contains(title)) println("${it.title} : ${it.description}")
        }
    }

}








