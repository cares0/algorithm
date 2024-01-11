package boj.codeplus.basic.`300`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (from, to) = br.readLine().split(" ").map(String::toInt)
            val primeNumberMap = getIsPrimeNumberMap(to)

            (from..to).forEach { if (primeNumberMap[it]!!) bw.write("$it\n") }
        }

        bw.flush()
    }

}