package boj.codeplus.basic.`200`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->

            val inputSize = br.readLine().toInt()
            val deque = ArrayDeque<Int>()

            repeat(inputSize) {
                val command = br.readLine()
                when (command) {
                    "pop" -> {
                        bw.write("${deque.removeFirstOrNull() ?: -1}\n")
                    }
                    "size" -> {
                        bw.write("${deque.size}\n")
                    }
                    "empty" -> {
                        bw.write("${if (deque.isEmpty()) 1 else 0}\n")
                    }
                    "front" -> {
                        bw.write("${deque.firstOrNull() ?: -1}\n")
                    }
                    "back" -> {
                        bw.write("${deque.lastOrNull() ?: -1}\n")
                    }
                    else -> { // push
                        val numberToAdd = command.substringAfter(" ").toInt()
                        deque.add(numberToAdd)
                    }
                }
            }
        }
        bw.flush()
    }

}