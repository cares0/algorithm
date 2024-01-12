package boj.codeplus.basic.`301`

import kotlin.math.absoluteValue

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (brotherSize, position) = br.readLine().split(" ").map(String::toInt)

            val positionDifferences = br.readLine().split(" ").map {
                (position - it.toInt()).absoluteValue
            }

            var temp = positionDifferences[0]
            if (positionDifferences.size != 1) {
                for (i in 1 until positionDifferences.size) {
                    temp = getGcd(positionDifferences[i], temp)
                }
            }
            bw.write("$temp")
        }
        bw.flush()
    }

}

fun getGcd(a: Int, b: Int): Int {
    val r = a % b
    return if (r == 0) b
    else getGcd(b, r)
}
