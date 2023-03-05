package com.yakovsn.homework

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.*

@RequiresApi(Build.VERSION_CODES.O)
suspend fun main() {

    val kiparoCom by lazy { KiparoCom() }
    var myNews: AllNews? = null
    var search = true

    println("Выберете тип файла для скачки: 1 - Json или 2 - XML")

    var result = readLine()?.toIntOrNull() ?: 0
    while (result != 1 && result != 2) {
        println("Введено неверное значенние, выберете 1 или 2")
        result = readLine()?.toIntOrNull() ?: 0
    }

    println("Вы выбрали ${if (result == 1) "Json" else "XML"} ")

    coroutineScope {
        val job = launch(Dispatchers.IO) {
            myNews = if (result == 1) {
                Repository(kiparoCom).getNewsJson()
            } else {
                Repository(kiparoCom).getNewsXML()
            }
        }

        launch {
            println("Устанавливаю соединение, пробую обработать данные")
            var dot = 1
            while (job.isActive) {
                if (dot % 100 == 0) println(".")
                else print(".")
                delay(50)
                dot++
            }
        }
    }

    if (myNews == null) return
    else println("\nДанные загружены и успешно обработаны")

    printCommandList()
    while (search) {
        println("\n'c' (анг раскладка)  - полный список команд, 'x' - завершить программу")
        println("\nВыберите команду:")
        when (readLine()) {
            "1" -> myNews?.printInfo()
            "2" -> myNews?.searchByKeyword()
            "3" -> myNews?.searchById()
            "4" -> myNews?.searchByTitle()
            "c" -> printCommandList()
            "x" -> search = false
            else -> println("неверная команда")
        }
    }
}


fun printCommandList() {
    println(
        message = """Список команд:
        '1' - вывести все новости сортированные по дате
        '2' - выбрать новости по keyword
        '3' - выбрать новости по id
        '4' - выбрать новости по title        
            """.trimMargin()
    )
}









