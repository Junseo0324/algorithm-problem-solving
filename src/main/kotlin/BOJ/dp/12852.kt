package BOJ.dp

import kotlin.math.min

// https://www.acmicpc.net/problem/12852

fun main() {
    val n = readln().toInt()

    val dp = IntArray(n+1)
    val answer = IntArray(n+1)
    dp[1] = 0

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1)
        }
    }

    println(dp[n])
}