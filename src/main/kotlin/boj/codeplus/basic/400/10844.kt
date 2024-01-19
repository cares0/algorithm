package boj.codeplus.basic.`400`

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val number = br.readLine().toInt()
            val dp = Array(number + 1) { LongArray(10) { 0 } }
            for (i in 1 .. 9) { dp[1][i] = 1 }

            for (i in 2 .. number) {
                for (j in 0 .. 9) {
                    if (j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j + 1] % 1_000_000_000
                    } else if (j + 1 > 9) {
                        dp[i][j] = dp[i - 1][j - 1] % 1_000_000_000
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % 1_000_000_000
                    }
                }
            }

            bw.write("${dp[number].sumOf { it } % 1_000_000_000}")
        }
    }
}