package boj.codeplus.basic.`300`


fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->

            val (a, b, c) = br.readLine().split(" ").map(String::toInt)

            bw.write("${(a + b) % c}\n")
            bw.write("${((a % c) + (b % c)) % c}\n")
            bw.write("${(a * b) % c}\n")
            bw.write("${((a % c) * (b % c)) % c}\n")

        }
    }
}