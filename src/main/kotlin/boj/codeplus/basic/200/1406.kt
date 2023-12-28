package boj.codeplus.basic.`200`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val leftStack = ListStack<Char>()
    val rightStack = ListStack<Char>()

    val initString = br.readLine()
    initString.forEach(leftStack::push)

    val inputSize = br.readLine().toInt()
    repeat(inputSize) {
        when (val command = br.readLine()) {
            "L" -> {
                val char = leftStack.pop()
                if (char != null) rightStack.push(char)
            }

            "D" -> {
                val char = rightStack.pop()
                if (char != null) leftStack.push(char)
            }

            "B" -> {
                leftStack.pop()
            }

            else -> { // P
                val charToAdd = command.split(" ")[1].single()
                leftStack.push(charToAdd)
            }
        }
    }
    br.close()

    var leftStr = ""

    while (!leftStack.isEmpty()) {
        leftStr += leftStack.pop()!!
    }
    bw.write(leftStr.reversed())

    while (!rightStack.isEmpty()) {
        bw.write(rightStack.pop()?.toString() ?: "")
    }
    bw.flush()
    bw.close()

}