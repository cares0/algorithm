package boj.codeplus.basic.`401`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()

        val dp = Array(n + 1) { IntArray(10) { 1 } }

        for (i in 2 .. n) {
            for (j in 0 .. 9) {
                dp[i][j] = dp[i - 1].take(j + 1).sum() % 10007
            }
        }

        bw.write("${dp[n].sum() % 10007}")
    }
    bw.flush()
}