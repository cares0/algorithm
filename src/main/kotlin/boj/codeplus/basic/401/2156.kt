package boj.codeplus.basic.`401`

import kotlin.math.max

fun main2() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val inputSize = br.readLine().toInt()
        val array = IntArray(inputSize + 1)
        val dp = IntArray(inputSize + 1)

        for (i in 1 ..inputSize) {
            val number = br.readLine().toInt()
            array[i] = number
            when (i) {
                1 -> { dp[1] = number }
                2 -> { dp[2] = dp[1] + number }
                else -> {
                    dp[i] = max(max(dp[i - 3] + array[i - 1] + array[i], dp[i - 1]), dp[i - 2] + array[i])
                }
            }
        }
        bw.write("${dp[inputSize]}")
    }
    bw.flush()
}

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val inputSize = br.readLine().toInt()
        val dp = Array(inputSize + 1) { IntArray(3) }

        var firstValue = 0
        for (i in 0 until inputSize) {
            val number = br.readLine().toInt()
            val actualIndex = i + 1
            dp[actualIndex][0] = 0 // 안고르는 경우
            dp[actualIndex][1] = number // 1번째 전을 고르는 경우
            dp[actualIndex][2] = number // 2번째 전을 고르는 경우

            when (actualIndex) {
                1 -> {
                    firstValue = number
                }
                2 -> {
                    dp[2][0] = firstValue
                    dp[2][1] += dp[1][1]
                }
                else -> {
                    dp[actualIndex][0] = dp[actualIndex - 1].max()
                    dp[actualIndex][1] += dp[actualIndex - 1][2]
                    dp[actualIndex][2] += dp[actualIndex - 2].max()
                }
            }
        }
        bw.write("${dp[inputSize].max()}")
    }
    bw.flush()
}


fun main3() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val inputSize = br.readLine().toInt()
        val dp = Array(inputSize + 1) { IntArray(3) }
        val dpString = Array(inputSize + 1) { Array<String>(3) { "" } }

        var firstValue = 0
        for (i in 0 until inputSize) {
            val number = br.readLine().toInt()
            val actualIndex = i + 1
            dp[actualIndex][0] = 0 // 안고르는 경우
            dp[actualIndex][1] = number // 1번째 전을 고르는 경우
            dp[actualIndex][2] = number // 2번째 전을 고르는 경우

            when (actualIndex) {
                1 -> {
                    firstValue = number
                    dpString[1][1] = "${number}"
                    dpString[1][2] = "${number}"
                }
                2 -> {
                    dp[2][0] = firstValue
                    dp[2][1] += dp[1][1]

                    dpString[2][0] += "$firstValue"
                    dpString[2][1] += "${dp[1][1]} + ${number}"
                    dpString[2][2] += "${number}"
                }
                else -> {
                    var valueCom = 0
                    var maxIndex = 0
                    dp[actualIndex - 1].forEachIndexed { index, value ->
                        if (valueCom <= value) {
                            valueCom = value
                            maxIndex = index
                        }
                    }
                    dp[actualIndex][0] = valueCom
                    dpString[actualIndex][0] = dpString[actualIndex - 1][maxIndex]

                    dp[actualIndex][1] += dp[actualIndex - 1][2]
                    dpString[actualIndex][1] = "${dpString[actualIndex - 1][2]} + $number"

                    if (dp[actualIndex - 2][1] >= dp[actualIndex - 2][2]) {
                        dp[actualIndex][2] += dp[actualIndex - 2][1]
                        dpString[actualIndex][2] += "${dpString[actualIndex - 2][1]} + $number"
                    } else {
                        dp[actualIndex][2] += dp[actualIndex - 2][2]
                        dpString[actualIndex][2] += "${dpString[actualIndex - 2][2]} + $number"
                    }
                }
            }
            bw.write("[$actualIndex]번째의 선택 X = ${dpString[actualIndex][0]}\n")
            bw.write("[$actualIndex]번째의 한칸 뒤 = ${dpString[actualIndex][1]}\n")
            bw.write("[$actualIndex]번째의 두칸 뒤 = ${dpString[actualIndex][2]}\n\n")

        }
        bw.write("${dp[inputSize].max()}")
    }
    bw.flush()
}