package BOJ.dp

// https://www.acmicpc.net/problem/11727

/**
 * 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법의 수.
 */
fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 3
    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
    }

    println(dp[n])
}