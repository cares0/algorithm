package boj.codeplus.basic.`402`

import kotlin.math.min

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val array = Array(n + 1) { IntArray(3) }
        val dp = Array(n + 1) { IntArray(3) }

        for (i in 1 .. n) {
            val (r, g, b) = br.readLine().split(" ").map(String::toInt)
            array[i][0] = r
            array[i][1] = g
            array[i][2] = b
        }

        var result = Int.MAX_VALUE

        for (i in 0 .. 2) {
            dp[1] = intArrayOf(1001, 1001, 1001)
            dp[1][i] = array[1][i]

            for (j in 2 .. n) {
                dp[j][0] = min(dp[j - 1][1], dp[j - 1][2]) + array[j][0]
                dp[j][1] = min(dp[j - 1][0], dp[j - 1][2]) + array[j][1]
                dp[j][2] = min(dp[j - 1][0], dp[j - 1][1]) + array[j][2]
            }

            for (k in 0 .. 2) {
                if (i != k) {
                    result = min(result, dp[n][k])
                }
            }
        }

        bw.write("$result")
    }
    bw.flush()
}