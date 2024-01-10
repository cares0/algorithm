package boj.codeplus.basic.`203`

fun main() {

    System.out.bufferedWriter().use { bw ->
        val upperCaseRange = 'Z' - 'A' + 1
        val lowerCaseRange = 'z' - 'a' + 1

        val sentence = readln()

        sentence.forEach { char ->

            when {
                char.isUpperCase() -> {
                    bw.write("${Char((((char - 'A') + 13) % upperCaseRange) + 'A'.code)}")
                }
                char.isLowerCase() -> {
                    bw.write("${Char((((char - 'a') + 13) % lowerCaseRange) + 'a'.code)}")
                }
                else -> bw.write("$char")
            }

        }

        bw.flush()
    }

}