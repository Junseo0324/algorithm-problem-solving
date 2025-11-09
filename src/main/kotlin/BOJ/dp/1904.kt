package BOJ.dp

// https://www.acmicpc.net/problem/1904

fun main() {
    val n = readln().toInt()
    val dp = LongArray(n + 1)

    if (n == 1) {
        println(1)
        return
    }
    if (n == 2) {
        println(2)
        return
    }

    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }

    println(dp[n])
}