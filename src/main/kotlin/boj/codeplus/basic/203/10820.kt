package boj.codeplus.basic.`203`

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            while (true) {
                val string = br.readLine() ?: break

                val array = Array(4) { 0 }

                string.forEach { char ->
                    when {
                        char.isLowerCase() -> array[0]++
                        char.isUpperCase() -> array[1]++
                        char.isDigit() -> array[2]++
                        char.isWhitespace() -> array[3]++
                    }
                }

                bw.write("${array.joinToString(" ")}\n")
            }
        }
        bw.flush()
    }
}