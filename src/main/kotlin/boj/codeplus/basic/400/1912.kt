package boj.codeplus.basic.`400`

fun main() = System.out.bufferedWriter().use { bw ->
    System.`in`.bufferedReader().use { br ->
        val size = br.readLine().toInt()
        
        val numbers = br.readLine().split(" ").map(String::toLong).toTypedArray()

        for (i in 1 until size) {
            val currentNumber = numbers[i]
            val previousNumber = numbers[i - 1]
            if (currentNumber <= currentNumber + previousNumber) {
                numbers[i] = currentNumber + previousNumber
            }
        }

        bw.write("${numbers.max()}")
    }
    bw.flush()
}