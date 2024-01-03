package boj.codeplus.basic.`200`

import boj.codeplus.basic.ArrayStack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val inputSize = br.readLine().toInt()
    val stack = ArrayStack<Int>()

    var lastNumber = 0
    val resultArray = mutableListOf<String>()

    br.use {
        repeat(inputSize) {
            val number = br.readLine().toInt()
            val top = stack.peek()

            if (top != null) {
                if (top < number) {
                    for (i in lastNumber + 1 .. number) {
                        stack.push(i)
                        //bw.write("+\n")
                        resultArray.add("+")
                    }
                    lastNumber = number
                    stack.pop()
                    //bw.write("-\n")
                    resultArray.add("-")
                } else if (top == number) {
                    stack.pop()
                    //bw.write("-\n")
                    resultArray.add("-")
                } else { // top > number
                    println("NO")
                    return
                }
            } else {
                for (i in lastNumber + 1 .. number) {
                    stack.push(i)
                    //bw.write("+\n")
                    resultArray.add("+")
                }
                lastNumber = number
                stack.pop()
                //bw.write("-\n")
                resultArray.add("-")
            }
        }
    }

    resultArray.forEach {
        bw.write("${it}\n")
    }
    bw.flush()
    bw.close()
}