package BOJ.dp

// https://www.acmicpc.net/problem/10844

fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { LongArray(10) }
    var answer = 0L

    for (j in 1..9) {
        dp[1][j] = 1L
    }

    for (i in 2..n) {

        dp[i][0] = dp[i - 1][1] % 1_000_000_000L

        dp[i][9] = dp[i - 1][8] % 1_000_000_000L

        for (j in 1..8) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000L
        }
    }

    for (j in 0..9) {
        answer = (answer + dp[n][j]) % 1_000_000_000L
    }

    println(answer)
}