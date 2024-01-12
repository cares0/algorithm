package boj.codeplus.basic.`301`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->

            val inputSize = br.readLine().toInt()
            val isPrimeNumberArray = getIsPrimeNumberArray(1000000)

            repeat(inputSize) {
                val number = br.readLine().toInt()

                var gap = 2
                var count = 0

                while (true) {
                    val left = gap
                    val right = number - left
                    if (left > right) break
                    if (isPrimeNumberArray[left] && isPrimeNumberArray[right]) count++
                    gap += 1
                }

                bw.write("${count}\n")
            }
        }
    }

}

fun getIsPrimeNumberArray(to: Int): Array<Boolean> {

    val primeNumberArray = Array(to) { true }

    primeNumberArray[0] = false
    primeNumberArray[1] = false
    for (i in 2 until to) {
        if (primeNumberArray[i]) {
            var index = i + i
            while (index < to) {
                primeNumberArray[index] = false
                index += i
            }
        }
    }

    return primeNumberArray
}