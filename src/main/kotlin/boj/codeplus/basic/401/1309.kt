package boj.codeplus.basic.`401`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val dp = Array(n + 1) { IntArray(3) { 1 } }

        for (i in 2 .. n) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901
        }

        bw.write("${dp[n].sum() % 9901}")
    }
    bw.flush()
}