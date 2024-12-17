package org.example.kotlinlern.lesson8

fun main() {
//    println(convertText("Удача"))
//    findDate("Пользователь вошел в систему -> 2021-12-01 09:48:23")
//    cardMask("4539 1488 0343 6467")
//    formatEmail("username@example.com")
//    fileName("C:/Пользователи/Документы/report.txt")
//    firstLetter("Объектно-ориентированное программирование")
//    multiply()
//    multi2(80, 80)
//    convertString("Объектно ориентированное программирование")
//    encrypt("Kotlin")
//    decrypt("oKltni")
}

/*
Создайте функцию, которая будет анализировать входящие фразы и
применять к ним различные преобразования,
делая текст более ироничным или забавным.
Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
Правила Проверки и Преобразования:
1 Если фраза содержит слово "невозможно":
Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
2 Если фраза начинается с "Я не уверен":
Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".
3 Если фраза содержит слово "катастрофа":
Преобразование: Замените "катастрофа" на "интересное событие".
4 Если фраза заканчивается на "без проблем":
Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
5 Если фраза содержит только одно слово:
Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".
 */

fun convertText(str: String): String {
    val words = str.split(" ")
    return when {
        str.contains("невозможно", true) -> str.replace(
            "невозможно",
            "совершенно точно возможно, просто требует времени"
        )

        str.startsWith("Я не уверен", true) -> "$str, но моя интуиция говорит об обратном"
        str.contains("катастрофа") -> str.replace("катастрофа", "интересное событие")
        str.endsWith("без проблем", true) -> str.replace("без проблем", "с парой интересных вызовов на пути")
        words.size == 1 -> "Иногда, ${str.lowercase()}, но не всегда"
        else -> "ошибка"
    }
}

/*
Задание 1: Извлечение Даты из Строки Лога.
Используй indexOf или split для получения правой части сообщения.
Описание: У вас есть строка лога вида
"Пользователь вошел в систему -> 2021-12-01 09:48:23".
Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди.
 */

fun findDate(str: String) {
    val indexDateAndTime = str.indexOf(">") + 2
    val date = str.substring(indexDateAndTime, indexDateAndTime + 10)
    val time = str.substring(indexDateAndTime + 12)
    println("$date, $time")
}

/*
Задание 2: Маскирование Личных Данных
Описание: Дана строка с номером кредитной карты "4539 1488 0343 6467".
Замаскируйте все цифры, кроме последних четырех, символами "*".
*/
fun cardMask(cardNumb: String) {
    println("**** **** **** ${cardNumb.substring(15)}")
}

/*
Задание 3: Форматирование Адреса Электронной Почты. Используй replace
Описание: У вас есть электронный адрес "username@example.com". Преобразуйте его в строку "username [at] example [dot] com".
 */
fun formatEmail(email: String) {
    val result = email.replace("@", " [at] ").replace(".", " [dot] ")
    println(result)
}

/*
Задание 4: Извлечение Имени Файла из Пути
Описание: Дан путь к файлу "C:/Пользователи/Документы/report.txt". Извлеките название файла с расширением.
 */

fun fileName(path: String) {
    val split = path.split("/").last()
    println(split)
}


/*
Задание 5: Создание Аббревиатуры из Фразы. Используй split с набором символов для разделения.
Используй for для перебора слов. Используй var переменную для накопления первых букв.
Описание: У вас есть фраза, например "Объектно-ориентированное программирование".
Создайте аббревиатуру из начальных букв слов (например, "ООП").
 */

fun firstLetter(str: String) {
    val split = str.split(" ", "-")
    var letter = ""

    for (i in split) {
        letter += i[0].uppercase()
    }
    println(letter)
}

/*
Написать метод, который преобразует строку из нескольких слов в строку,
где каждое слово начинается с заглавной буквы а все остальные - строчные.
(можно использовать такой же подход как в задании 5, но накапливать не первые буквы
а целиком слова, составленные из первой буквы с uppercase и оставшейся части слова)
 */
fun convertString(str: String) {
    val split = str.split(" ")
    var letter = ""


    for (i in split) {
        letter += i[0].uppercase() + i.substring(1) + " "
    }
    println(letter.trim())
}


/*
Таблица умножения

Вывести таблицу умножения в консоль так, чтобы были ровные строки и столбцы. В заголовках столбцов и строк - числа для перемножения. В перекрестии - результат умножения. Каждый столбец должен быть выровнен по правому краю.
Для печати результата в той же строке использовать print()
Для перехода на следующую строку использовать println()
Для выравнивания использовать функции форматирования строк с шаблоном (%s)
*/

fun multiply() {
    for (i in 1..9) {
        print(String.format("%4s", "$i"))
    }
    println(" ")
    for (i in 1..9) {
        print("$i")
//        print(String.format("%-1s", "$i" ))
        for (j in 1..9) {
            print(String.format("%4s", " ${i * j} "))
        }
        println(" ")
    }
}

/*
Написать шифратор/дешифратор для строки.
Шифровка производится путём замены двух соседних букв между собой:
Kotlin шифруется в oKltni.
Дешифровка выполняется аналогично.
Если длина строки - нечётная,
в конец добавляется символ пробела до начала шифрования.
Таким образом все шифрованные сообщения будут с чётной длинной.
Должно получиться два публичных метода: encrypt()
и decrypt() которые принимают и возвращают строку.
 */
fun encrypt(str: String) {
    var text = str
    if (text.length % 2 != 0) {
        text += " "
    }

    decrypt(text)
}

fun decrypt(str: String): String {
    var firstChar = ' '
    var secondChar = ' '
    var final = ""
    var count = 0

    for (i in 0 until str.length / 2) {
        secondChar = str[count++]
        firstChar = str[count++]
        final += firstChar
        final += secondChar
    }
    println(final)
    return final
}


/*
Для усложнения задачи, можно в метод передавать размерность таблицы по вертикали
и горизонтали и динамически рассчитывать количество пробелов для форматирования.
*/
fun multi2(x: Int, y: Int) {
    val space = y / 10
    print(String.format("%${space}s", ""))
    for (i in 1..y) {
        print(String.format("%${space}s", "$i"))
    }
    println()
    for (i in 1..x) {
        print(String.format("%${space}s", "$i"))
        for (j in 1..y) {
            print(String.format("%${space}s", i * j))
        }
        println()
    }
}

