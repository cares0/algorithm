package boj.codeplus.basic.`300`

import kotlin.math.min

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (n, m) = br.readLine().split(" ").map(String::toLong)

            val fiveCount = getSquareOfFive(n) - getSquareOfFive(n - m) - getSquareOfFive(m)
            val twoCount = getSquareOfTwo(n) - getSquareOfTwo(n - m) - getSquareOfTwo(m)

            bw.write("${min(fiveCount, twoCount)}")
        }
        bw.flush()
    }
}

fun getSquareOfFive(number: Long): Long {

    var count = 0L
    var temp = number
    while (temp >= 5) {
        count += temp / 5L
        temp /= 5
    }

    return count
}

fun getSquareOfTwo(number: Long): Long {

    var count = 0L
    var temp = number
    while (temp >= 2) {
        count += temp / 2L
        temp /= 2
    }

    return count
}