package boj.codeplus.basic.`201`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val commands = br.readLine().toList()
            val stack = ArrayStack<Int>()
            var result = 0

            for (pointer in commands.indices) {
                val command = commands[pointer]
                if (command == '(') {
                    stack.push(pointer)
                    result++
                } else {
                    val start = stack.pop()!!
                    val range = pointer - start
                    if (range == 1) {
                        result--
                        result += stack.size()
                    }
                }
            }
            bw.write("$result")
        }
        bw.flush()
    }

}