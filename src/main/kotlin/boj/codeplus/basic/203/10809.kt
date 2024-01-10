package boj.codeplus.basic.`203`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val word = br.readLine()

            val array = Array('z' - 'a' + 1) { -1 }

            word.forEachIndexed { index, char ->
                if (array[char - 'a'] == -1) {
                    array[char - 'a'] = index
                }
            }

            bw.write(array.joinToString(" "))
        }
        bw.flush()
    }

}