package boj.codeplus.basic.`301`

import boj.codeplus.basic.ArrayStack
import java.math.BigInteger
import kotlin.math.pow

fun main2() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->

            val binaryNumber = br.readLine()

            val length = binaryNumber.length

            var decimalNumber = 0L

            for (i in 1 .. binaryNumber.length) {
                val number = binaryNumber[length - i]
                if (number == '1') {
                    decimalNumber += 2.0.pow(i - 1).toLong()
                }
            }

            var temp = decimalNumber

            val stack = ArrayStack<Long>()
            while (temp != 0L) {
                stack.push(temp % 8L)
                temp /= 8
            }

            if (stack.isEmpty()) bw.write("${0}")
            else {
                while (!stack.isEmpty()) {
                    bw.write("${stack.pop()}")
                }
            }
        }
        bw.flush()
    }

}

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val binaryNumber = br.readLine()

            val bigInteger = BigInteger(binaryNumber, 2)
            bw.write(bigInteger.toString(8))
        }
    }
}