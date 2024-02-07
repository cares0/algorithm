package boj.codeplus.basic.`401`

import kotlin.math.max

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val array = br.readLine().split(" ").map(String::toInt).toTypedArray()
        val minusArray = array.copyOf()
        var minusNumber = 0

        for (i in 1 until n) {
            if (array[i] < array[i - 1] + array[i]) {
                array[i] = array[i - 1] + array[i]
            }

            // 1개를 뺀 배열의 이전 값에서 현재 값을 더한게 더 작은 경우, 현재 값을 뺄 경우 더 큰 수가 나올 가능성이 있다는 뜻
            if (minusArray[i - 1] + minusArray[i] < minusArray[i - 1]) {
                val minNumber: Int
                val maxNumber: Int

                // 기존의 뺀 값과 현재 값 중 큰 수와 작은 수를 구함
                if (minusArray[i] - minusNumber > 0) {
                    minNumber = minusNumber
                    maxNumber = minusArray[i]
                } else {
                    minNumber = minusArray[i]
                    maxNumber = minusNumber
                }

                // 더 작은 수를 빼야하는 수로 지정
                minusNumber = minNumber

                // 더 큰 수를 이전 값에서 더하면, 이전에 뺐던 수와 현재 수 중 큰 값을 결국 더하게 됨(작은 값을 빼게 되는 것임)
                minusArray[i] = minusArray[i - 1] + maxNumber

                // 하지만 만약 이전 값이, 큰 수를 더했을 때보다 크다면 굳이 이전 값부터 시작할 이유가 없어짐
                if (array[i - 1] > minusArray[i - 1] + maxNumber) {
                    // 1개를 뺀 배열에는 이전 배열의 값에 현재 수를 뺀 값으로 변경해버림
                    minusArray[i] = array[i - 1]
                }
            } else {
                minusArray[i] = minusArray[i - 1] + minusArray[i]
            }
        }

        bw.write("${max(array.max(), minusArray.max())}")
    }
    bw.flush()
}