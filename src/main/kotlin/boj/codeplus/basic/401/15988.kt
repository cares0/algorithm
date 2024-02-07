package boj.codeplus.basic.`401`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val size = br.readLine().toInt()
        val dp = Array(1000001) { 0L }
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4

        for (i in 4 until dp.size) {
            for (j in i - 1 downTo i - 3) {
                dp[i] = (dp[i] + dp[j]) % 1_000_000_009
            }
        }

        repeat(size) {
            val n = br.readLine().toInt()
            bw.write("${dp[n]}\n")
        }
    }
    bw.flush()
}
//1810017806