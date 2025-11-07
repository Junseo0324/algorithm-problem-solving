package BOJ.dp

import kotlin.math.max

// https://www.acmicpc.net/problem/1932

/**
 *
 */

fun main() {
    val n = readln().toInt()
    val array = Array(n) { IntArray(n) { 0 } }
    val dp = Array(n) { IntArray(n) }

    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        for (i in input.indices) {
            array[it][i] = input[i]
        }
    }

    for (i in 0 until n) {
        dp[0][i] = array[0][i]
    }


    for (i in 1 until n) {
        for (j in 0 until n) {
            if (j-1 >=0) {
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]) + array[i][j]
            } else {
                dp[i][j] = dp[i-1][j] + array[i][j]
            }
        }
    }

    println(dp[n-1].max())
}