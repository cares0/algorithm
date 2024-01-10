package boj.codeplus.basic.`203`

import java.math.BigInteger

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (a, b, c, d) = br.readLine().split(" ")

            val ab = BigInteger(a + b)
            val cd = BigInteger(c + d)

            bw.write("${ab + cd}")
        }
        bw.flush()
    }

}