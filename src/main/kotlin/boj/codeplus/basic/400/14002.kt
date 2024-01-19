package boj.codeplus.basic.`400`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val size = br.readLine().toInt()
        val numbers = br.readLine().split(" ")
        val dp = numbers.map { intArrayOf(it.toInt()) }.toTypedArray()

        for (i in 0 until size) {
            for (j in i - 1 downTo 0) {
                if (numbers[i].toInt() > numbers[j].toInt()) {
                    if (dp[i].size <= dp[j].size) {
                        dp[i] = dp[j].plus(numbers[i].toInt())
                    }
                }
                // if ((dp[i].size) > j) break
            }
        }

        val maxDp = dp.maxBy { it.size }
        bw.write("${maxDp.size}\n")
        bw.write(maxDp.joinToString(" "))
    }
}