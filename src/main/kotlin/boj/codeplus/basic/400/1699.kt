package boj.codeplus.basic.`400`

import kotlin.math.min
import kotlin.math.sqrt

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val number = br.readLine().toInt()
        val dp = LongArray(number + 1) { it.toLong() }
        for (i in 2 .. number) {
            for (j in 2 .. sqrt(i.toDouble()).toInt()) {
                dp[i] = min(dp[i], dp[i - j * j] + 1)
            }
        }

        bw.write("${dp[number]}")
    }
    bw.flush()
}

