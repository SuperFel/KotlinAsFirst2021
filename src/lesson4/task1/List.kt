@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.*

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double
{
    var result: Double = 0.0
    for (i in v)
        result += (i * i)

    return sqrt(result)
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = if (list.isEmpty()) 0.0 else list.sum() / list.size

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double>
{
    val average: Double = mean(list)
    for (i in 0 until list.size)
        list[i] = list[i] - average

    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int
{
    var C: Int = 0

    for (i in 0 until a.size)
        C += (a[i] * b[i])

    return C
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int
{
    var result: Int = 0
    for (i in 0 until p.size)
        result += p[i] * (x.toDouble().pow(i.toDouble())).toInt()

    return result
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int>
{
    var sum: Int = 0
    for (i in 0 until list.size) {
        sum += list[i]
        list[i] = sum
    }

    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int>
{
    val result: MutableList<Int> = mutableListOf()
    var x: Int = n
    var i: Int = 2
    while (x > 1)
    {
        if (x % i == 0)
        {
            result.add(i)
            x /= i
        } else i += 1
    }

    return result.toList()
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int>
{
    if (n < base)
        return listOf(n)

    val list: MutableList<Int> = mutableListOf()
    var newN: Int = n
    do
    {
        list.add(newN % base)
        newN /= base
    }
    while (newN >= base)
        list.add(newN % base)

    return list.reversed()
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */

fun convertToString(n: Int, base: Int): String
{
    val alphabet: String = "0123456789abcdefghijklmnopqrstuvwxyz"
    val per: MutableMap<Int, Char> = mutableMapOf()

    for (i in 0..35)
        per += mapOf(i to alphabet[i])

    if (n < base)
        return per[n].toString()

    var newN: Int = n
    val result: StringBuilder = StringBuilder()

    while (newN > 0)
    {
        result.append(per[newN % base].toString())
        newN /= base
    }

    return "$result".reversed()
}

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int
{
    var summa: Int = 0
    var x: Double = 0.0
    for (i in digits.size - 1 downTo 0)
    {
        summa += (digits[i] * base.toDouble().pow(x)).toInt()
        x += 1
    }

    return summa
}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */

fun decimalFromString(str: String, base: Int): Int
{
    val alphabet: String = "0123456789abcdefghijklmnopqrstuvwxyz"
    val per: MutableMap<Char, Int> = mutableMapOf()
    var k: Double = 0.0
    var result: Int = 0

    for (i in 0 until 36)
        per += mapOf(alphabet[i] to i)

    for (i in str.length - 1 downTo 0)
    {
        result += per[str[i]]!! * (base.toDouble().pow(k)).toInt()
        k += 1
    }

    return result
}

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String
{
    val list1: List<Int> = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val list2: List<String> = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var num: Int = n
    val result: MutableList<String> = mutableListOf()

    for (d in 0 until list1.size)
        while (num >= list1[d])
        {
            result.add(list2[d])
            num -= list1[d]
        }

    return result.joinToString(separator = "")
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */

fun getRussian(value: Int): String
{
    var result: StringBuilder = StringBuilder()
    var temp: String = ""

    if (value > 99)
    {
        temp = when (value / 100)
        {
            1 -> "сто"
            2 -> "двести"
            3 -> "триста"
            4 -> "четыреста"
            5 -> "пятьсот"
            6 -> "шестьсот"
            7 -> "семьсот"
            8 -> "восемьсот"
            else -> "девятьсот"
        }
        result.append(temp)
    }
    if (value % 100 != 0)
    {
        if (value > 99)
            result.append(' ')
        if (value % 100 in 10..19)
        {
            temp = when (value % 100)
            {
                10 -> "десять"
                11 -> "одиннадцать"
                12 -> "двенадцать"
                13 -> "тринадцать"
                14 -> "четырнадцать"
                15 -> "пятнадцать"
                16 -> "шестнадцать"
                17 -> "семнадцать"
                18 -> "восемнадцать"
                else -> "девятнадцать"
            }
            result.append(temp)
        }
        else
        {
            if (value % 100 >= 20)
            {
                temp = when((value % 100) / 10)
                {
                    2 -> "двадцать"
                    3 -> "тридцать"
                    4 -> "сорок"
                    5 -> "пятьдесят"
                    6 -> "шестьдесят"
                    7 -> "семьдесят"
                    8 -> "восемьдесят"
                    else -> "девяносто"
                }
                result.append(temp)
            }
            if (value % 10 != 0)
            {
                if (value % 100 >= 20)
                    result.append(' ')
                temp = when (value % 10)
                {
                    1 -> "один"
                    2 -> "два"
                    3 -> "три"
                    4 -> "четыре"
                    5 -> "пять"
                    6 -> "шесть"
                    7 -> "семь"
                    8 -> "восемь"
                    else -> "девять"
                }
                result.append(temp)
            }
        }
    }

    return result.toString()
}

fun russian(value: Int): String
{
    var result = ""
    if(value == 0)
        result = "ноль"
    else
    {
        if(value > 999)
        {
            result = getRussian(value / 1000)
            result = when((value / 1000) % 10) {
                1 -> result.dropLast(4) + "одна тысяча"
                2 -> result.dropLast(3) + "две тысячи"
                3 -> "$result тысячи"
                4 -> "$result тысячи"
                else -> "$result тысяч"
            }
        }
        if(value % 1000 != 0)
        {
            if(value > 999)
                result += ' '
            result += getRussian(value % 1000)
        }
    }

    return result
}