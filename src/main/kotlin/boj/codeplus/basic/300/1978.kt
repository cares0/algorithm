package boj.codeplus.basic.`300`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val inputSize = br.readLine().toInt()

            val numbers = br.readLine().split(" ")

            val primeNumberMap = getIsPrimeNumberMap(1000)

            var cnt = 0
            numbers.forEach {
                if (primeNumberMap[it.toInt()]!!) {
                    cnt++
                }
            }

            bw.write("$cnt")
        }
        bw.flush()
    }

}

fun getPrimeNumbers(to: Int): MutableList<Int> {
    val numberList = (2..to).toMutableList()

    var i = 0
    while (i < numberList.size) {
        val number = numberList[i]
        numberList.removeIf { it != number && it % number == 0 }
        i++
    }

    return numberList
}

fun getIsPrimeNumberMap(to: Int): Map<Int, Boolean> {
    val isPrimeMap = (1..to).associateWith { true }.toMutableMap()

    isPrimeMap[1] = false
    (2 until to).forEach { number ->
        if (isPrimeMap[number]!!) {
            var index = 2
            while (number * index <= to) {
                isPrimeMap[number * index] = false
                index++
            }
        }
    }

    return isPrimeMap
}