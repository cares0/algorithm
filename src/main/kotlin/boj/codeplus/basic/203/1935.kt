package boj.codeplus.basic.`203`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    System.`in`.bufferedReader()

    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val inputSize = br.readLine().toInt()
            val expression = br.readLine()
            val valueMap = mutableMapOf<Char, Int>()

            for (i in 0 until inputSize) {
                val value = br.readLine().toInt()
                val char = 'A' + i
                valueMap[char] = value
            }

            val stack = ArrayStack<Double>()

            expression.forEach { char ->
                if (char.isLetterOrDigit()) {
                    stack.push(valueMap[char]!!.toDouble())
                } else {
                    val firstNumber = stack.pop()!!
                    val secondNumber = stack.pop()!!

                    when (char) {
                        '+' -> { stack.push(secondNumber + firstNumber) }
                        '-' -> { stack.push(secondNumber - firstNumber) }
                        '*' -> { stack.push(secondNumber * firstNumber) }
                        '/' -> { stack.push(secondNumber / firstNumber) }
                    }
                }
            }

            bw.write(String.format("%.2f", stack.pop()))
        }
    }
}