package BOJ.dp

import kotlin.math.abs

// https://www.acmicpc.net/problem/1788

// 1000000000 으로 나눈 값
fun main() {
    val n = readln().toInt()
    if (n == 0) {
        println(0)
        println(0)
        return
    }

    val absN = abs(n)

    val dp = IntArray(absN + 1)

    if (absN >= 1) {
        dp[1] = 1
    }

    for (i in 2..absN) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000
    }
    val sign = if (n > 0) {
        1
    } else {
        if (absN % 2 == 0) {
            -1
        } else {
            1
        }
    }

    println(sign)
    println(dp[absN])
}