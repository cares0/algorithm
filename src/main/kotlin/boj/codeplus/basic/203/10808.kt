package boj.codeplus.basic.`203`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val word = br.readLine()

            val countArray = Array('z' - 'a' + 1) { 0 }

            word.forEach { char ->
                countArray[char - 'a']++
            }

            bw.write(countArray.joinToString(" "))
        }
        bw.flush()
    }

}