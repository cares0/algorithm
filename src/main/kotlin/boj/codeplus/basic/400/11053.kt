package boj.codeplus.basic.`400`

import kotlin.math.max

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->

        val length = br.readLine().toInt()
        val numbers = mutableListOf(0)
        numbers.addAll(br.readLine().split(" ").map { it.toInt() })
        val dp = IntArray(length + 1) { 0 }

        for (i in 1 .. length) {
            val number = numbers[i]
            var max = 0
            for (j in i - 1 downTo 1) {
                if (numbers[j] < number) {
                    max = max(max, dp[j])
                }

                if (j <= max) break
            }
            dp[i] = max + 1
        }

        bw.write("${dp.max()}")
    }
    bw.flush()
}