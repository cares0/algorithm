package boj.codeplus.basic.`301`

import boj.codeplus.basic.ArrayStack
import java.math.BigInteger

fun main() {
    
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->

            val decimalNumber = br.readLine().toLong()

            var temp = decimalNumber

            if (temp == 0L) {
                bw.write("0")
                return
            }

            val stack = ArrayStack<Long>()
            while (temp != 0L) {
                val remainder = temp % -2
                temp /= -2
                if (remainder == -1L) {
                    stack.push(1)
                    temp++
                }
                else stack.push(remainder)
            }

            while (!stack.isEmpty()) {
                bw.write("${stack.pop()}")
            }
        }
        bw.flush()
    }
    
}