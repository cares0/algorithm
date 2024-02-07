package boj.codeplus.basic.`401`

import kotlin.math.max

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->

        val testCase = br.readLine().toInt()

        repeat(testCase) {
            val n = br.readLine().toInt()
            val dp = Array(2) { IntArray(n) }

            dp[0] = br.readLine().split(" ").map(String::toInt).toTypedArray().toIntArray()
            dp[1] = br.readLine().split(" ").map(String::toInt).toTypedArray().toIntArray()

            if (n != 1) {
                dp[0][1] += dp[1][0]
                dp[1][1] += dp[0][0]
            }

            for (i in 2 until n) {
                dp[0][i] += max(dp[1][i - 1], dp[1][i - 2])
                dp[1][i] += max(dp[0][i - 1], dp[0][i - 2])
            }

            bw.write("${max(dp[0][n - 1], dp[1][n - 1])}\n")
        }
    }
    bw.flush()
}