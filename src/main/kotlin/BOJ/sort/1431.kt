package BOJ.sort

/**
 * 시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.
 *
 * A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
 * 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
 * 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
 * 시리얼이 주어졌을 때, 정렬해서 출력하는 프로그램을 작성하시오.
 *
 * 5
 * ABCD
 * 145C
 * A
 * A910
 * Z321
 */
fun main() {
    val n = readln().toInt()
    var array = mutableListOf<String>()

    repeat(n) {
        array.add(readln())
    }

    fun getSum(s: String): Int {
        var sum = 0
        for (char in s) {
            if (char.isDigit()) {
                sum += char - '0'
            }
        }
        return sum
    }

    array.sortWith { s1, s2 ->
        if (s1.length != s2.length) {
            s1.length.compareTo(s2.length)
        } else {
            val sum1 = getSum(s1)
            val sum2 = getSum(s2)

            if (sum1 != sum2) {
                sum1.compareTo(sum2)
            } else {
                s1.compareTo(s2)
            }
        }
    }

    println(array.joinToString("\n"))
}