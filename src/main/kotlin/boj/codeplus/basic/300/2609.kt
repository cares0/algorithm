package boj.codeplus.basic.`300`

fun main() {
    System.out.bufferedWriter().use { bw ->
        System.`in`.bufferedReader().use { br ->
            val (a, b) = br.readLine().split(" ").map(String::toInt)
            val gcd = getGcd(a, b)
            bw.write("$gcd\n")
            bw.write("${a * b / gcd}")
        }
    }
}

//fun getGcd(a: Int, b: Int): Int {
//    val r = a % b
//    return if (r == 0) b
//    else getGcd(b, r)
//}

/**
유클리드 호제법 - 최대공약수 구하기
2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 한다면 (단, a > b) a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
이 성질에 따라, b를 r로 나눈 나머지 r'을 구하고, 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.

최소공배수 = a * b / 최대공약수
**/