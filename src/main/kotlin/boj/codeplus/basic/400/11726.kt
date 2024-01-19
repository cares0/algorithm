package boj.codeplus.basic.`400`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val n = br.readLine().toInt()

            val dp = Array(n + 1) { 0L }

            dp[0] = 1
            dp[1] = 1

            for (i in 2 .. n) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
            }

            bw.write("${dp[n]}")
        }
        bw.flush()
    }

}