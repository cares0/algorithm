package boj.codeplus.basic.`302`

import boj.codeplus.basic.ArrayStack
import kotlin.math.pow

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (radixA, radixB) = br.readLine().split(" ").map(String::toInt)

            br.readLine().toInt()

            val baseNumber = br.readLine().split(" ").joinToString("") {
                val number = it.toInt()
                if (number >= 10) ('A' + number - 10).toString()
                else ('0' + number).toString()
            }

            val decimalNumber = convertToTenRadix(radixA, baseNumber)

            val result = convertFromTenRadix(radixB, decimalNumber)

            result.forEach { char ->
                if (char.isLetter()) bw.write("${char - 'A' + 10} ")
                else bw.write("${char - '0'} ")
            }
        }
        bw.flush()
    }

}

fun convertToTenRadix(radix: Int, value: String): Int {
    val stack = ArrayStack<Int>()
    value.forEach { char ->
        if (char.isLetter()) stack.push(char - 'A' + 10)
        else stack.push(char - '0')
    }

    var sum = 0
    for (i in value.indices) {
        sum += stack.pop()!! * radix.toDouble().pow(i).toInt()
    }

    return sum
}

fun convertFromTenRadix(radix: Int, value: Int): String {
    var temp = value
    val stack = ArrayStack<Char>()

    while (temp > 0) {
        val remainder = temp % radix
        val char = if (remainder >= 10) 'A' + remainder - 10
        else '0' + remainder
        stack.push(char)
        temp /= radix
    }

    var result = ""
    while (!stack.isEmpty()) result += stack.pop()
    return result
}