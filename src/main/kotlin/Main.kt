fun main() {
    val revenueByWeek = listOf( // доход за неделю, содержит списки с доходами за день
        listOf(8, 6, 5, 1, 2),
        listOf(9, 6, 9, 1, 9),
        listOf(2, 6, 5, 3, 2),
        listOf(7, 6, 3, 1, 2)
    )
    // хотим получить среднюю выручку за день
    val total = mutableListOf<Int>()
    revenueByWeek.map {
        for (i in it) total.add(i)
    }
    val average = total.average()
    println(average)

    // а теперь способ сделать это в одну строчку, еще и получив при этом неизменяемую коллекцию
    val total2 = revenueByWeek.flatMap { it } // так как мы ничего не делаем можно вызвать аналогичный метод flatten()
    val average2 = total2.average()
    println(average2)

    val data = mutableMapOf<String, List<Int>>()
    data.put("file1", listOf(1, 2, 3, 4))
    data.put("file2", listOf(5, 6, 7, 8))
    data["file3"] = listOf(1, 2, 3, 4) // альтернативный способ вставки данных в map

    // не очень хорошим тоном является использование изменяемых типов данных без надобности, поэтому альтернатива:
    val dataMap = mapOf(
        "file1" to listOf(1, 2, 3, -100), // данные записались неправильно и появилось отрицательное значение
        "file2" to listOf(5, 6, 7, 8),
        "file3" to listOf(1, 2, 3, 4),
        Pair("file4", listOf(5, 4, 3, 2)) // еще альтернатива добавления элемента в map
    )

    val averageData = dataMap.filter { it.value.all { it >= 0 } }.flatMap { it.value }.average()
    println(averageData)

    // итого: flatMap разворачивает все коллекции и на выходе получатеся одна коллекция
}