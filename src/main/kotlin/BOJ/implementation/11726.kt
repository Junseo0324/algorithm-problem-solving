package BOJ.implementation

// https://www.acmicpc.net/problem/11726
/**
 * dp[0] = 0
 * dp[1] = 1
 * dp[2] = 2
 * dp[3] = 3
 * dp[4] = 5
 * dp[5] = 8
 *      5 = 1+4, 2+3
 * dp[n] = dp[n-1] + dp[n-2]
 *
 */
fun main() {
    val n = readln().toInt()
    val dp = Array(1001) { 0 }

    dp[0] = 0
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    println(dp[n])
}