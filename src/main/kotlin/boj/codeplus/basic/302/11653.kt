package boj.codeplus.basic.`302`

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val number = br.readLine().toInt()
            var temp = number
            var i = 2
            while (temp > 1) {
                if (temp % i == 0) {
                    temp /= i
                    bw.write("$i\n")
                    i = 2
                } else {
                    i++
                }
            }
        }
        bw.flush()
    }
}

fun main2() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val number = br.readLine().toInt()

            val primeNumbers = getPrimeNumbers()
            var temp = number

            while (temp > 1) {
                for (primeNumber in primeNumbers) {
                    if (temp % primeNumber == 0) {
                        temp /= primeNumber
                        bw.write("$primeNumber\n")
                        break
                    }
                }
            }
        }
        bw.flush()
    }

}

fun getPrimeNumbers(): List<Int> {

    val to = 10000000
    val isPrimeNumberArray = Array(to + 1) { true }
    val primeNumbers = mutableListOf<Int>()

    for (i in 2 ..to) {
        if (isPrimeNumberArray[i]) {
            primeNumbers.add(i)
            var value = 1
            while (value * i <= to) {
                isPrimeNumberArray[value * i] = false
                value++
            }
        }
    }

    return primeNumbers
}