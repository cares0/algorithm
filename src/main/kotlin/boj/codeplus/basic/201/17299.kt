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
            val str = br.readLine()

            val numbers = Array(inputSize) { 0 }
            val countMap = mutableMapOf<Int, Int>()
            val answerArray = Array(inputSize) { -1 }

            str.split(" ").forEachIndexed { index, value ->
                val number = value.toInt()

                if (countMap[number] != null) {
                    countMap[number] = countMap[number]!! + 1
                } else countMap[number] = 1

                numbers[index] = number
            }

            val notYetStack = ArrayStack<Int>()

            for (i in numbers.indices) {

                while (!notYetStack.isEmpty() && countMap[numbers[notYetStack.peek()!!]]!! < countMap[numbers[i]]!!) {
                    answerArray[notYetStack.pop()!!] = numbers[i]
                }

                notYetStack.push(i)
            }

            if (!notYetStack.isEmpty()) {
                answerArray[notYetStack.pop()!!] = -1
            }

            bw.write(answerArray.joinToString(" "))
        }
    }

}