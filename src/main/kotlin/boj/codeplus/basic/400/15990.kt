package boj.codeplus.basic.`400`

import kotlin.math.max

fun main2() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val inputSize = br.readLine().toInt()
            val inputNumbers = mutableListOf<Int>()
            var maxNumber = 0

            repeat(inputSize) {
                val number = br.readLine().toInt()
                maxNumber = max(maxNumber, number)
                inputNumbers.add(number)
            }

            val dp = Array(maxNumber + 1) { Array<Long?>(4) { null } }
            dp[1][1] = 1
            dp[1][2] = 0
            dp[1][3] = 0

            dp[2][1] = 0
            dp[2][2] = 1
            dp[2][3] = 0

            dp[3][1] = 1
            dp[3][2] = 1
            dp[3][3] = 1

            inputNumbers.forEach { number ->

                for (i in 4 .. number) {
                    if (dp[i][1] == null) dp[i][1] = (dp[i - 1][2]!! + dp[i - 1][3]!!) % 1_000_000_009
                    if (dp[i][2] == null) dp[i][2] = (dp[i - 2][1]!! + dp[i - 2][3]!!) % 1_000_000_009
                    if (dp[i][3] == null) dp[i][3] = (dp[i - 3][2]!! + dp[i - 3][1]!!) % 1_000_000_009
                }

                bw.write("${dp[number].sumOf { it ?: 0 } % 1_000_000_009}\n")
            }

        }
        bw.flush()
    }

}

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val inputSize = br.readLine().toInt()

        val dp = Array(100001) { LongArray(4) }
        dp[1][1] = 1
        dp[2][2] = 1
        dp[3][1] = 1
        dp[3][2] = 1
        dp[3][3] = 1

        for (i in 4..100000) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % 1_000_000_009
        }

        repeat(inputSize) {
            val number = br.readLine().toInt()
            bw.write("${dp[number].sumOf { it } % 1_000_000_009}\n")
        }
    }
    bw.flush()
}