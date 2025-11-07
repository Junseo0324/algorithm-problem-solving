package BOJ.dp

import kotlin.math.min

// https://www.acmicpc.net/problem/1149

/**
 * 집이 N개
 * 거리는 선분, 1~ N 번
 * 집은 빨, 초, 파 중 하나로 칠해야 한다.
 * 칠하는 비용이 주어졌을 때, 규칙을 만족하며 모든 집을 칠하는 최소값
- 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
- N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
- i(2<=i<=N-1)번 집의 색은 i-1 , i+1 번 집의 색과 같지 않아야 한다.
 * 2<=N<=1000
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 *
 * dp[n][2]
 */
fun main() {
    val n = readln().toInt()
    val array = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }

    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    dp[0][0] = array[0][0]
    dp[0][1] = array[0][1]
    dp[0][2] = array[0][2]
    for (i in 1..<n) {
        for (j in 0..2) {
            when (j) {
                0 -> {
                    dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + array[i][j]
                }

                1 -> {
                    dp[i][j] = min(dp[i-1][0], dp[i-1][2]) + array[i][j]
                }

                2 -> {
                    dp[i][j] = min(dp[i-1][0], dp[i-1][1]) + array[i][j]
                }
            }
        }
    }

    println(minOf(dp[n-1][0],dp[n-1][1],dp[n-1][2]))

}