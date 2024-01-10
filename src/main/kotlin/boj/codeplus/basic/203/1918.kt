package boj.codeplus.basic.`203`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val commands = br.readLine()

            val operatorStack = ArrayStack<Char>()

            commands.forEach { command ->
                when {
                    command.isLetterOrDigit() -> bw.write("$command")
                    command == '(' -> operatorStack.push(command)
                    command == ')' -> {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                            bw.write("${operatorStack.pop()}")
                        }
                        operatorStack.pop()
                    }
                    else -> {
                        while (!operatorStack.isEmpty() && getPrecedence(command) <= getPrecedence(operatorStack.peek()!!)) {
                            bw.write("${operatorStack.pop()}")
                        }
                        operatorStack.push(command)
                    }
                }
            }

            while (!operatorStack.isEmpty()) {
                bw.write("${operatorStack.pop()}")
            }
        }
    }

}

fun getPrecedence(operator: Char): Int {
    return when (operator) {
        '+', '-' -> 1
        '*', '/' -> 2
        '^' -> 3
        else -> -1
    }
}


