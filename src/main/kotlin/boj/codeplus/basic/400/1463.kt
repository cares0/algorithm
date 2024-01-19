package boj.codeplus.basic.`400`

import kotlin.math.min

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val number = br.readLine().toInt()

        val dp = Array(number + 1) { 0 }

        for (i in 2 .. number) {
            var min = Int.MAX_VALUE
            if (i % 3 == 0) {
                min = min(min, dp[i / 3])
            }
            if (i % 2 == 0) {
                min = min(min, dp[i / 2])
            }
            min = min(min, dp[i - 1])

            dp[i] = min + 1
        }

        bw.write("${dp[number]}")
    }
    bw.flush()
}