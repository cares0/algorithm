package boj.codeplus.basic.`300`

import java.math.BigInteger

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val number = br.readLine().toInt()
            var count = 0
            var temp = number
            while (temp >= 5) {
                count += temp / 5
                temp /= 5
            }
            bw.write("$count")
        }
        bw.flush()
    }
}

fun main2() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val number = br.readLine().toInt()

            var result = BigInteger.ONE
            for (i in 1 .. number) {
                result *= BigInteger("$i")
            }

            bw.write("${result.toString().takeLastWhile { it == '0' }.length}")
        }
        bw.flush()
    }
}
