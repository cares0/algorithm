package boj.codeplus.basic.`401`

import kotlin.math.pow

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()

        var dp = LongArray(31)
        dp[0] = 1
        dp[2] = 3
        for (i in 4 .. n step 2) {
            dp[i] = dp[i - 2] * dp[2]
            for (j in i - 4 downTo 0 step 2) {
                dp[i] += dp[j] * 2
            }
        }
        bw.write("${dp[n]}")
    }
    bw.flush()
}