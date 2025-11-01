package BOJ.implementation

// https://www.acmicpc.net/problem/4673
/**
 * n ->d(n) = n과 n의 각 자리수를 더하는 함수
 * d(75) = 75 + 7 + 5 = 97
 * n 은 d(n)의 생성자
 *
 */
fun main() {
    val limit = 10000
    val array = BooleanArray(limit + 1)

    fun d(n: Int): Int {
        var sum = n
        var temp = n
        while (temp > 0) {
            sum += temp % 10
            temp /= 10
        }
        return sum
    }

    for (i in 1..limit) {
        val num = d(i)
        if (num <= limit) {
            array[num] = true
        }
    }

    for (i in 1..limit) {
        if (!array[i]) println(i)
    }
}