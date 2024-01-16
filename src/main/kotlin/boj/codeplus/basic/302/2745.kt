package boj.codeplus.basic.`302`

import kotlin.math.pow

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->

            val (number, radix) = br.readLine().split(" ")

            val decimalList = mutableListOf<Long>()

            for (i in number.indices) {
                val char = number[i]
                val baseNumber = if (char.isLetter()) char - 'A' + 10
                else char - '0'

                val numberForPow = number.length - 1 - i
                val powOfRadix = radix.toDouble().pow(numberForPow).toLong()
                decimalList.add(powOfRadix * baseNumber)
            }

            bw.write("${decimalList.sum()}")
        }
        bw.flush()
    }

}

