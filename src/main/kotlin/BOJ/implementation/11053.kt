package BOJ.implementation

// https://www.acmicpc.net/problem/11053

/**
 * 10,20,10,30,20,50 인 경우 가장 긴 수열은 무엇이냐?
 * dp 로
 *
 */
fun main() {
    val n = readln().toInt()
    val array = readln().split(" ").map { it.toInt() }.toMutableList()
    val dp = IntArray(n) {1}

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (array[j] < array[i]) {
                dp[i] = maxOf(dp[i],dp[j]+1)
            }
        }
    }
    println(dp.maxOrNull())
}