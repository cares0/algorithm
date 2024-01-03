package boj.codeplus.basic.`200`

import boj.codeplus.basic.ListStack

fun main() {
    val inputSize = readln().toInt()
    val stack = ListStack<Int>()

    repeat(inputSize) {
        val command = readln()

        when {
            command.startsWith("push") -> {
                val value = command.substringAfter(" ").toInt()
                stack.push(value)
            }
            command.startsWith("pop") -> {
                println(stack.pop() ?: -1)
            }
            command.startsWith("size") -> {
                println(stack.size())
            }
            command.startsWith("empty") -> {
                println(
                    if (stack.isEmpty()) 1 else 0
                )
            }
            command.startsWith("top") -> {
                println(stack.peek() ?: -1)
            }
        }
    }
}
