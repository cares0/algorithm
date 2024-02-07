package boj.codeplus.basic.`401`

import kotlin.math.min

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val size = br.readLine().toInt()
        val dp = Array(size + 1) { IntArray(3) }

        for (i in 1 .. size) {
            val (r, g, b) = br.readLine().split(" ").map(String::toInt)
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + r
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + g
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + b
        }

        bw.write("${dp[size].min()}")
    }
    bw.flush()
}