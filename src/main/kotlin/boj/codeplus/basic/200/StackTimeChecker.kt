package boj.codeplus.basic.`200`

import kotlin.math.absoluteValue
import kotlin.random.Random
import kotlin.system.measureNanoTime

fun main() {
    val commandCount = 100000
    val testAmount = 100

    val commands = initCommand(commandCount)

    val listStackTimes = mutableListOf<Long>()
    val arrayStackTimes = mutableListOf<Long>()
    val results = mutableListOf<String>()

    var listStackWinCount = 0
    var arrayStackWinCount = 0
    var equalCount = 0

    repeat(testAmount) {
        val listStack = ListStack<Int>()
        val arrayStack = ArrayStack<Int>()
        val listStackTime: Long
        val arrayStackTime: Long
        if (it % 2 == 0) {
            listStackTime = measureNanoTime { process(commands, listStack) }
            arrayStackTime = measureNanoTime { process(commands, arrayStack) }
        } else {
            arrayStackTime = measureNanoTime { process(commands, arrayStack) }
            listStackTime = measureNanoTime { process(commands, listStack) }
        }

        listStackTimes.add(listStackTime)
        arrayStackTimes.add(arrayStackTime)

        val difference = listStackTime - arrayStackTime

        val totalResult = if (difference > 0) {
            arrayStackWinCount++
            "ARRAY STACK WIN: ${difference.absoluteValue}NS"
        } else if (difference == 0.toLong()) {
            equalCount++
            "EQUAL: ${difference.absoluteValue}"
        } else {
            listStackWinCount++
            "LIST  STACK WIN: ${difference.absoluteValue}NS"
        }

        results.add("${it + 1}. LIST  STACK: ${listStackTime}NS")
        results.add("${it + 1}. ARRAY STACK: ${arrayStackTime}NS")
        results.add("${it + 1}. $totalResult")
    }

    results.forEach(::println)

    println("LIST  WIN: $listStackWinCount")
    println("ARRAY WIN: $arrayStackWinCount")
    println("EQUAL    : $equalCount")

    println("LIST  AVG: ${listStackTimes.average() / 1000000.0}MS")
    println("ARRAY AVG: ${arrayStackTimes.average() / 1000000.0}MS")
}

private fun process(commands: List<String>, stack: Stack<Int>) {
    commands.forEach { command ->
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

fun initCommand(times: Int): List<String> {
    val commands = mutableListOf<String>()

    repeat(times) {
        val random = Random.Default.nextInt(0, 5)
        val command = when (random % 5) {
            0 -> "push ${Random.Default.nextInt(1, 10)}"
            1 -> "pop"
            2 -> "size"
            3 -> "empty"
            else -> "top"
        }

        commands.add(command)
    }

    return commands
}