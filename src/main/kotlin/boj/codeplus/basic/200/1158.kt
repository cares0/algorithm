package boj.codeplus.basic.`200`

import boj.codeplus.basic.RingBuffer
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val (n, k) = br.readLine().split(" ").map(String::toInt)

            val ringBuffer = RingBuffer<Int>(n)
            bw.write("<")

            repeat(n) {
                ringBuffer.offer(it + 1)
            }

            val list = mutableListOf<Int>()

            for (i in 0 until n * k step k) {
                repeat(k) {
                    val poll = ringBuffer.poll()
                    if (it == k - 1) {
                        list.add(poll!!)
                    } else {
                        if (poll != null) ringBuffer.offer(poll)
                    }
                }
            }
            bw.write(list.joinToString(", "))
            bw.write(">")
        }
    }

}