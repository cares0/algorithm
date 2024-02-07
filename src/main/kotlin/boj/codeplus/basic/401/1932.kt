package boj.codeplus.basic.`401`

import kotlin.math.max

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val dp = Array(n) { IntArray(n) }

        for (i in 0 until n) {
            val numbers = br.readLine().split(" ").map(String::toInt).toIntArray()
            dp[i] = numbers
            when (i) {
                0 -> {}
                else -> {
                    for (j in dp[i].indices) {
                        when (j) {
                            0 -> dp[i][j] += dp[i - 1][0]
                            dp[i].lastIndex -> dp[i][j] += dp[i - 1][dp[i].lastIndex - 1]
                            else -> {
                                dp[i][j] += max(dp[i - 1][j - 1], dp[i - 1][j])
                            }
                        }
                    }
                }
            }
        }

        bw.write("${dp[n - 1].max()}")
    }
    bw.flush()
}