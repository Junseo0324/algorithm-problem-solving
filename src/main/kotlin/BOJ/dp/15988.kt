package BOJ.dp

// https://www.acmicpc.net/problem/15988

// 1_000_000_009L


fun main() {
    val dp = LongArray(1000001)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..1000000) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009L
    }
    repeat(readln().toInt()) {
        val n = readln().toInt()

        println(dp[n])
    }
}