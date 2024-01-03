package boj.codeplus.basic.`201`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val inputSize = br.readLine().toInt()
            val numbers = br.readLine().split(" ").map(String::toInt)
            val notYetIndexStack = ArrayStack<Int>(inputSize)
            val answerList = Array<Int?>(inputSize) { null }
            
            for (i in numbers.indices) {
                while (!notYetIndexStack.isEmpty() && numbers[notYetIndexStack.peek()!!] < numbers[i]) {
                    answerList[notYetIndexStack.pop()!!] = numbers[i]
                }
                notYetIndexStack.push(i)
            }

            while (!notYetIndexStack.isEmpty()) {
                answerList[notYetIndexStack.pop()!!] = -1
            }

            bw.write(answerList.joinToString(" "))
        }
    }
}

fun main2() {
    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        BufferedReader(InputStreamReader(System.`in`)).use { br ->
            val inputSize = br.readLine().toInt()

            val mainDeque = ArrayDeque<Int>()
            br.readLine()
                .split(" ")
                .forEach { mainDeque.add(it.toInt()) }

            val remainingStack = ArrayStack<Int>()

            for (i in 0 until inputSize - 1) {
                var number: Int = mainDeque.removeFirst()
                var last: Int = 0
                var isNotExist = false

                do {
                    if (mainDeque.isEmpty()) {
                        isNotExist = true
                        break
                    }
                    last = mainDeque.removeFirst()
                    remainingStack.push(last)
                } while (number > last)

                while (!remainingStack.isEmpty()) {
                    mainDeque.addFirst(remainingStack.pop()!!)
                }

                if (!isNotExist) {
                    bw.write("$last ")
                } else {
                    bw.write("-1 ")
                }
            }
            bw.write("-1")
        }
        bw.flush()
    }
}