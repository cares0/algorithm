package boj.codeplus.basic.`300`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val inputSize = br.readLine().toInt()

            repeat(inputSize) {
                val (a, b) = br.readLine().split(" ").map(String::toInt)

                bw.write("${a * b / getGcd(a, b)}\n")
            }
        }
        bw.flush()
    }

}

fun getGcd(a: Int, b: Int): Int {
    val r = a % b
    return if (r == 0) b
    else getGcd(b, r)
}
