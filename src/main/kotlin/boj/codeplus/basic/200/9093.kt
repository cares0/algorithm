package boj.codeplus.basic.`200`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    br.use {
        var inputSize = br.readLine().toInt()
        val stack = ArrayStack<Char>()
        while (inputSize-- > 0) {
            val words = br.readLine().split(" ")
            words.forEach { word ->
                word.forEach { char -> stack.push(char) }
                while (!stack.isEmpty()) {
                    bw.write("${stack.pop()}")
                }
                bw.write(" ")
            }
            bw.write("\n")
        }
    }

    bw.flush()
    bw.close()
}
