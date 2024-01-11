package boj.codeplus.basic.`300`

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val isOddPrimeNumberArray = getIsOddPrimeNumberArray(1000000)

            while (true) {
                val number = br.readLine().toInt()
                if (number == 0) break

                var gap = 3
                while (true) {
                    val left = gap
                    val right = number - left

                    if (left > right) {
                        bw.write("Goldbach's conjecture is wrong.")
                        break
                    } else if (isOddPrimeNumberArray[left] && isOddPrimeNumberArray[right]) {
                        bw.write("$number = $left + $right\n")
                        break
                    } else {
                        gap += 2
                    }
                }
            }
        }
        bw.flush()
    }
}

fun getIsOddPrimeNumberArray(to: Int): Array<Boolean> {
    val isPrimeArray = Array(to) { true }
    isPrimeArray[1] = false
    (3 until to step 2).forEach { number ->
        if (isPrimeArray[number]) {
            var index = 2
            while (number * index <= to) {
                if ((number * index) % 2 != 0) isPrimeArray[number * index] = false
                index++
            }
        }
    }

    return isPrimeArray
}
