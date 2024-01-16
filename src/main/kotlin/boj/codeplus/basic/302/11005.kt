package boj.codeplus.basic.`302`

import boj.codeplus.basic.ArrayStack

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (number, radix) = br.readLine().split(" ").map { it.toInt() }

            var temp = number
            var remainderStack = ArrayStack<Char>()

            while (temp > 0) {
                val remainder = temp % radix
                val baseValue = if (remainder >= 10) {
                    'A' + remainder - 10
                } else '0' + remainder
                remainderStack.push(baseValue)
                temp /= radix
            }

            while (!remainderStack.isEmpty()) {
                bw.write("${remainderStack.pop()}")
            }
        }
    }

}