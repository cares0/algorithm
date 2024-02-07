package boj.codeplus.basic.`401`

import kotlin.math.max

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val array = br.readLine().split(" ").map(String::toInt)
        val dp = IntArray(n)
        var max = 0
        for (i in array.indices) {
            dp[i] = array[i]
            for (j in i downTo 0) {
                if (array[i] > array[j]) {
                    dp[i] = max(dp[i], dp[j] + array[i])
                }
            }
            max = max(dp[i], max)
        }
        bw.write("$max")
    }
    bw.flush()
}