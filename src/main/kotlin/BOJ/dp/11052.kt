package BOJ.dp

import kotlin.math.max

// https://www.acmicpc.net/problem/11052

/**
 * 1,5,6,7 // 4개를 갖기 위해 최대값 -> 10
 * ㅇdp [n] => n개를 사귀위한 최대 비용
 */
fun main() {
    val n = readln().toInt()
    val p = readln().split(" ").map { it.toInt() }

    val dp = IntArray(n+1)
    dp[0] = 0

    for (i in 1..n) {
        for (k in 1..i) {
            dp[i] = maxOf(dp[i],p[k-1]+dp[i-k])
        }
    }

    println(dp[n])

}