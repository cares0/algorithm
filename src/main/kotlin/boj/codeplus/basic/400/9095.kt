package boj.codeplus.basic.`400`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val inputSize = br.readLine().toInt()

            val dp = Array<Int?>(11) { null }

            dp[1] = 1
            dp[2] = 2
            dp[3] = 4

            repeat(inputSize) {
                val n = br.readLine().toInt()

                for (i in 4 .. n) {
                    if (dp[i] != null) continue
                    else dp[i] = dp[i - 3]!! + dp[i - 2]!! + dp[i - 1]!!
                }

                bw.write("${dp[n]}\n")
            }
        }
    }

}