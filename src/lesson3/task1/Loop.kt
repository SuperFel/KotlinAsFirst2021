@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.*

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    if (n == 0)
        return 1

    var cnt: Int = 0
    var x: Int = n

    if (x < 0)
        x *= -1

    while (x > 0) {
        cnt += 1
        x /= 10
    }

    return cnt
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a: Int = 1;
    var b: Int = 1;
    var c: Int
    var i: Int = 3

    while (i <= n) {
        c = a + b;
        a = b;
        b = c;
        i += 1
    }
    return b;
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var x: Int = 1

    for (i in 2..n)
        if (n % i == 0) {
            x = i
            break
        }

    return x
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var x: Int = n / 2 // 9

    for (i in x downTo 1)
        if (n % i == 0) {
            x = i
            break
        }

    return x
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var cnt: Int = 0
    var k: Int = x

    while (k != 1) {
        if (k % 2 == 0)
            k /= 2
        else
            k = 3 * k + 1

        cnt += 1
    }

    return cnt
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {

    var a: Int = m
    var b: Int = n
    var c: Int

    while (b > 0) {
        c = a % b
        a = b
        b = c
    }

    return m * n / a
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var x: Int = m
    var y: Int = n

    while (x > 0 && y > 0) {
        if (x > y)
            x %= y
        else
            y %= x
    }

    return x + y == 1
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var result: String = ""
    var x: Int = n

    while (x > 0) {
        result += (x % 10).toString()
        x /= 10
    }
    if (n == 0)
        return 0

    return result.toInt()
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var result: String = ""
    var x: Int = n

    while (x > 0) {
        result += (x % 10).toString()
        x /= 10
    }

    return n.toLong() == result.toLong()
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    if (n in 0..9)
        return false

    var k: Int = n % 10
    var x: Int = n / 10

    while (x > 0) {
        if (x % 10 != k)
            return true
        x /= 10
    }

    return false
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */

fun fac(n: Int): Double
{
    var result: Int = 1
    for (i in 2..n)
        result *= i

    return result.toDouble()
}

fun sin(x: Double, eps: Double): Double
{
    fun mysin_x(x: Double, eps: Double): Double
    {
        var s: Double = 0.0
        var an: Double = 1.0
        var n: Int = 0

        while (abs(an) > eps)
        {
            s += an
            an *= -x * x / (2 * n + 2.0) / (2.0 * n + 3.0)
            n += 1
        }

        return s;
    }

    var new_x: Double = x
    var e: Double = eps
    var y1: Double = mysin_x(x, eps)
    var y2: Double = sin(x) / x

    return y2
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */

fun col(n: Int): Int {
    if (n / 10 == 0) return 1
    var s: Int = n
    var k: Int = 0
    while (s > 0) {
        k += 1
        s /= 10
    }

    return k
}

fun squareSequenceDigit(n: Int): Int {
    var s: Int = 0
    var i: Double = 1.0
    var box: Int = 0
    var ch: Double = 0.0
    while (s < n) {
        s += col(i.pow(2.0).toInt())
        box = col(i.pow(2.0).toInt())
        ch = i.pow(2.0)
        i += 1
    }
    s -= box

    var gl: Int = ch.toInt()
    var mas: Array<Int> = emptyArray<Int>()
    while (gl > 0) {
        mas += gl % 10
        gl /= 10
    }
    mas.reverse()

    return (mas[n - s - 1])
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var s: Int = 0
    var pr: Int = 0
    var box: Int
    var sled: Int = 1
    var dbl: Int = 0
    var cont: Int = 0
    while (s < n) {
        s += col(sled)
        dbl = col(sled)
        cont = sled
        box = sled
        sled += pr
        pr = box
    }
    s -= dbl

    var mas: Array<Int> = emptyArray<Int>()
    while (cont > 0) {
        mas += cont % 10
        cont /= 10
    }
    mas.reverse()

    return mas[n - s - 1]
}
