package boj.codeplus.basic.`300`

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val number = br.readLine().toInt()

            var result = 1
            for (i in 1 .. number) {
                result *= i
            }

            bw.write("$result")
        }
        bw.flush()
    }
}