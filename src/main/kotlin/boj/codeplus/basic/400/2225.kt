package boj.codeplus.basic.`400`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val (n, k) = br.readLine().split(" ").map(String::toInt)

        val dp = Array(k + 1) { IntArray(n + 1) { 1 } }
        for (i in 1 .. n) { dp[0][i] = 0 }

        for (i in 1 .. k) {
            for (j in 1 .. n) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000
            }
        }

        bw.write("${dp[k][n]}")
    }
}