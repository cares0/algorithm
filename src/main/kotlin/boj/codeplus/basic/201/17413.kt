package boj.codeplus.basic.`201`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val string = br.readLine()
            val stack = ArrayStack<Char>()
            var isAngleBracketMode = false

            string.forEach { char ->
                if (char == '<') {
                    while (!stack.isEmpty()) bw.write("${stack.pop()}")
                    isAngleBracketMode = true
                    bw.write("$char")
                } else if (char == '>') {
                    isAngleBracketMode = false
                    bw.write("$char")
                } else if (char == ' ' && !isAngleBracketMode) {
                    while (!stack.isEmpty()) bw.write("${stack.pop()}")
                    bw.write(" ")
                } else if (isAngleBracketMode){
                    bw.write("$char")
                } else {
                    stack.push(char)
                }
            }
            while (!stack.isEmpty()) bw.write("${stack.pop()}")
        }
        bw.flush()
    }

}

