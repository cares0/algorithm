package boj.codeplus.basic.`400`

import kotlin.math.min

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val cardAmount = br.readLine().toInt()
            val cardPackages = br.readLine().split(" ").map(String::toInt).toIntArray()
            val dp = Array(cardAmount + 1) { Int.MAX_VALUE }
            dp[0] = 0
            dp[1] = cardPackages[0]

            for (i in 1 .. cardAmount) {
                for (j in 1 .. i) {
                    dp[i] = min(dp[i], dp[i - j] + cardPackages[j - 1])
                }
            }

            bw.write("${dp[cardAmount]}")
        }
        bw.flush()
    }

}


/** DP[1]인 경우
 * 1장 팩 값
 */

/** DP[2]인 경우
 * 1장을 사기 위한 최대 값 + 1장 팩 값
 * or 2장 팩 값
 */

/** DP[3]인 경우
 * 2장을 사기 위한 최대 값 + 1장 팩 값
 * or 3장 팩 값
 */