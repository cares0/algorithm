package boj.codeplus.basic.`301`

import boj.codeplus.basic.`300`.getGcd


fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val inputSize = br.readLine().toInt()

            repeat(inputSize) {
                val command = br.readLine().split(" ")
                val numbers = command.subList(1, command.size)

                var amount = 0L
                getAllPairs(numbers).forEach { (a, b) ->
                    amount += getGcd(a.toInt(), b.toInt())
                }

                bw.write("$amount\n")
            }
        }
        bw.flush()
    }

}

fun <T> getAllPairs(list: List<T>): List<Pair<T, T>> {
    val pairs = mutableListOf<Pair<T, T>>()

    for (i in 0 until list.size - 1) {
        for (j in i + 1 until list.size) {
            pairs.add(Pair(list[i], list[j]))
        }
    }

    return pairs
}