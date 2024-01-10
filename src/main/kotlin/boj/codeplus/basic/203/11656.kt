package boj.codeplus.basic.`203`

fun main() {

    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->

            val string = br.readLine()

            val stringList = mutableListOf<String>()

            for (i in string.length downTo 1) {
                stringList.add(string.takeLast(i))
            }

            stringList.sorted().forEach { bw.write("$it\n") }
        }
        bw.flush()
    }

}