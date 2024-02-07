package boj.codeplus.basic.`401`

import kotlin.math.max

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val array = br.readLine().split(" ").map(String::toInt)
        val dp = IntArray(n) { 1 }
        val reverseDp = IntArray(n) { 1 }
        var max = 1

        for (i in array.indices) {
            for (j in i - 1 downTo 0) {
                if (array[i] > array[j]) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }
        }

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                if (array[i] > array[j]) {
                    reverseDp[i] = max(reverseDp[i], reverseDp[j] + 1)
                }
            }
            max = max(max, reverseDp[i] + dp[i])
        }

        bw.write("${max - 1}")
    }
    bw.flush()
}