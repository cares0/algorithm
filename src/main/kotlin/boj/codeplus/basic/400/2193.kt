package boj.codeplus.basic.`400`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val number = br.readLine().toInt()

        val dp = Array(number + 1) { LongArray(2) { 0 } }
        dp[1][1] = 1

        for (i in 2 .. number) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
            dp[i][1] = dp[i - 1][0]
        }

        bw.write("${dp[number].sum()}")
    }
    bw.flush()
}