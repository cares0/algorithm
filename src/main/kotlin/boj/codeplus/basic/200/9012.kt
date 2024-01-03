package boj.codeplus.basic.`200`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.use {
        val inputSize = br.readLine().toInt()

        repeat(inputSize) {
            bw.write("${isVps(br.readLine())}\n")
        }
    }

    bw.flush()
    bw.close()
}

fun isVps(str: String): String {
    val stack = ArrayStack<Char>()
    str.forEach { char ->
        if (char == '(') stack.push(char)
        else stack.pop() ?: return "NO"
    }
    return if (stack.isEmpty()) "YES"
    else "NO"
}